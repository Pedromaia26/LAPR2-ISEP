package app.domain.model;

import app.controller.App;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TestStore {

    /**
     * List that contains the tests.
     */
    private List<Test> tests;

    /**
     * List that contains the tests to be reported.
     */
    /*private List<Test> testsToBeReported;*/


    public Test createTest (Company company, Client client, long nhsCode, LabOrder labOrder) {
        return new Test(company, client, nhsCode, labOrder);
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

    /**
     * Saves the Test received.
     * @param ts Test to be saved.
     * @return True if the Test is successfully saved, false if it is not.
     */

    public boolean saveTest (Test ts){
        if (!validateTest(ts))
            return false;
        return tests.add(ts);
    }

     /**
     * Marks the test as validated
     * @param code The code of the test to validate
     */
    public void validateWorkDone(String code) throws IOException{
        Test test = getTestByCode(code);
        test.validateTest();
    }

}
