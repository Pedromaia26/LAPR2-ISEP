package app.controller;

import app.domain.model.Company;
import app.domain.model.LinearRegression;
import app.domain.model.ReportNHS;
import app.domain.model.TestStore;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SendReportController {
    Company company;
    TestStore testStore;
    ReportNHS report;

    public SendReportController() throws OutputException, BarcodeException, ParseException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        this(App.getInstance().getCompany());
    }

    public SendReportController(Company c){
        this.company = c;
        testStore = c.getTestStore();
    }

    public void getReportForDays(Date startDate, Date endDate, Date currentDate, int hP, double sL){
        List<Date> dates = new ArrayList<>();
        System.out.println("tests day");
        double[] covidTests = testStore.covidTestsLinearRegression(startDate, endDate);
        double[] positiveTests = testStore.positiveCovidTestsLinearRegression(startDate, endDate);
        double[] arrayX = {30.0, 35.0, 28.0, 31.0, 25.0, 40.0};
        double[] arrayY = {22.0, 12.0, 23.0, 14.0, 20.0, 20.0};
        dates = testStore.getCovidTestsPerDay(currentDate, hP);
        report = new ReportNHS(testStore.getReportNHS());
        report.createLinearRegression(covidTests, positiveTests, sL/100);
        report.sendReportNHS();
    }

    public void getReportForWeeks(Date startDate, Date endDate, Date currentDate, int hP, double sL){
        System.out.println("tests week");
        double[] covidTests = testStore.covidTestsLinearRegression(startDate, endDate);
        double[] positiveTests = testStore.positiveCovidTestsLinearRegression(startDate, endDate);
        double[] arrayX = {30.0, 35.0, 28.0, 31.0, 25.0, 40.0};
        double[] arrayY = {22.0, 12.0, 23.0, 14.0, 20.0, 20.0};
        testStore.getCovidTestsPerWeek(currentDate, hP);
        report = new ReportNHS(testStore.getReportNHS());
        report.createLinearRegression(arrayX, arrayY, sL/100);
        report.sendReportNHS();
    }

    public void getReportForDaysWithMeanAge(Date startDate, Date endDate, Date currentDate, int hP, double sL){
        System.out.println("mean age day");
        double[] meanAge = testStore.meanAgeLinearRegression(startDate, endDate);
        double[] positiveTests = testStore.positiveCovidTestsLinearRegression(startDate, endDate);
        double[] arrayX = {30.0, 35.0, 28.0, 31.0, 25.0, 40.0};
        double[] arrayY = {22.0, 12.0, 23.0, 14.0, 20.0, 20.0};
        testStore.getCovidTestsPerDay(currentDate, hP);
        report = new ReportNHS(testStore.getReportNHS());
        report.createLinearRegression(arrayX, arrayY, sL/100);
        report.sendReportNHS();
    }

    public void getReportForWeeksWithMeanAge(Date startDate, Date endDate, Date currentDate, int hP, double sL){
        System.out.println("mean age week");
        double[] meanAge = testStore.meanAgeLinearRegression(startDate, endDate);
        double[] positiveTests = testStore.positiveCovidTestsLinearRegression(startDate, endDate);
        double[] arrayX = {30.0, 35.0, 28.0, 31.0, 25.0, 40.0};
        double[] arrayY = {22.0, 12.0, 23.0, 14.0, 20.0, 20.0};
        testStore.getCovidTestsPerWeek(currentDate, hP);
        report = new ReportNHS(testStore.getReportNHS());
        report.createLinearRegression(arrayX, arrayY, sL/100);
        report.sendReportNHS();
    }

}
