package app.controller;

import app.domain.model.Company;
import app.domain.model.ReportNHS;
import app.domain.model.TestStore;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;

import java.util.*;

import java.util.Date;
import java.util.List;
import java.util.Timer;


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

    public void getReportForDays(Date startDate, Date endDate, Date currentDate, int hP, double sL, double cL, String parameterToHT) throws OutputException, BarcodeException, ParseException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        double[] covidTests = testStore.covidTestsLinearRegression(startDate, endDate);
        double[] positiveTests = testStore.positiveCovidTestsLinearRegression(startDate, endDate);
        report = company.createReportNHS();
        report.createLinearRegression(covidTests, positiveTests, sL/100, cL, parameterToHT);
        double[] positiveCasesToInterval = testStore.getPositiveCovidTestsPerDay(currentDate, hP);
        double[] covidTestsHp = testStore.getTestForHp(currentDate, hP);
        List<Date> hPDays = testStore.getHPDays();
        report.addConfLevel(positiveCasesToInterval , covidTestsHp, hPDays, cL/100);
        report.sendReportNHS();
        //autoReport = new ReportNHS(report.getReport());
        /*long delay = 120;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 9);
        calendar.set(Calendar.MINUTE, 3);
        calendar.set(Calendar.SECOND, 0);
        Date time = calendar.getTime();
        timer.schedule(autoReport, time);*/

    }

    public void getReportForWeeks(Date startDate, Date endDate, Date currentDate, int hP, double sL, double cL, String parameterToHT) throws OutputException, BarcodeException, ParseException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        double[] covidTests = testStore.covidTestsLinearRegression(startDate, endDate);
        double[] positiveTests = testStore.positiveCovidTestsLinearRegression(startDate, endDate);
        report = company.createReportNHS();
        report.createLinearRegression(covidTests, positiveTests, sL/100, cL, parameterToHT);
        double[] positiveCasesToInterval = testStore.getPositiveCovidTestsPerWeek(currentDate, hP);
        double[] perfomedTestsForHp = testStore.getCovidTestsForWeekHp(currentDate, hP);
        List<Date> hPWeeksInitial = testStore.gethPWeeksInitial();
        List<Date> hPWeeksFinal = testStore.gethPWeeksFinal();
        report.addConfLevelForWeek(positiveCasesToInterval, perfomedTestsForHp, hPWeeksInitial, hPWeeksFinal, cL/100);
        report.sendReportNHS();
    }

    public void getReportForDaysWithMeanAge(Date startDate, Date endDate, Date currentDate, int hP, double sL, double cL, String parameterToHT) throws OutputException, BarcodeException, ParseException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        double[] meanAge = testStore.meanAgeLinearRegression(startDate, endDate);
        double[] positiveTests = testStore.positiveCovidTestsLinearRegression(startDate, endDate);
        report = company.createReportNHS();
        report.createLinearRegression(meanAge, positiveTests, sL/100, cL, parameterToHT);
        double[] positiveCasesToInterval = testStore.getPositiveCovidTestsPerDay(currentDate, hP);
        double[] meanAgeHp = testStore.getMeanAgeForHpDay(currentDate, hP);
        List<Date> hPDays = testStore.getHPDays();
        report.addConfLevel(positiveCasesToInterval , meanAgeHp, hPDays, cL/100);
        report.sendReportNHS();
    }

    public void getReportForWeeksWithMeanAge(Date startDate, Date endDate, Date currentDate, int hP, double sL, double cL, String parameterToHT) throws OutputException, BarcodeException, ParseException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        double[] meanAge = testStore.meanAgeLinearRegression(startDate, endDate);
        double[] positiveTests = testStore.positiveCovidTestsLinearRegression(startDate, endDate);
        report = company.createReportNHS();
        report.createLinearRegression(meanAge, positiveTests, sL/100, cL, parameterToHT);
        double[] positiveCasesToInterval = testStore.getPositiveCovidTestsPerWeek(currentDate, hP);
        double[] meanAgeHp = testStore.getMeanAgeForHPWeek(currentDate, hP);
        List<Date> hPWeeksInitial = testStore.gethPWeeksInitial();
        List<Date> hPWeeksFinal = testStore.gethPWeeksFinal();
        report.addConfLevelForWeek(positiveCasesToInterval, meanAgeHp, hPWeeksInitial, hPWeeksFinal, cL/100);
        report.sendReportNHS();
    }

    public void sendReportMultilinearRegressionForDays(Date startDate, Date endDate, Date currentDate, int hP, double sL, double cL) throws OutputException, BarcodeException, ParseException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        double[] covidTests = testStore.covidTestsLinearRegression(startDate, endDate);
        double[] positiveTests = testStore.positiveCovidTestsLinearRegression(startDate, endDate);
        double[] meanAge = testStore.meanAgeLinearRegression(startDate, endDate);
        report = company.createReportNHS();
        report.createMultiLinearRegression(covidTests, meanAge, positiveTests, sL/100, cL);
        double[] positiveCasesToInterval = testStore.getPositiveCovidTestsPerDay(currentDate, hP);
        double[] covidTestsHp = testStore.getTestForHp(currentDate, hP);
        double[] meanAgeHp = testStore.getMeanAgeForHpDay(currentDate, hP);
        List<Date> hPDays = testStore.getHPDays();
        report.addConfLevelForMultiRegr(positiveCasesToInterval, covidTestsHp, meanAgeHp, hPDays, cL/100);
        report.sendReportNHS();
    }

    public void sendReportMultilinearRegressionForWeeks(Date startDate, Date endDate, Date currentDate, int hP, double sL, double cL) throws OutputException, BarcodeException, ParseException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        double[] covidTests = testStore.covidTestsLinearRegression(startDate, endDate);
        double[] positiveTests = testStore.positiveCovidTestsLinearRegression(startDate, endDate);
        double[] meanAge = testStore.meanAgeLinearRegression(startDate, endDate);
        report = company.createReportNHS();
        report.createMultiLinearRegression(covidTests, meanAge, positiveTests, sL/100, cL);
        double[] positiveCasesToInterval = testStore.getPositiveCovidTestsPerWeek(currentDate, hP);
        double[] perfomedTestsForHp = testStore.getCovidTestsForWeekHp(currentDate, hP);
        double[] meanAgeHp = testStore.getMeanAgeForHPWeek(currentDate, hP);
        List<Date> hPWeeksInitial = testStore.gethPWeeksInitial();
        List<Date> hPWeeksFinal = testStore.gethPWeeksFinal();
        report.addConfLevelForWeekForMultiRegr(positiveCasesToInterval, perfomedTestsForHp, meanAgeHp, hPWeeksInitial, hPWeeksFinal, cL/100);
        report.sendReportNHS();
    }

}
