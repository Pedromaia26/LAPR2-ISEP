package app.domain.model;

import app.controller.App;
import auth.domain.model.Email;
import app.serialization.Serialization;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestStore {

    /**
     * List that contains the tests.
     */
    private List<Test> tests;

    /**
     * Object used to save the information.
     */
    private Serialization ser = new Serialization();

    /**
     * List that contains the tests to be reported.
     */
    /*private List<Test> testsToBeReported;*/

    private List<Test> listTestsinRegDateRange;

    private List<Test> listTestsinValDateRange;


    public Test createTest (Company company, Client client, String nhsCode, LabOrder labOrder, Laboratory lab) {
        return new Test(company, client, nhsCode, labOrder, lab);
    }

    public Test createTest (Company company, Client client, String nhsCode, LabOrder labOrder, Laboratory lab, String data) throws ParseException {
        return new Test(company, client, nhsCode, labOrder, lab, data);
    }

    /**
     * Validates the Test received.
     * @param ts the Test to be validated.
     * @return True if the Test is successfully validated, false if it is not.
     */

    public boolean validateTest (Test ts){
        if (ts == null)
            return false;
        return !this.tests.contains(ts);
    }


    public TestStore(){
        tests = new ArrayList<>();
    }

    /**
     * Returns the list of existing tests.
     * @return list of tests.
     */
    public List<Test> getTests() {
        return tests;
    }


    /**
     * Adding a test to the tests list.
     * @param test receives by parameter the test to be added to the list.
     */
    public void addToList (Test test){
        tests.add(test);
    }

    /**
     * Returns a given test, receiving by parameter the barcode of a sample associated with the test.
     * @param barcode the barcode of a test sample.
     * @return the test.
     */

    public Test getTestByBarcode(String barcode){
        for (Test test: tests) {
            for (Sample samples : test.getSample()) {
                if (barcode.equals(samples.getBarcode().getBarcodeNumber()))
                    return test;

            }
        }
        throw new IllegalArgumentException("There is no Sample with such barcode!");
    }

    /**
     * Returns a given test, receiving by parameter the code of a test.
     * @param code the code of the test.
     * @return the test.
     */
    public Test getTestByCode(String code){
        for (Test test: tests) {
            if (code.equals(test.getCode()))
                return test;

        }

        throw new IllegalArgumentException("There is no Sample with such barcode!");
    }

    public List<Test> getTestsByClient(Email id){
        List<Test> list = new ArrayList<>();
        for (Test test: tests) {
            if(String.valueOf(test.getClientId()).equals(id.toString())){
                list.add(test);
            }
        }
        return list;
    }

    /**
     * Saves the Test received.
     * @param ts Test to be saved.
     * @return True if the Test is successfully saved, false if it is not.
     */

    public boolean saveTest (Test ts){
        if (!validateTest(ts))
            return false;
        tests.add(ts);
        save();
        return true;
    }

     /**
     * Marks the test as validated
     * @param code The code of the test to validate
     */
    public void validateWorkDone(String code) throws IOException{
        Test test = getTestByCode(code);
        test.validateTest();
        save();
    }

    public void save(){
        ser.escrever((List<Object>) (List<?>) tests, "test.ser");
    }

    public void read(Company c){
        tests = (List<Test>) (List<?>) ser.ler("test.ser");
    }

    public List<Test> getTestsByClient(Client c){
        List<Test> list = new ArrayList<>();
        for (Test test: tests) {
            if(c.equals(test.getClient())){
                list.add(test);
            }
        }
        return list;

    }
    public List<Test> getTestsInInterval(Date startDate, Date endDate){

        listTestsinRegDateRange = new ArrayList<>();
        listTestsinValDateRange = new ArrayList<>();
        for(Test test : tests){


            if ((test.getDate().toInstant().equals(startDate.toInstant()) || test.getDate().toInstant().equals(endDate.toInstant()) )|| (test.getDate().toInstant().isAfter(startDate.toInstant()) && test.getDate().toInstant().isBefore(endDate.toInstant()))){

                listTestsinRegDateRange.add(test);
            }
            if (test.getValidationDate()!=null) {
                if ((test.getValidationDate().toInstant().equals(startDate.toInstant()) || test.getValidationDate().toInstant().equals(endDate.toInstant())) || (test.getValidationDate().toInstant().isAfter(startDate.toInstant()) && test.getValidationDate().toInstant().isBefore(endDate.toInstant()))) {

                    listTestsinValDateRange.add(test);
                    System.out.println(listTestsinRegDateRange);
                }
            }

        }
        return listTestsinValDateRange;
    }

    public void getCovidTestsPerDay(Date startDate, Date endDate){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);


        long difference= Math.abs(endDate.getTime() - startDate.getTime());
        long diff = TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS)+1;
        int a = (int)diff;
        System.out.println("Dias(tamanho do array))");
        System.out.println(diff);
        int[] c = new int[a];
        for (Test t:  getTestsInInterval(startDate, endDate)) {

            if (t.getLabOrder().getTestType().getDescription().equalsIgnoreCase("Covid-19")) {
                // System.out.println(t.getValidationDate());
                long dif = Math.abs(t.getValidationDate().getTime() - startDate.getTime());
                long p = TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS) - 1;
                int pos = (int) p;
                c[pos]++;
            }


        }
        for (int i = 0; i < c.length; i++) {
            System.out.printf("Number of performed Covid-19 tests at %s:\n", formatter.format(cal.getTime()));
            System.out.println(c[i]);
            cal.add(Calendar.DATE, 1);
        }
    }
    public void getPositiveCovidTestsPerDay(Date startDate, Date endDate){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);


        long difference= Math.abs(endDate.getTime() - startDate.getTime());
        long diff = TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS)+1;
        int a = (int)diff;
        System.out.println("Dias(tamanho do array))");
        System.out.println(diff);
        int[] c = new int[a];
        for (Test t:  getTestsInInterval(startDate, endDate)) {



            if (t.getLabOrder().getTestType().getDescription().equalsIgnoreCase("Covid-19")) {
                if (!t.getResults().isEmpty()){
                    System.out.println(t.getResults());
                    if (t.getResults().get(0)>1.4){
                        // System.out.println(t.getValidationDate());
                        long dif = Math.abs(t.getValidationDate().getTime() - startDate.getTime());
                        long p = TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS) - 1;
                        int pos = (int) p;
                        c[pos]++;
                    }
                }

            }

        }
        for (int i = 0; i < c.length; i++) {
            System.out.printf("Number of positive Covid-19 tests: %s\n", formatter.format(cal.getTime()));
            System.out.println(c[i]);
            cal.add(Calendar.DATE, 1);
        }
    }

}

