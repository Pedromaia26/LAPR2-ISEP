package app.domain.model;

public class Sample {

    private String dataColl;

    private String timeColl;

    private TestType test;

    public Sample(String dataColl, String timeColl, TestType test) {
        this.dataColl = dataColl;
        this.timeColl = timeColl;
        this.test = test;
    }

}
