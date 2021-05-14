package app.domain.model;

public class SampleDTO {

    private String dataColl;

    private String timeColl;

    private String orderid;

    public SampleDTO(String dataColl, String timeColl, String orderid) {
        this.dataColl = dataColl;
        this.timeColl = timeColl;
        this.orderid = orderid;
    }

    public String getDataColl() {
        return dataColl;
    }

    public String getTimeColl() {
        return timeColl;
    }

    public String getOrderid() {
        return orderid;
    }
}
