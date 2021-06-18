package app.controller;

import app.domain.model.Company;
import app.domain.model.ReportNHS;
import app.domain.model.TestStore;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class SendReportController {
    private Company company;
    private TestStore testStore;
    private ReportNHS report;

    public SendReportController() throws OutputException, BarcodeException, ParseException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        this(App.getInstance().getCompany());
    }

    public SendReportController(Company c){
        this.company = c;
        testStore = c.getTestStore();
    }

    public void getReportForDays(Date startDate, Date endDate, Date currentDate, int hP, double sL, double cL) throws OutputException, BarcodeException, ParseException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        double[] covidTests = testStore.covidTestsLinearRegression(startDate, endDate);
        double[] positiveTests = testStore.positiveCovidTestsLinearRegression(startDate, endDate);
        report = company.createReportNHS();
        report.setRegressionModel("Domain.SimpleLinearRegression");
        report.createLinearRegression(covidTests, positiveTests, sL/100, cL);
        report.printReport(covidTests, positiveTests, sL/100, cL);
        double[] positiveCasesToInterval = testStore.getPositiveCovidTestsPerDay(currentDate, hP);
        double[] covidTestsHp = testStore.getTestForHp(currentDate, hP);
        List<Date> hPDays = testStore.getHPDays();
        report.addConfLevel(positiveCasesToInterval, covidTestsHp, hPDays, cL/100);
    }

    public void getReportForWeeks(Date startDate, Date endDate, Date currentDate, int hP, double sL, double cL) throws OutputException, BarcodeException, ParseException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        double[] covidTests = testStore.covidTestsLinearRegression(startDate, endDate);
        double[] positiveTests = testStore.positiveCovidTestsLinearRegression(startDate, endDate);
        report = company.createReportNHS();
        report.setRegressionModel("Domain.SimpleLinearRegression");
        report.createLinearRegression(covidTests, positiveTests, sL/100, cL);
        report.printReport(covidTests, positiveTests, sL/100, cL);
        double[] positiveCasesToInterval = testStore.getPositiveCovidTestsPerWeek(currentDate, hP);
        double[] perfomedTestsForHp = testStore.getCovidTestsForWeekHp(currentDate, hP);
        List<Date> hPWeeksInitial = testStore.gethPWeeksInitial();
        List<Date> hPWeeksFinal = testStore.gethPWeeksFinal();
        report.addConfLevelForWeek(positiveCasesToInterval, perfomedTestsForHp, hPWeeksInitial, hPWeeksFinal, cL/100);
    }

    public void getReportForDaysWithMeanAge(Date startDate, Date endDate, Date currentDate, int hP, double sL, double cL) throws OutputException, BarcodeException, ParseException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        double[] meanAge = testStore.meanAgeLinearRegression(startDate, endDate);
        double[] positiveTests = testStore.positiveCovidTestsLinearRegression(startDate, endDate);
        report = company.createReportNHS();
        report.setRegressionModel("Domain.SimpleLinearRegression");
        report.createLinearRegression(meanAge, positiveTests, sL/100, cL);
        report.printReport(meanAge, positiveTests, sL/100, cL);
        double[] positiveCasesToInterval = testStore.getPositiveCovidTestsPerDay(currentDate, hP);
        double[] meanAgeHp = testStore.getMeanAgeForHpDay(currentDate, hP);
        List<Date> hPDays = testStore.getHPDays();
        report.addConfLevel(positiveCasesToInterval , meanAgeHp, hPDays, cL/100);
    }

    public void getReportForWeeksWithMeanAge(Date startDate, Date endDate, Date currentDate, int hP, double sL, double cL) throws OutputException, BarcodeException, ParseException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        double[] meanAge = testStore.meanAgeLinearRegression(startDate, endDate);
        double[] positiveTests = testStore.positiveCovidTestsLinearRegression(startDate, endDate);
        report = company.createReportNHS();
        report.setRegressionModel("Domain.SimpleLinearRegression");
        report.createLinearRegression(meanAge, positiveTests, sL/100, cL);
        report.printReport(meanAge, positiveTests, sL/100, cL);
        double[] positiveCasesToInterval = testStore.getPositiveCovidTestsPerWeek(currentDate, hP);
        double[] meanAgeHp = testStore.getMeanAgeForHPWeek(currentDate, hP);
        List<Date> hPWeeksInitial = testStore.gethPWeeksInitial();
        List<Date> hPWeeksFinal = testStore.gethPWeeksFinal();
        report.addConfLevelForWeek(positiveCasesToInterval, meanAgeHp, hPWeeksInitial, hPWeeksFinal, cL/100);
    }

}
