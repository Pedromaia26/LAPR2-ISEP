package app.mappers.dto;

import app.domain.model.Report;

import java.util.Date;

public class ReportDTO {
    /**
     * String that contains the diagnosis test to be added to the report
     */
    private String diagnosis;

    /**
     * Date that contains the creating data of the report
     */
    private Date createdAt;

    /**
     * Create a new instance of ReportDto, receiving by parameter the report to be converted in Dto
     * @param report the report to be converted in Dto
     */
    public ReportDTO(Report report) {
        this.diagnosis = report.getDiagnosis();
        this.createdAt = report.getCreatedAt();
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
