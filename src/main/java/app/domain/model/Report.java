package app.domain.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Report implements Serializable {

    /**
     * String that contains the diagnosis test to be added to the report
     */
    private String diagnosis;

    /**
     * Date that contains the creating data of the report
     */
    private Date createdAt;

    /**
     * Create a new instance of Report, receiving by parameter the diagnosis test
     * @param diagnosis the Diagnosis Test to be added to the report
     */
    public Report(String diagnosis) {
        if (diagnosis.split(" ").length >= 400)
            throw new IllegalArgumentException("Diagnosis should have no more than 400 words.");
        this.diagnosis = diagnosis;
        this.createdAt = new Date();
    }
    public Report(String diagnosis, String data) throws ParseException {
        this.diagnosis = diagnosis;
        this.createdAt = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(data);
    }

    /**
     * Returns the Diagnosis Test of a Report
     * @return the Diagnosis Test of a Report
     */
    public String getDiagnosis() {
        return diagnosis;
    }

    /**
     * Returns the Created Data of a Report
     * @return the Created Data of a Report
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Report{" +
                "diagnosis='" + diagnosis + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
