package app.domain.model;

import app.controller.App;
import auth.domain.model.Email;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test implements Serializable, Comparable<Test> {


    /**
     * Data of sample regist.
     */
    private Date sampleData;
    /**
     * Laboratory of a test.
     */
    private Laboratory lab;
    /**
     * Doubles List that contains the results of a test.
     */
    private List<Double> results;
    /**
     * String that contains the code of a test.
     */
    private String code;

    /**
     * The National Healthcare Service code.
     */
    private String nhsCode;
    /**
     * Date of date registration.
     */
    private Date date;
    /**
     * The copy data used to create a sequence.
     */
    private Date fakeDate;

    /**
     * The parameter of a given test.
     */
    private TestParameter tp;
    /**
     * metric of a given test.
     */
    private String metric;

    /**
     * The lab order prescribed by a doctor that contains the type of tests and parameter of a test being analysed.
     */
    private LabOrder labOrder;
    /**
     * client of a test.
     */
    private Client client;

    private Long tinNumber;
    /**
     * The external module that provides reference values to be compared to the results of a parameter.
     */
    private ExternalModule em;
    /**
     * A list containing the parameters of a test.
     */
    private List<TestParameter> testParameterList;
    /**
     * An object of type Date used to obtain the date when a result of a test was recorded.
     */
    private Date resultRegist;

    private Date fakeResultRegist;


    /**
     * An object of type Date used to record the date when a test was validated.
     */
    private Date validationDate;

    private Date fakeValidationDate;
    /**
     * The report associated to each test.
     */
    private Report report;
    /**
     * List containing the samples.
     */
    private List<Sample> sample = new ArrayList<>();

    /**
     * Empty constructor that initializes a list of parameters test.
     */

    private ReferenceValue ref;

    private List<String> testParameterResultList;

    public Test() {
        testParameterList = new ArrayList<>();
        results = new ArrayList<>();
        testParameterResultList = new ArrayList<>();
    }
    /**
     * Counts the total of tests in the system.
     * @return the next test code.
     */
    public String createTestCode(Company company) {

        List<Test> tests = company.getTestStore().getTests();
        int c = 1;
        for (Test testss : tests) {
            c++;
        }

        DecimalFormat df = new DecimalFormat("000000000000");
        return df.format(c);
    }

    /**
     * Creates an instance of Test, receiving by parameter its code, its National Healthcare Service code
     * and the lab order associated to the test.
     *
     * @param nhsCode  National Healthcare Service code of the test.
     * @param labOrder lab order prescribed by the doctor for a given test.
     */
    public Test(Company company, Client client, String nhsCode, LabOrder labOrder, Laboratory lab) {

        this.code = createTestCode(company);

        if (String.valueOf(nhsCode).length() != 12)
            throw new IllegalArgumentException("National Health Service Code should have 12 digits");

        this.nhsCode = nhsCode;

        if (String.valueOf(client.getTif()).length() != 10)
            throw new IllegalArgumentException("Tax Identification Number should have 10 digits");
        this.client = client;

        this.labOrder = labOrder;


        testParameterList = new ArrayList<>();
        testParameterList = addToList(labOrder.getParameters());

        results = new ArrayList<>();


        this.date = new Date();

        this.fakeDate=new Date();

        this.lab=lab;
    }

    public Test(Company company, Client client, String nhsCode, LabOrder labOrder, Laboratory lab, String data) throws ParseException {

        this.code = createTestCode(company);

        if (String.valueOf(nhsCode).length() != 12)
            throw new IllegalArgumentException("National Health Service Code should have 12 digits");

        this.nhsCode = nhsCode;

        if (String.valueOf(client.getTif()).length() != 10)
            throw new IllegalArgumentException("Tax Identification Number should have 10 digits");
        this.client = client;

        this.labOrder = labOrder;


        testParameterList = new ArrayList<>();
        testParameterList = addToList(labOrder.getParameters());

        results = new ArrayList<>();

        this.date = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(data);

        this.fakeDate=new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(data);

        this.lab=lab;
    }

    /**
     * Set the sample data
     */
    public void setSampleData(String sampleData) throws ParseException {
        try {
            this.sampleData = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(sampleData);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Returns the code of a test.
     *
     * @return the code of a test .
     */

    public String getCode() {
        return code;
    }

    /**
     * Returns the National Health Service code of a test.
     *
     * @return the National Health Service code of a test.
     */

    public String getNhsCode() {
        return nhsCode;
    }


    /**
     * Returns the lab order of a test.
     *
     * @return the lab order.
     */

    public LabOrder getLabOrder() {
        return labOrder;
    }

    /**
     * Returns the list of existing samples.
     *
     * @return list of samples.
     */

    public List<Sample> getSample() {
        return sample;
    }

    /**
     * Returns the list of parameters of a test.
     *
     * @return list of parameters of a test.
     */

    public List<TestParameter> getTestParameter() {
        return testParameterList;
    }

    /**
     * Returns the Id of the associated client
     *
     * @return the Id of the client
     */

    public Email getClientId() { return client.getEmail(); }

    /**
     * Returns the report of a test
     *
     * @return the report of a test
     */

    public Report getReport() {
        return report;
    }

    /**
     * Returns the test parameter from a test.
     *
     * @param parameterCode receives a parameter code by parameter and proceeds to check if this code exists.
     * @return the test parameter intended if the code exists. If not, informs the user that the code does not exist.
     */
    public TestParameter getTestParameterFor(String parameterCode) {
        for (TestParameter testParam : testParameterList) {
            if (parameterCode.equals(testParam.getParameter().getCode()))
                return testParam;
        }
        throw new IllegalArgumentException("There is no parameter with such code");
    }



    /**
     * Compares an object of test that evokes the method with another.
     *
     * @param o The object to compare.
     * @return True if both objects are equal and false if not.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return Objects.equals(code, test.code) && Objects.equals(nhsCode, test.nhsCode) && Objects.equals(labOrder, test.labOrder);
    }

    /**
     * Returns the textual description of a test.
     *
     * @return characteristics of a test.
     */
    public String toString() {
        return "Test:Code:" + code + labOrder + ", sample=" + sample;
    }

    /**
     * Validates the sample received.
     *
     * @param samp the sample to be validated.
     * @return True if the sample is successfully validated, false if it is not.
     */
    public boolean validateSample(Sample samp, Company company) {
        if (samp == null)
            return false;

        List<Test> tests = company.getTestStore().getTests();
        for (Test testss : tests) {
            for (Sample samples : testss.getSample()) {
                if (samples.getBarcode().equals(samp.getBarcode())) {
                    return false;

                }
            }
        }
        return true;
    }
    /**
     * Returns the client.
     * @return the client.
     */
    public Client getClient() {
        return client;
    }

    public boolean validateTestParameterResult(String testResult) {
        if (testResult == null)
            return false;
        return (!this.testParameterResultList.contains(testResult));
    }

    public boolean saveTestParameterResult(String testResult) {
        if(testParameterResultList == null) {
            testParameterResultList = new ArrayList<>();
        }

        if (validateTestParameterResult(testResult)) {
            testParameterResultList.add(testResult);
            return true;
        } else {
            return false;
        }


    }

    /**
     * Saves the sample received in the test.
     *
     * @param samp the sample to be saved.
     * @return True if the sample is successfully saved, false if it is not.
     */
    public boolean saveSample(Sample samp, Company company, String data) throws OutputException, ParseException {
        if (!validateSample(samp, company))
            return false;

        samp.imageIoWrite(samp.barcodeImage(samp.getBarcode()), samp.getBarcode().getBarcodeNumber());

        setSampleData(data);
        //samp.showBarcodes(samp.getBarcode());

        return addSample(samp);
    }

    /**
     * Adds a sample to the list of samples.
     *
     * @param samp the sample to be added.
     * @return true if samp is sucessfully added
     */
    public boolean addSample(Sample samp) {
        return this.sample.add(samp);

    }

    /**
     * Save the report created with the diagnosisText
     *
     * @param diagnosisText the text to be added to report
     */
    public void addReport(String diagnosisText) {
        this.report = new Report(diagnosisText);

    }

    public void addReport(String diagnosisText, String data) throws ParseException {
        this.report = new Report(diagnosisText, data);

    }

    /**
     * Create a new sample with the dto received.
     *
     * @return The Sample created.
     */
    public Sample RecordNewSample(Company c) throws BarcodeException, IllegalAccessException, ClassNotFoundException, InstantiationException, OutputException, IOException, ParseException {
        return new Sample(c);
    }




    /**
     * Adds a result to a parameter of a test, comparing the value received by parameter
     * and the existing reference values provided by the external module.
     *
     * @param parameterCode the code of the parameter for which we pretend to add a result.
     * @param result        the value obtained from a test parameter of a given client.
     */
    public String addTestParameterResult(String barcode, String parameterCode, Double result, String metric) throws ClassNotFoundException, InstantiationException, IllegalAccessException, BarcodeException, ParseException, OutputException, IOException {

        checkResultRules(result);
        this.tp = getTestParameterFor(parameterCode);
        this.ref = getExternalModule().getReferenceValue(tp.getParameter());
        this.metric = getExternalModule().getReferenceValue(tp.getParameter()).getMetric();
        tp.addResult(result, metric, ref);
        resultRegist = new Date();
        this.fakeResultRegist=new Date();
        results.add(tp.getTpr().getValue());
        System.out.println(results);
        String testPResult = compareValues(barcode);
        return testPResult;
    }
    /**
     * Adds a result to a parameter of a test, comparing the value received by parameter
     * and the existing reference values provided by the external module.
     *
     * @param parameterCode the code of the parameter for which we pretend to add a result.
     * @param result        the value obtained from a test parameter of a given client.
     */
    public String addTestParameterResult(String barcode, String parameterCode, Double result, String metric, String data) throws ClassNotFoundException, InstantiationException, IllegalAccessException, ParseException, OutputException, IOException, BarcodeException {
        checkResultRules(result);
        this.tp = getTestParameterFor(parameterCode);
        this.ref = getExternalModule().getReferenceValue(tp.getParameter());
        this.metric = getExternalModule().getReferenceValue(tp.getParameter()).getMetric();
        tp.addResult(result, metric, ref);
        resultRegist = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(data);
        this.fakeResultRegist=new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(data);
        String testPResult = compareValues(barcode);
        results.add(tp.getTpr().getValue());
        return testPResult;
    }

    /**
     * Compares the values written by the clinical chemistry technologist with the reference values provided by the external module,
     * and informs the user about the results.
     */

    public String compareValues(String barcode) {
        TestParameterResult tpr = tp.getTpr();
        Double min;
        Double max;
        String result;
        min = tpr.getRefValue().getMinimum();
        max = tpr.getRefValue().getMaximum();
        if (tpr.getMetric().equals(this.metric)){
            if (tpr.getValue() < min || tpr.getValue() > max) {
                System.out.printf("The result of the parameter '%s' is outside of the reference range!\n", tp.getParameter().getShortName());
                result = barcode + "_" + tp + "_outOfRange";
            } else {
                System.out.printf("The result of the parameter '%s' is among the reference values!\n", tp.getParameter().getShortName());
                result = barcode + "_" + tp + "_inRange";
            }
        }else{
            throw new IllegalArgumentException("The metric used does not correspond to the metric of the parameter!");
        }
        return result;
    }


    public List<TestParameter> addToList(List<Parameter> p) {
        for (Parameter par : p) {
            testParameterList.add(new TestParameter(par));
        }
        return testParameterList;
    }

    /**
     * Checks the parameter result restrictions
     *
     * @param result the result of a given parameter of a test.
     */
    public void checkResultRules(Double result) {
        if (result < 0)
            throw new IllegalArgumentException("The result cannot be negative!");
    }

    /**
     * Select the right External module by config file .
     * @return the right adapter.
     */

    public ExternalModule getExternalModule() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, OutputException, ParseException, BarcodeException {
        Properties prop = App.getInstance().getprops();
        String classaux = prop.getProperty(labOrder.getTestType().getApi());
        Class<?> oClass = Class.forName(classaux);
        return (ExternalModule) oClass.newInstance();
    }

    /**
     * Mark the test as validated
     */


    public void validateTest() throws IOException {

        validationDate = new Date();
        this.fakeValidationDate=new Date();

        client.notifyClient();
    }
    /**
     * Mark the test as validated
     */
    public void validateTest(String data) throws IOException, ParseException {

        validationDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(data);
        fakeValidationDate=new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(data);

        client.notifyClient();

    }



    /**
     * Returns the date when results were registered
     *
     * @return the date when results were registered
     */
    public Date getResultRegist() {
        return resultRegist;
    }

    /**
     * Returns the date when the test was registered
     *
     * @return the date when the test was registered
     */
    public Date getDate() {
        return date;
    }

    public List<String> getTestParameterResultList() {
        return testParameterResultList;
    }

    /**
     * Returns the date when the test was validated
     *
     * @return the date when the test was validated
     */
    public Date getValidationDate() {
        return validationDate;
    }
    /**
     * Searches for the Samples with a specific barcode.
     * @return the sample with specific barcode.
     */
    public Sample getSampleByBarcode(String barcode) {
        for (Sample samp : sample) {
            if (barcode.equals(samp.getBarcode().getBarcodeNumber())) {
                return samp;
            }
        }
        throw new IllegalArgumentException("There is no sample with such barcode!");
    }

    /**
     * Returns thelab
     *
     * @return the lab
     */
    public Laboratory getLab() {
        return lab;
    }

    /**
     * Returns Test parameter list
     *
     * @return the Test parameter list
     */
    public List<TestParameter> getTestParameterList() {
        return testParameterList;
    }
    /**
     * Returns the results
     *
     * @return the results
     */
    public List<Double> getResults() {
        return results;
    }

    @Override
    public int compareTo(Test test) {
        return getDate().compareTo(test.getDate());
    }

    /**
     * Returns the copy data
     *
     * @return the copy data
     */
    public Date getFakeDate() {
        return fakeDate;
    }

    /**
     * Returns the copy data of analyses
     *
     * @return the copy data of analyses
     */
    public Date getFakeResultRegist() {
        return fakeResultRegist;
    }
    /**
     * Returns the copy data of validation
     *
     * @return the copy data of validation
     */
    public Date getFakeValidationDate() {
        return fakeValidationDate;
    }
}

