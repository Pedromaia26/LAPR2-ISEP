package app.domain.model;

import app.controller.App;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.util.ArrayList;
import java.util.List;

public class TestStore {

    /**
     * List that contains the tests.
     */
    private List<Test> tests;

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
     * Returns the test whose result the technician wishes to record in the software.
     * @param barcode the barcode received by parameter, in order to receive the respective test.
     * @return test selected by its sample's barcode.
     */

    public Test getTestByBarcode(String barcode){
        for (Test test: tests) {
            for (Sample samples : test.getSample()) {
                    if (barcode.equals(samples.getBarcode()))
                        return test;

            }
        }
        throw new IllegalArgumentException("There is no Sample with such barcode!");
    }

    public Test getTestByCode(String code){
        for (Test test: tests) {
            if (code.equals(test.getCode()))
                return test;

        }

        throw new IllegalArgumentException("There is no Sample with such barcode!");
    }
}
