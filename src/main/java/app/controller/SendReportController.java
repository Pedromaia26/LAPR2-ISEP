package app.controller;

import app.domain.model.Company;
import app.domain.model.TestStore;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

public class SendReportController {
    Company company;
    TestStore testStore;

    public SendReportController() throws OutputException, BarcodeException, ParseException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        this(App.getInstance().getCompany());
    }

    public SendReportController(Company c){
        this.company = c;
        testStore = c.getTestStore();
    }

    public void getReportForDays(Date startDate, Date endDate, Date currentDate, int hP){
        testStore.covidTestsLinearRegression(startDate, endDate);
        testStore.positiveCovidTestsLinearRegression(startDate, endDate);
        testStore.getCovidTestsPerDay(currentDate, hP);
    }

    public void getReportForWeeks(Date startDate, Date endDate, Date currentDate, int hP){
        testStore.covidTestsLinearRegression(startDate, endDate);
        testStore.positiveCovidTestsLinearRegression(startDate, endDate);
        testStore.getCovidTestsPerWeek(currentDate, hP);
    }

}
