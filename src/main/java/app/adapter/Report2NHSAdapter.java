package app.adapter;

import app.domain.model.ReportToNHS;
import com.nhs.report.Report2NHS;

public class Report2NHSAdapter implements ReportToNHS {


    @Override
    public void writeUsingFileWriter(String data) {
        Report2NHS.writeUsingFileWriter(data);
    }
}
