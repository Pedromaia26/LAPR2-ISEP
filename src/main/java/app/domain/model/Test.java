package app.domain.model;

import app.controller.App;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.sql.Timestamp;
import java.util.*;

public class Test {


    private List<TestParameterResult> results;
    /**
     * String that contains the code of a test.
     */
    private String code;
    /**
     * The National Healthcare Service.
     */
    private long nhsCode;
    /**
     * The lab order prescribed by a doctor that contains the type of tests and parameter of a test being analysed.
     */
    private LabOrder labOrder;
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
    public Test (){
        testParameterList = new ArrayList<>();
        results = new ArrayList<>();
    }

    /**
     * Creates an instance of Test, receiving by parameter its code, its National Healthcare Service code
     * and the lab order associated to the test.
     * @param code code of the test.
     * @param nhsCode National Healthcare Service code of the test.
     * @param labOrder lab order prescribed by the doctor for a given test.
     */
    public Test(String code, long nhsCode, LabOrder labOrder){

        if (code.trim().length() != 10)
            throw new IllegalArgumentException("Code should have 10 digits");
        this.code = code;

        if (String.valueOf(nhsCode).length() != 10)
            throw new IllegalArgumentException("National Health Service Code should have 10 digits");

        this.nhsCode = nhsCode;

        this.labOrder = labOrder;
        em = new ExternalModule() {
            @Override
            public ReferenceValue getReferenceValue(Parameter parameter) {
                return null;
            }

            @Override
            public String getMetric(Parameter parameter) {
                return null;
            }
        };

        testParameterList = new ArrayList<>();
        testParameterList = addToList(labOrder.getParameters());


    }

    /**
     * Returns the code of a test.
     * @return the code of a test .
     */

    public String getCode() {
        return code;
    }

    /**
     * Returns the National Health Service code of a test.
     * @return the National Health Service code of a test.
     */

    public long getNhsCode() {
        return nhsCode;
    }


    /**
     * Returns the lab order of a test.
     * @return the lab order.
     */

    public LabOrder getLabOrder() {
        return labOrder;
    }

    /**
     * Returns the list of existing samples.
     * @return list of samples.
     */

    public List<Sample> getSample() {
        return sample;
    }

    /**
     * Returns the list of parameters of a test.
     * @return list of parameters of a test.
     */

    public List<TestParameter> getTestParameter(){ return testParameterList; }

    /**
     * Returns the report of a test
     * @return the report of a test
     */

    public Report getReport(){
        return report;
    }

    /**
     * Returns the test parameter from a test.
     * @param parameterCode receives a parameter code by parameter and proceeds to check if this code exists.
     * @return the test parameter intended if the code exists. If not, informs the user that the code does not exist.
     */
    public TestParameter getTestParameterFor(String parameterCode){
        for (TestParameter testParam: testParameterList) {
            if (parameterCode.equals(testParam.getParameter().getCode()))
                return testParam;
        }
        throw new IllegalArgumentException ("There is no parameter with such code");
    }



    /**
     * Compares an object of test that evokes the method with another.
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
     * @return characteristics of a test.
     */
    public String toString() {
        return "Test:" + labOrder + ", sample=" + sample;
    }

    /**
     * Validates the sample received.
     * @param samp the sample to be validated.
     * @return True if the sample is successfully validated, false if it is not.
     */
    public boolean validateSample(Sample samp, Company company){
        if (samp == null)
            return false;

        List<Test> tests= company.getTestStore().getTests();
        for(Test testss : tests){
            for (Sample samples : testss.getSample()) {
                if (samples.getBarcode().equals(samp.getBarcode())) {
                    return false;

                }
            }
        }
        return true;
    }
    /**
     * Saves the sample received in the test.
     * @param samp the sample to be saved.
     * @return True if the sample is successfully saved, false if it is not.
     */
    public boolean saveSample(Sample samp, Company company) throws OutputException {
        if (!validateSample(samp,company))
            return false;

        samp.imageIoWrite(samp.barcodeImage(samp.getBarcode()),samp.getBarcode().getBarcodeNumber());

        samp.showBarcodes(samp.getBarcode());
        return addSample(samp);
    }

    /**
     * Adds a sample to the list of samples.
     * @param samp the sample to be added.
     * @return true if samp is sucessfully added
     */
    public boolean addSample(Sample samp){

        return this.sample.add(samp);

    }

    /**
     * Creates a report of the test.
     * @param report the report of the test.
     */
    public void addReport(Report report){
        this.report = report;
    }

    /**
     * Create a new sample with the dto received.
     * @return The Sample created.
     */
    public Sample RecordNewSample(Company c) throws BarcodeException, IllegalAccessException, ClassNotFoundException, InstantiationException, OutputException {
        return new Sample(c);
    }

    /**
     * Returns the external module being used to obtain the reference values.
     * @return the external module.
     */
    //public ExternalModule getExternalModule (){
      //  return em;
    //}

    /**
     * Adds a result to a parameter of a test, comparing the value received by parameter
     * and the existing reference values provided by the external module.
     * @param parameterCode the code of the parameter for which we pretend to add a result.
     * @param result the value obtained from a test parameter of a given client.
     */
    public void addTestResult (String parameterCode, Double result) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        checkResultRules(result);
        TestParameter tp = getTestParameterFor(parameterCode);
        this.ref = getExternalModule().getReferenceValue(tp.getParameter());
        String metric = getExternalModule().getMetric(tp.getParameter());
        tp.addResult(result, metric, ref);
        resultRegist = new Date();
    }


    public List<TestParameter> addToList (List <Parameter> p){
        for (Parameter par: p){
            testParameterList.add(new TestParameter(par));
        }
        return testParameterList;
    }

    /**
     * Checks the parameter result restrictions
     * @param result the result of a given parameter of a test.
     */
    public void checkResultRules (Double result){
        if (result<0)
            throw new IllegalArgumentException("The result cannot be negative!");
    }

    public ExternalModule getExternalModule() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Properties prop = App.getInstance().getprops();
        String classaux = prop.getProperty(labOrder.getTestType().getApi());
        Class<?> oClass = Class.forName(classaux);
        ExternalModule api0 = (ExternalModule) oClass.newInstance();
        return api0;
    }

}

