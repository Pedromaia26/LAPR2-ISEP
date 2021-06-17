package app.domain.model;

public class ReportMapper {

    private ReportDTO reportDto;

    public ReportDTO toDTO(Report report){
        reportDto = new ReportDTO(report);
        return reportDto;
    }

}
