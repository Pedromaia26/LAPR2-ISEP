package app.controller;

import app.domain.model.Company;
import app.domain.model.LinearRegression;
import app.domain.model.ReportNHS;
import app.domain.model.TestStore;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;

public class SendReportController {
    private Company company;
    private TestStore testStore;
    private ReportNHS report;
    private Timer timer = new Timer();
    private ReportNHS autoReport;

    public SendReportController() throws OutputException, BarcodeException, ParseException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        this(App.getInstance().getCompany());
    }

    public SendReportController(Company c){
        this.company = c;
        testStore = c.getTestStore();
    }

    public void getReportForDays(Date startDate, Date endDate, Date currentDate, int hP, double sL, double cL){
        System.out.println("tests day");
        double[] covidTests = testStore.covidTestsLinearRegression(startDate, endDate);
        double[] positiveTests = testStore.positiveCovidTestsLinearRegression(startDate, endDate);
//        System.out.println("performed");
//        for(int i =0;i<covidTests.length;i++){
//            System.out.println(covidTests[i]);
//        }
//        System.out.println("positive");
//        for(int i =0;i<positiveTests.length;i++){
//            System.out.println(positiveTests[i]);
//        }
        report = new ReportNHS();
        report.createLinearRegression(covidTests, positiveTests, sL/100, cL);
        double[] positiveCasesToInterval = testStore.getPositiveCovidTestsPerDay(currentDate, hP);
        List<Date> hPDays = testStore.getHPDays();
        report.addConfLevel(positiveCasesToInterval , hPDays, cL/100);
        autoReport = new ReportNHS(report.getReport());
        long delay = 120;

        timer.schedule(autoReport, delay*1000, 120000);

    }

    public void getReportForWeeks(Date startDate, Date endDate, Date currentDate, int hP, double sL, double cL){
        System.out.println("tests week");
        double[] covidTests = testStore.covidTestsLinearRegression(startDate, endDate);
        double[] positiveTests = testStore.positiveCovidTestsLinearRegression(startDate, endDate);
        report = new ReportNHS();
        report.createLinearRegression(covidTests, positiveTests, sL/100, cL);
        double[] positiveCasesToInterval = testStore.getPositiveCovidTestsPerWeek(currentDate, hP);
        List<Date> hPWeeksInitial = testStore.gethPWeeksInitial();
        List<Date> hPWeeksFinal = testStore.gethPWeeksFinal();
        report.addConfLevelForWeek(positiveCasesToInterval, hPWeeksInitial, hPWeeksFinal, cL/100);
    }

    public void getReportForDaysWithMeanAge(Date startDate, Date endDate, Date currentDate, int hP, double sL, double cL){
        System.out.println("mean age day");
        double[] meanAge = testStore.meanAgeLinearRegression(startDate, endDate);
        double[] positiveTests = testStore.positiveCovidTestsLinearRegression(startDate, endDate);
        report = new ReportNHS();
        report.createLinearRegression(meanAge, positiveTests, sL/100, cL/100);
        double[] positiveCasesToInterval = testStore.getPositiveCovidTestsPerDay(currentDate, hP);
        List<Date> hPDays = testStore.getHPDays();
        report.addConfLevel(positiveCasesToInterval , hPDays, cL/100);
    }

    public void getReportForWeeksWithMeanAge(Date startDate, Date endDate, Date currentDate, int hP, double sL, double cL){
        double[] meanAge = testStore.meanAgeLinearRegression(startDate, endDate);
        double[] positiveTests = testStore.positiveCovidTestsLinearRegression(startDate, endDate);
        report = new ReportNHS();
        report.createLinearRegression(meanAge, positiveTests, sL/100, cL);
        double[] positiveCasesToInterval = testStore.getPositiveCovidTestsPerWeek(currentDate, hP);
        List<Date> hPWeeksInitial = testStore.gethPWeeksInitial();
        List<Date> hPWeeksFinal = testStore.gethPWeeksFinal();
        report.addConfLevelForWeek(positiveCasesToInterval, hPWeeksInitial, hPWeeksFinal, cL/100);
    }

}
