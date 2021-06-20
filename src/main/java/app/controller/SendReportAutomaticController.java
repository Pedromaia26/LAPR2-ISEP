package app.controller;

import app.domain.model.Company;
import app.domain.model.ReportNHS;
import app.domain.model.TestStore;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class SendReportAutomaticController {
    private Company company;
    private TestStore testStore;
    private int historicalPoints;
    private double confidenceLevel;
    private double significanceLevel;
    private String initialDateString;
    private String endDateString;
    private Date initialDate;
    private Date endDate;
    private String regressionModel;
    private ReportNHS reportTestPerformed;
    private ReportNHS reportMeanAge;
    private ReportNHS reportMultiReg;
    private Date currentDate;



    public SendReportAutomaticController() throws ClassNotFoundException, IllegalAccessException, InstantiationException, OutputException, BarcodeException, ParseException, IOException {
        this(App.getInstance().getCompany());
        this.testStore = company.getTestStore();
    }

    public SendReportAutomaticController(Company company){
        this.company = company;
        this.testStore = company.getTestStore();
    }

    public void readProperties() throws ParseException, OutputException, BarcodeException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Properties prop = App.getInstance().getprops();
        historicalPoints = Integer.parseInt(prop.getProperty("Domain.NumberOfHistoricalPoints"));
        confidenceLevel = Integer.parseInt(prop.getProperty("Domain.ConfidenceLevel"));
        significanceLevel = Integer.parseInt(prop.getProperty("Domain.SignificanceLevel"));
        initialDateString = prop.getProperty("Domain.InitialDate");
        endDateString = prop.getProperty("Domain.EndDate");
        initialDate = formatter.parse(initialDateString);
        endDate = formatter.parse(endDateString);
        regressionModel = prop.getProperty("Domain.RegressionModel");
        currentDate = new Date();
        String aux = formatter.format(currentDate);
        currentDate = formatter.parse(aux);
    }

    public void sendReport() throws OutputException, BarcodeException, ParseException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        if(regressionModel.equals("SLR")) {
            double[] covidTests = testStore.covidTestsLinearRegression(initialDate, endDate);
            double[] positiveTests = testStore.positiveCovidTestsLinearRegression(initialDate, endDate);
            double[] meanAge = testStore.meanAgeLinearRegression(initialDate, endDate);
            reportTestPerformed = company.createReportNHS();
            reportTestPerformed.addStringToReport(String.format("Independent Variable: Test Performed\n\n"));
            reportTestPerformed.createLinearRegression(covidTests, positiveTests, significanceLevel / 100, confidenceLevel, "ab");
            reportMeanAge = company.createReportNHS();
            reportMeanAge.addStringToReport(String.format("Independent Variable: Mean Age\n\n"));
            reportMeanAge.createLinearRegression(meanAge, positiveTests, significanceLevel / 100, confidenceLevel, "ab" );
            double[] positiveCasesToInterval = testStore.getPositiveCovidTestsPerDay(currentDate, historicalPoints);
            double[] meanAgeHp = testStore.getMeanAgeForHpDay(currentDate, historicalPoints);
            double[] perfomedTestsForHp = testStore.getCovidTestsForWeekHp(currentDate, historicalPoints);
            if(Math.abs(1-reportTestPerformed.getR2Simple()) > Math.abs(1-reportMeanAge.getR2Simple())){
                List<Date> hPDays = testStore.getHPDays();
                String add = String.format("\n\nDay Table\n\n");
                reportMeanAge.addStringToReport(add);
                reportMeanAge.addConfLevel(positiveCasesToInterval, meanAgeHp, hPDays, confidenceLevel/100);
                add = String.format("\n\nWeek Table\n\n");
                reportMeanAge.addStringToReport(add);
                double[] positiveCasesToIntervalWeek = testStore.getPositiveCovidTestsPerWeek(currentDate, historicalPoints);
                double[] meanAgeHpWeek = testStore.getMeanAgeForHPWeek(currentDate, historicalPoints);
                List<Date> hPWeeksInitial = testStore.gethPWeeksInitial();
                List<Date> hPWeeksFinal = testStore.gethPWeeksFinal();
                reportMeanAge.addConfLevelForWeek(positiveCasesToIntervalWeek, meanAgeHpWeek, hPWeeksInitial, hPWeeksFinal, confidenceLevel/100);
                reportMeanAge.sendReportNHS();
            }else{
                reportTestPerformed.addStringToReport(String.format("\n\nDay Table\n\n"));
                double[] positiveCasesToIntervalDay = testStore.getPositiveCovidTestsPerDay(currentDate, historicalPoints);
                double[] covidTestsHpDay = testStore.getTestForHp(currentDate, historicalPoints);
                List<Date> hPDays = testStore.getHPDays();
                reportTestPerformed.addConfLevel(positiveCasesToIntervalDay, covidTestsHpDay, hPDays, confidenceLevel/100);
                reportTestPerformed.addStringToReport(String.format("\n\nWeek Table\n\n"));
                double[] positiveCasesToIntervalWeeks = testStore.getPositiveCovidTestsPerWeek(currentDate, historicalPoints);
                double[] perfomedTestsForHpWeeks = testStore.getCovidTestsForWeekHp(currentDate, historicalPoints);
                List<Date> hPWeeksInitial = testStore.gethPWeeksInitial();
                List<Date> hPWeeksFinal = testStore.gethPWeeksFinal();
                reportTestPerformed.addConfLevelForWeek(positiveCasesToIntervalWeeks, perfomedTestsForHpWeeks, hPWeeksInitial, hPWeeksFinal, confidenceLevel/100);
                reportTestPerformed.sendReportNHS();
            }
        }else if(regressionModel.equals("MLR")){
            double[] covidTests = testStore.covidTestsLinearRegression(initialDate, endDate);
            double[] positiveTests = testStore.positiveCovidTestsLinearRegression(initialDate, endDate);
            double[] meanAge = testStore.meanAgeLinearRegression(initialDate, endDate);
            reportMultiReg = company.createReportNHS();
            String addToReport = String.format("\n\nDay Table\n\n");
            reportMultiReg.createMultiLinearRegression(covidTests, meanAge, positiveTests, significanceLevel/100, confidenceLevel);
            reportMultiReg.addStringToReport(addToReport);
            double[] positiveCasesToInterval = testStore.getPositiveCovidTestsPerDay(currentDate, historicalPoints);
            double[] covidTestsHp = testStore.getTestForHp(currentDate, historicalPoints);
            double[] meanAgeHp = testStore.getMeanAgeForHpDay(currentDate, historicalPoints);
            List<Date> hPDays = testStore.getHPDays();
            reportMultiReg.addConfLevelForMultiRegr(positiveCasesToInterval, covidTestsHp, meanAgeHp, hPDays, confidenceLevel/100);
            addToReport = String.format("\n\nWeek Table\n\n");
            reportMultiReg.addStringToReport(addToReport);
            double[] positiveCasesToIntervalWeek = testStore.getPositiveCovidTestsPerWeek(currentDate, historicalPoints);
            double[] perfomedTestsForHp = testStore.getCovidTestsForWeekHp(currentDate, historicalPoints);
            double[] meanAgeHpWeek = testStore.getMeanAgeForHPWeek(currentDate, historicalPoints);
            List<Date> hPWeeksInitial = testStore.gethPWeeksInitial();
            List<Date> hPWeeksFinal = testStore.gethPWeeksFinal();
            reportMultiReg.addConfLevelForWeekForMultiRegr(positiveCasesToIntervalWeek, perfomedTestsForHp, meanAgeHpWeek, hPWeeksInitial, hPWeeksFinal, confidenceLevel/100);
            reportMultiReg.sendReportNHS();
        }
    }
}
