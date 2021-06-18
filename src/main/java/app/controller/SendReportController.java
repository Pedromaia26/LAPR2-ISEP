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
import java.util.*;

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
        double[] covidTestsHp = testStore.getTestForHp(currentDate, hP);
        List<Date> hPDays = testStore.getHPDays();
        autoReport = new ReportNHS(report.getReport());
        /*long delay = 120;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 9);
        calendar.set(Calendar.MINUTE, 3);
        calendar.set(Calendar.SECOND, 0);
        Date time = calendar.getTime();
        timer.schedule(autoReport, time);*/

    }

    public void getReportForWeeks(Date startDate, Date endDate, Date currentDate, int hP, double sL, double cL){
        System.out.println("tests week");
        double[] covidTests = testStore.covidTestsLinearRegression(startDate, endDate);
        double[] positiveTests = testStore.positiveCovidTestsLinearRegression(startDate, endDate);
        report = new ReportNHS();
        report.createLinearRegression(covidTests, positiveTests, sL/100, cL);
        double[] positiveCasesToInterval = testStore.getPositiveCovidTestsPerWeek(currentDate, hP);
        double[] perfomedTestsForHp = testStore.getCovidTestsForWeekHp(currentDate, hP);
        List<Date> hPWeeksInitial = testStore.gethPWeeksInitial();
        List<Date> hPWeeksFinal = testStore.gethPWeeksFinal();
        report.addConfLevelForWeek(positiveCasesToInterval, perfomedTestsForHp, hPWeeksInitial, hPWeeksFinal, cL/100);
    }

    public void getReportForDaysWithMeanAge(Date startDate, Date endDate, Date currentDate, int hP, double sL, double cL){
        System.out.println("mean age day");
        double[] meanAge = testStore.meanAgeLinearRegression(startDate, endDate);
        double[] positiveTests = testStore.positiveCovidTestsLinearRegression(startDate, endDate);
        report = new ReportNHS();
        report.createLinearRegression(meanAge, positiveTests, sL/100, cL);
        double[] positiveCasesToInterval = testStore.getPositiveCovidTestsPerDay(currentDate, hP);
        double[] meanAgeHp = testStore.getMeanAgeForHpDay(currentDate, hP);
        List<Date> hPDays = testStore.getHPDays();
        report.addConfLevel(positiveCasesToInterval , meanAgeHp, hPDays, cL/100);
    }

    public void getReportForWeeksWithMeanAge(Date startDate, Date endDate, Date currentDate, int hP, double sL, double cL){
        double[] meanAge = testStore.meanAgeLinearRegression(startDate, endDate);
        double[] positiveTests = testStore.positiveCovidTestsLinearRegression(startDate, endDate);
        report = new ReportNHS();
        report.createLinearRegression(meanAge, positiveTests, sL/100, cL);
        double[] positiveCasesToInterval = testStore.getPositiveCovidTestsPerWeek(currentDate, hP);
        double[] meanAgeHp = testStore.getMeanAgeForHPWeek(currentDate, hP);
        List<Date> hPWeeksInitial = testStore.gethPWeeksInitial();
        List<Date> hPWeeksFinal = testStore.gethPWeeksFinal();
        report.addConfLevelForWeek(positiveCasesToInterval, meanAgeHp, hPWeeksInitial, hPWeeksFinal, cL/100);
    }

}
