package app.domain.model;

import java.util.List;

public class TestDTO {
    private LabOrder labOrder;

    private String code;

    private List<Sample> sample;

    /**
     * Constructs an instance of TestDTO with the same attributes as the received Test.
     *
     * @param test The test to be copied.
     */
    public TestDTO(Test test) {
        this.labOrder=test.getLabOrder();
        this.sample=test.getSample();
        this.code=test.getCode();
    }

    /**
     * Returns the code of the test.
     *
     * @return The code of the test.
     */
    public String getCode() { return code; }

    /**
     * Returns the textual description of a test.
     * @return characteristics of a test.
     */
    @Override
    public String toString() {
        return "TestDTO:"+"code: " +code  +" ,"+ labOrder.toString() + ", sample=" + sample;
    }

    /**
     * Returns the lab order of a test.
     *
     * @return The code of the test.
     */
    public LabOrder getLabOrder() {
        return labOrder;
    }

    /**
     * Returns the list of samples of a test.
     * @return The sample of the test.
     */
    public List<Sample> getSample() {
        return sample;
    }
}
