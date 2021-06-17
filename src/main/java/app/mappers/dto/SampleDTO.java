package app.mappers.dto;

public class SampleDTO {
    /**
     * String that contains id of a test
     */
    private String orderid;
    /**
     * Creates a sampleDTO, receiving by parameter the id of a test.
     * Checks all parameters rules to see if the inputted data is valid.
     *
     * @param orderid The lab order
     */
    public SampleDTO(String orderid) {

        this.orderid = orderid;
    }

    /**
     * Returns the id of a test.
     * @return the id of a test.
     */
    public String getOrderid() {
        return orderid;
    }
}
