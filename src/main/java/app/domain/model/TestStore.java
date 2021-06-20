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

    private List<Test> listTestsinRegDateRange;

    /**
     * List that contains the tests validated.
     */
    private List<Test> listTestsinValDateRange;

    /**
     * String that contains the nhs report.
     */
    private String reportNHS;
    /**
     * List that contains the hpdays.
     */
    private List<Date> hPDays = new ArrayList<>();
    /**
     * List that contains the hpweeksInitial.
     */
    private List<Date> hPWeeksInitial = new ArrayList<>();
    /**
     * List that contains the hpweeksFinal.
     */
    private List<Date> hPWeeksFinal = new ArrayList<>();
    /**
     * List that contains the report weeks.
     */
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
    /**
     * Searches for the client with a specific email.
     * @return the client with specific email.
     */
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
    /**
     * Searches for the test with a specific client.
     * @return the list of tests with specific client.
     */
    public List<Test> getTestsByClient(Client c){
        List<Test> list = new ArrayList<>();
        for (Test test: tests) {
            if(c.equals(test.getClient())){
                list.add(test);
            }
        }
        return list;

    }
    /**
     * Counts the number of clients in a test list.
     * @return number of clients.
     */
    public int contNumberofClients(List<Test> tests){
        List<Client> clients=new ArrayList<>();
        for (Test test: tests){
            if (!clients.contains(test.getClient())){
                clients.add(test.getClient());
            }
        }

        return clients.size();
    }
    /**
     * Counts the number of tests validated in a test list.
     * @return number of tests validated.
     */
    public int contNumberofTestValidated(List<Test> tests){
        int sum=0;
        for (Test test: tests){
            if (test.getValidationDate()!=null){
                sum++;
            }

        }

        return sum;
    }


    /**
     * Gets the tests in the interval
     * @return test list.
     */
    public List<Test> getTestsInIntervalRegistDate(Date startDate, Date endDate){
        listTestsinRegDateRange = new ArrayList<>();

        for(Test test : tests) {

            Calendar cal = Calendar.getInstance();
            cal.setTime(startDate);
            int firstDay = cal.get(Calendar.DAY_OF_YEAR);
            int firstYear = cal.get(Calendar.YEAR);
            cal.setTime(endDate);
            int lastDay = cal.get(Calendar.DAY_OF_YEAR);
            int lastYear = cal.get(Calendar.YEAR);

            cal.setTime(test.getDate());
            int compareDay = cal.get(Calendar.DAY_OF_YEAR);
            int compareYear = cal.get(Calendar.YEAR);

            if (((firstDay==compareDay && firstYear==compareYear) || (lastDay==compareDay && lastYear==compareYear) )|| test.getDate().toInstant().equals(endDate.toInstant()) || (test.getDate().toInstant().isAfter(startDate.toInstant()) && test.getDate().toInstant().isBefore(endDate.toInstant()))) {

                listTestsinRegDateRange.add(test);
            }

        }
        return listTestsinRegDateRange;
    }

    /**
     * Gets the tests validated in the interval
     * @return test list.
     */

    public List<Test> getTestsInInterval(Date startDate, Date endDate){

        listTestsinValDateRange = new ArrayList<>();
        for(Test test : tests){


            if (test.getValidationDate()!=null) {
                if (((test.getValidationDate().equals(startDate)) || (test.getValidationDate().equals(endDate)) ) || (test.getValidationDate().toInstant().isAfter(startDate.toInstant()) && test.getValidationDate().toInstant().isBefore(endDate.toInstant()))) {

                    listTestsinValDateRange.add(test);
                }
            }

        }
        return listTestsinValDateRange;
    }
    /**
     * Gets the Vector for the covid test linear regression
     * @return test array.
     */
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
    /**
     * Gets the Vector for the covid test linear regression (Mean Age)
     * @return test array.
     */
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
    /**
     * Gets the Vector for the covid test linear regression (Positive tests)
     * @return test array.
     */
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

    /**
     * Gets the Vector for the covid test linear regression per day(Positive tests)
     * @return test array.
     */
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
    /**
     * Gets hp days
     * @return hpdays.
     */
    public List<Date> getHPDays(){
        return this.hPDays;
    }
    /**
     * Gets the Vector for the covid test linear regression per week(Positive tests)
     * @return test array.
     */
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
    /**
     * calculate the new subtracted date
     * @return test new date
     */
    public static Date subtractDays(Date date, int days) {

        Date dateAux = new Date(date.getTime());
        dateAux.setHours(dateAux.getHours()-(24*days));

        return dateAux;
    }
    /**
     * Gets hp weeks initial
     * @return hp weeks initial.
     */
    public List<Date> gethPWeeksInitial(){
        return hPWeeksInitial;
    }


    /**
     * Gets hp weeks final
     * @return hp weeks final.
     */
    public List<Date> gethPWeeksFinal(){
        return hPWeeksFinal;
    }

    /**
     * calculate the new adactive date
     * @return test new date
     */

    public static Date addDays(Date date, int days) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);

        return cal.getTime();
    }

    /**
     * Return the positive tests
     * @return test positives
     */

    public int getPositiveTests(Date startDate, Date endDate, Date date){
        int a = 0;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DAY_OF_YEAR);
        int year = cal.get(Calendar.YEAR);

        for (Test t: getTestsInIntervalRegistDate(startDate, endDate)){
            if(t.getValidationDate()!=null) {
                cal.setTime(t.getDate());
                int compareDay = cal.get(Calendar.DAY_OF_YEAR);
                int compareYear = cal.get(Calendar.YEAR);
                if (compareDay == day && compareYear == year) {
                    if (!t.getResults().isEmpty()) {
                        if (t.getResults().get(0) > 1.4) {
                            a++;
                        }
                    }
                }
            }
        }
        return a;

    }
    /**
     * Return the positive tests per week
     * @return test positives per weeks
     */
    public int getPositivePerWeekTests(Date startDate, Date endDate){
        int a = 0;
        for (Test t: getTestsInIntervalRegistDate(startDate, endDate)){
            if(t.getValidationDate()!=null) {
                if (t.getLabOrder().getTestType().getDescription().equalsIgnoreCase("covid")) {
                    if (!t.getResults().isEmpty()) {
                        if (t.getResults().get(0) > 1.4) {
                            a++;
                        }
                    }
                }
            }
        }

        return a;

    }
    /**
     * Return the tests
     * @return test
     */
    public int getTests(Date startDate, Date endDate, Date date){
        int a = 0;

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DAY_OF_YEAR);
        int year = cal.get(Calendar.YEAR);

        for (Test t: getTestsInIntervalRegistDate(startDate, endDate)) {
            if (t.getValidationDate() != null) {
                if (t.getLabOrder().getTestType().getDescription().equalsIgnoreCase("covid")) {
                    cal.setTime(t.getDate());
                }
                int compareDay = cal.get(Calendar.DAY_OF_YEAR);
                int compareYear = cal.get(Calendar.YEAR);
                if (compareDay == day && compareYear == year) {
                    a++;
                }

            }
        }

        return a;
        }
    /**
     * Return the mean age per day
     * @return the mean age per day
     */
        public double getMeanAgeForDay(Date startDate, Date endDate, Date date){
            int a = 0;
            double sumAge = 0;

            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int day = cal.get(Calendar.DAY_OF_YEAR);
            int year = cal.get(Calendar.YEAR);

            for (Test t: getTestsInIntervalRegistDate(startDate, endDate)){
                if(t.getValidationDate()!=null) {
                    cal.setTime(t.getDate());
                    int compareDay = cal.get(Calendar.DAY_OF_YEAR);
                    int compareYear = cal.get(Calendar.YEAR);
                    if (compareDay == day && compareYear == year) {
                        a++;
                        sumAge += t.getClient().calculateAge(t.getClient().getBirth());
                    }
                }
            }
            if(a!=0) {
                return (sumAge / a);
            }else{
                return a;
            }
        }

    /**
     * Return the mean age hpday
     * @return the mean age hpday
     */
        public double[] getMeanAgeForHpDay(Date currentDate, int hP){
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
                    c[l] = getMeanAgeForDay(firstDay, currentDate, cal.getTime());
                    l++;
                }
                count++;
                cal.setTime(addDays(firstDay, count));
            }while (l<c.length);

            return c;
        }
    /**
     * Return the tests for hp
     * @return test tests for hp
     */
        public double[] getTestForHp(Date currentDate, int hP){
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
                    c[l] = getTests(firstDay, currentDate, cal.getTime());
                    l++;
                }
                count++;
                cal.setTime(addDays(firstDay, count));
            }while (l<c.length);

            return c;
        }
    /**
     * Return the covid tests for weekHp
     * @return the covid tests for weekHp
     */
        public double[] getCovidTestsForWeekHp(Date currentDate, int hP){
            Calendar cal = Calendar.getInstance();
            cal.setTime(currentDate);
            double[] c = new double[hP];
            int numOfTests;
            int day = cal.get(Calendar.DAY_OF_WEEK);
            Date date = subtractDays(currentDate, day - 2);
            date = subtractDays(date, 7 * hP);
            for (int i = 0; i < hP; i++) {
                cal.setTime(date);
                Date date2 = addDays(date, 5);
                numOfTests = getCovidTestForAWeek(date, date2);
                c[i] = numOfTests;
                hPWeeksInitial.add(date);
                hPWeeksFinal.add(date2);
                date = addDays(date, 7);
            }

            return c;
        }
    /**
     * Return the covid tests for a week
     * @return test covid tests for a week
     */
        public int getCovidTestForAWeek(Date date, Date date2){
            int a = 0;
            for (Test t: getTestsInIntervalRegistDate(date, date2)){
                if(t.getValidationDate()!=null) {
                    if (t.getLabOrder().getTestType().getDescription().equalsIgnoreCase("covid")) {
                        a++;
                    }
                }
            }

            return a;
        }
    /**
     * Return the mean age hp week
     * @return the mean age hp week
     */
    public double[] getMeanAgeForHPWeek(Date currentDate, int hP) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        double[] c = new double[hP];
        int day = cal.get(Calendar.DAY_OF_WEEK);
        Date date = subtractDays(currentDate, day - 2);
        date = subtractDays(date, 7 * hP);
        for (int i = 0; i < hP; i++) {
            cal.setTime(date);
            Date date2 = addDays(date, 5);
            c[i] = getMeanAgeForWeek(date, date2);
            hPWeeksInitial.add(date);
            hPWeeksFinal.add(date2);
            date = addDays(date, 7);
        }

        return c;
    }
    /**
     * Return the mean age week
     * @return the mean age week
     */
    public double getMeanAgeForWeek(Date date1, Date date2){
        int a = 0;
        int sumAge = 0;
        for (Test t: getTestsInIntervalRegistDate(date1, date2)){
            if(t.getValidationDate()!=null) {
                if (t.getLabOrder().getTestType().getDescription().equalsIgnoreCase("covid")) {
                    a++;
                    sumAge += t.getClient().calculateAge(t.getClient().getBirth());
                }
            }
        }
        if(a!=0) {
            return (sumAge / a);
        }else{
            return a;
        }
    }

}


