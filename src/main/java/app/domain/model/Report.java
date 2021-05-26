package app.domain.model;

import java.util.Date;

public class Report {

    private String diagnosis;
    private Date createdAt;

    public Report(String diagnosis) {
        if (diagnosis.split(" ").length >= 400)
            throw new IllegalArgumentException("Diagnosis should have no more than 400 words.");
        this.diagnosis = diagnosis;
        this.createdAt = new Date();
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
