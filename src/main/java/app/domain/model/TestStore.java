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
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.*;
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

    private String reportNHS;

    private List<Date> hPDays = new ArrayList<>();

    private List<Date> hPWeeksInitial = new ArrayList<>();

    private List<Date> hPWeeksFinal = new ArrayList<>();

    private List<String> reportWeeks = new ArrayList<>();


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

        throw new IllegalArgumentException("There is no Test with such code!");
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
            Calendar cal = Calendar.getInstance();
            cal.setTime(startDate);
            int firstDay = cal.get(Calendar.DAY_OF_YEAR);
            int firstYear = cal.get(Calendar.YEAR);
            cal.setTime(endDate);
            int lastDay = cal.get(Calendar.DAY_OF_YEAR);
            int lastYear = cal.get(Calendar.YEAR);

            if (test.getValidationDate()!=null) {
                cal.setTime(test.getValidationDate());
                int compareDay = cal.get(Calendar.DAY_OF_YEAR);
                int compareYear = cal.get(Calendar.YEAR);
                if (((firstDay==compareDay && firstYear==compareYear) || (lastDay==compareDay && lastYear==compareYear) ) || (test.getValidationDate().toInstant().isAfter(startDate.toInstant()) && test.getValidationDate().toInstant().isBefore(endDate.toInstant()))) {

                    listTestsinValDateRange.add(test);
                }
            }

        }
        return listTestsinValDateRange;
    }

    public double[] covidTestsLinearRegression(Date startDate, Date endDate){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        List<Date> dateList = new ArrayList<>();
        int dayOfWeek = 0;

        long difference = Math.abs(endDate.getTime() - startDate.getTime());
        long diff = TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS) + 1;
        int a = (int) diff;

        for (int j = 0; j < a; j++) {
            cal.setTime(addDays(startDate, j));
            if (cal.get(Calendar.DAY_OF_WEEK) != 1) {
                dayOfWeek++;
                dateList.add(cal.getTime());
            }
        }

        double[] c = new double[dayOfWeek];

        int l = 0;

        cal.setTime(startDate);

        for(Date d : dateList){
            c[l] = getTests(startDate, endDate, d);
            l++;
        }

        return c;
    }

    public double[] meanAgeLinearRegression(Date startDate, Date endDate){
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        List<Date> dateList = new ArrayList<>();
        int dayOfWeek = 0;

        long difference = Math.abs(endDate.getTime() - startDate.getTime());
        long diff = TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS) + 1;
        int a = (int) diff;

        for (int j = 0; j < a; j++) {
            cal.setTime(addDays(startDate, j));
            if (cal.get(Calendar.DAY_OF_WEEK) != 1) {
                dayOfWeek++;
                dateList.add(cal.getTime());
            }
        }

        double[] c = new double[dayOfWeek];

        int l = 0;

        cal.setTime(startDate);

        for(Date d : dateList){
            c[l] = getMeanAgeForDay(startDate, endDate, d);
            l++;
        }
        return c;
    }

    public double[] positiveCovidTestsLinearRegression(Date startDate, Date endDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);

        Date date = new Date(startDate.getTime());



        long difference = Math.abs(endDate.getTime() - startDate.getTime());
        long diff = TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS) + 1;
        int a = (int) diff;
        Calendar calend = Calendar.getInstance();
        int dayOfWeek = 0;
        List<Date> dateList = new ArrayList<>();
        for (int j = 0; j < a; j++) {
            calend.setTime(addDays(startDate, j));
            if (calend.get(Calendar.DAY_OF_WEEK) != 1) {
                dayOfWeek++;
                getPositiveTests(startDate, endDate, calend.getTime());
                dateList.add(calend.getTime());
            }
        }
        double[] c = new double[dayOfWeek];

        int l = 0;
        int count = 0;
        calend.setTime(startDate);
        do{
            if (calend.get(Calendar.DAY_OF_WEEK) != 1) {
                c[l] = getPositiveTests(startDate, endDate, calend.getTime());
                l++;
            }
            count++;
            calend.setTime(addDays(startDate, count));
        }while (l<c.length);

        return c;
    }


    public double[] getPositiveCovidTestsPerDay(Date currentDate, int hP){
        List<Date> dayList = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        int u = 0;
        int aux = 1;
        do{
            Date date = subtractDays(currentDate, aux);
            cal.setTime(date);
            if(cal.get(Calendar.DAY_OF_WEEK)!=1){
                dayList.add(date);
                u++;
            }
            aux++;
        }while(u<hP);

        for(Date date : dayList){
            this.hPDays.add(new Date(date.getTime()));
        }

        Date firstDay = dayList.get(u-1);

        double[] c = new double[hP];

        List<Date> dateList = new ArrayList<>();


        int sum = 0;
        int j = 0;

        do{
            cal.setTime(addDays(firstDay, sum));
            if (cal.get(Calendar.DAY_OF_WEEK) != 1) {
                getPositiveTests(firstDay, currentDate, cal.getTime());
                dateList.add(cal.getTime());
                j++;
            }
            sum++;
        }while(j<hP);




        cal.setTime(firstDay);
        int l = 0;
        int count = 0;
        do{

            if (cal.get(Calendar.DAY_OF_WEEK) != 1) {
                c[l] = getPositiveTests(firstDay, currentDate, cal.getTime());
                l++;
            }
            count++;
            cal.setTime(addDays(firstDay, count));
        }while (l<c.length);


        return c;


    }

    public List<Date> getHPDays(){
        return this.hPDays;
    }

    public double[] getPositiveCovidTestsPerWeek(Date currentDate, int hP) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        double[] c = new double[hP];
        int numOfPositiveTests;
        int day = cal.get(Calendar.DAY_OF_WEEK);
        Date date = subtractDays(currentDate, day - 2);
        date = subtractDays(date, 7 * hP);
        for (int i = 0; i < hP; i++) {
            cal.setTime(date);
            Date date2 = addDays(date, 5);
            numOfPositiveTests = getPositivePerWeekTests(date, date2);
            c[i] = numOfPositiveTests;
            hPWeeksInitial.add(date);
            hPWeeksFinal.add(date2);
            date = addDays(date, 7);
        }

        return c;
    }

    public static Date subtractDays(Date date, int days) {
//        GregorianCalendar cal = new GregorianCalendar();
//        cal.setTime(date);
//        cal.add(Calendar.DATE, -days);
        Date dateAux = new Date(date.getTime());
        dateAux.setHours(dateAux.getHours()-(24*days));

        return dateAux;
    }

    public List<Date> gethPWeeksInitial(){
        return hPWeeksInitial;
    }

    public List<Date> gethPWeeksFinal(){
        return hPWeeksFinal;
    }

    public static Date addDays(Date date, int days) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);

        return cal.getTime();
    }

    public int getPositiveTests(Date startDate, Date endDate, Date date){
        int a = 0;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DAY_OF_YEAR);
        int year = cal.get(Calendar.YEAR);

        for (Test t: getTestsInInterval(startDate, endDate)){
            cal.setTime(t.getValidationDate());
            int compareDay = cal.get(Calendar.DAY_OF_YEAR);
            int compareYear = cal.get(Calendar.YEAR);
            if (compareDay == day && compareYear == year){
                if (!t.getResults().isEmpty()){
                    if (t.getResults().get(0)>1.4){
                        a++;
                    }
                }
            }
        }
        return a;

    }

    public int getPositivePerWeekTests(Date startDate, Date endDate){
        int a = 0;
        for (Test t: getTestsInInterval(startDate, endDate)){
            if(t.getLabOrder().getTestType().getDescription().equalsIgnoreCase("covid")) {
                if (!t.getResults().isEmpty()) {
                    if (t.getResults().get(0) > 1.4) {
                        a++;
                    }
                }
            }
        }

        return a;

    }

    public int getTests(Date startDate, Date endDate, Date date){
        int a = 0;

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DAY_OF_YEAR);
        int year = cal.get(Calendar.YEAR);

        for (Test t: getTestsInInterval(startDate, endDate)){
            if(t.getLabOrder().getTestType().getDescription().equalsIgnoreCase("covid"))
            cal.setTime(t.getValidationDate());
            int compareDay = cal.get(Calendar.DAY_OF_YEAR);
            int compareYear = cal.get(Calendar.YEAR);
            if (compareDay == day && compareYear == year){
                    a++;
                }

            }
        return a;
        }

        public double getMeanAgeForDay(Date startDate, Date endDate, Date date){
            int a = 0;
            double sumAge = 0;

            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int day = cal.get(Calendar.DAY_OF_YEAR);
            int year = cal.get(Calendar.YEAR);

            for (Test t: getTestsInInterval(startDate, endDate)){
                cal.setTime(t.getValidationDate());
                int compareDay = cal.get(Calendar.DAY_OF_YEAR);
                int compareYear = cal.get(Calendar.YEAR);
                if (compareDay == day && compareYear == year){
                    a++;
                    sumAge += t.getClient().calculateAge(t.getClient().getBirth());
                }
            }
            if(a!=0) {
                return (sumAge / a);
            }else{
                return a;
            }
        }
}


