package app.mappers;

import app.domain.model.Report;
import app.mappers.DTO.ReportDTO;

public class ReportMapper {

    private ReportDTO reportDto;

    public ReportDTO toDTO(Report report){
        reportDto = new ReportDTO(report);
        return reportDto;
    }

}
