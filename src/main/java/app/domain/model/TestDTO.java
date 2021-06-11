package app.domain.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestDTO {

    /**
     * Lab order of a given test.
     */
    private LabOrder labOrder;

    /**
     * String that contains the code of a given test.
     */
    private String code;

    /**
     * List containing the samples of a test.
     */
    private List<Sample> sample;

    private List<String> testParameterResultList;

    private Laboratory laboratory;

    private Date date;

    /**
     * Constructs an instance of TestDTO with the same attributes as the received Test.
     *
     * @param test The test to be copied.
     */
    public TestDTO(Test test) {
        this.labOrder=test.getLabOrder();
        this.sample=test.getSample();
        this.code=test.getCode();
        this.testParameterResultList=test.getTestParameterResultList();
        this.laboratory= test.getLab();
        this.date = test.getDate();
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
        return "TestDTO:"+"code: " +code  +" ,"+ labOrder.toString() + ", sample=" + sample + ", results=" + testParameterResultList;
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

    public Laboratory getLaboratoryDTO() {
        return laboratory;
    }

    public Date getDate() { return date; }
}
