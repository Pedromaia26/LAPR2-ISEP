package app.domain.model;


import app.controller.App;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import com.nhs.report.Report2NHS;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import java.util.Properties;
import java.util.TimerTask;

public class ReportNHS extends TimerTask {
    private SimpleLinearRegression regression;
    private Multilinearregression multilinearregression;
    private String report;
    private String api;

    public ReportNHS(){
        this.report = "";
        this.api = "Domain.ReportNHS";
    }

    @Override
    public void run() {
        Report2NHS.writeUsingFileWriter(report);
    }

    public ReportNHS(String report){
        this.report = report;
    }

    /**
     * Send the nhs report
     */

    public void sendReportNHS() throws OutputException, BarcodeException, ParseException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        reportApi().writeUsingFileWriter(report);
    }

    /**
     * calculate and create the file of the linear regression
     */
    public void createLinearRegression(double[] arr1, double[] arr2, double sL, double cL, String parameter){
        regression = new SimpleLinearRegression(arr1, arr2);
        report += "Regression model equation: \n";
        report += regression.getEquation();
        report += "\n";

        report += "Other statistics";
        report += String.format("\nR2 = %.2f", regression.R2());
        report += String.format("\nR2 Adjusted = %.2f", regression.R2Adjusted());
        report += String.format("\nR = %.2f \n", Math.sqrt(regression.R2()));
        report += "\n-----------------------\n";

        hypothesisTest(parameter, sL);

        report += ("\n-----------------------\n");

        report += "Significance model with Anova:\n";
        report += "H0: b=0  H1:b<>0 \n \n";
        report += String.format("%-15s %-5s %-15s %-15s %-15s\n", "","df","SS", "MS", "F");
        report += String.format("%-15s %-5s %-15.4f %-15.4f %-15.4f\n", "Regression", "1",regression.getssr(), regression.getssr(), regression.getssr()/regression.getSvar());
        report += String.format("%-15s %-5s %-15.4f %-15.4f \n", "Residual",regression.getDegressOfFreedom(),regression.getRss(), regression.getSvar());
        report += String.format("%-15s %-5s %-15.4f\n", "Total",1+regression.getDegressOfFreedom(),regression.getssr()+regression.getRss());

        report += ("\n-----------------------\n");

        report += "Decision: f\n";
        report += String.format("f > f%.2f,(%d.%d)= %.3f\n",sL ,1, regression.getDegressOfFreedom(),regression.getRss(), regression.getFDistribution(sL));
        report += regression.decisionAnova(sL);

        report += ("\n\n\n-----------------------\n\n");


    }

    /**
     * add the confidance level
     */
    public void addConfLevel(double[] array, double[] arrayToPredict, List<Date> dates, double cL) throws OutputException, BarcodeException, ParseException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        report += String.format("%-50s %-50s %-50s %.0f%% %-50s\n","Date", "Number of OBSERVED positive cases", "Number of ESTIMATED positive cases", cL*100, "intervals");
        for(int i=0;i<array.length; i++){
            report += String.format("%-60s %7.2f %45s %7.2f %48s\n", formatter.format(dates.get(i)), array[i], "", regression.predict(arrayToPredict[i]), regression.confidenceInterval(arrayToPredict, cL).get(i) );
        }
    }
    /**
     * add the confidance level for weeks
     */
    public void addConfLevelForWeek(double[] array, double[] arrayToPredict, List<Date> dateInitial, List<Date> dateFinal, double cL) throws OutputException, BarcodeException, ParseException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        report += String.format("%-50s %-50s %-50s %.0f%% %-50s\n","Date", "Number of OBSERVED positive cases", "Number of ESTIMATED positive cases", cL*100, "intervals");
        for(int i=0;i<array.length; i++){
            report += String.format("%-10s - %-50s %7.2f  %43s %7.2f %45s\n", formatter.format(dateInitial.get(i)),formatter.format(dateFinal.get(i)), array[i], "", regression.predict(arrayToPredict[i]), regression.confidenceInterval(arrayToPredict, cL).get(i) );
        }
    }

    /**
     * Select the right report api by config file .
     * @return the right adapter.
     */

    public ReportToNHS reportApi() throws OutputException, BarcodeException, ParseException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Properties prop = App.getInstance().getprops();
        String classaux = prop.getProperty(getApi());
        Class<?> oClass = Class.forName(classaux);
        return (ReportToNHS) oClass.newInstance();
    }

    /**
     * set the api
     */
    public void setApi(String api){
        this.api = api;
    }

    /**
     * Return the api.
     * @return the api.
     */
    public String getApi(){
        return api;
    }

    /**
     * Return the Report.
     * @return the Report.
     */
    public String getReport(){
        return report;
    }


    /**
     *  Create and add the hypothesis tests to the file
     */

    private void hypothesisTest(String parameter, double sL){
        if(parameter.equals("a")){
            report += "\nHypothesis tests for regression coefficient a:\n";
            report += "HO:a=0 H1: a<>0\n";
            report += String.format("T_%.3f = %.3f \n", regression.obs(sL), regression.getTStudent(sL));
            report += String.format("\ns2: %.4f\n", regression.S2());
            report += String.format("\nta: %.4f\n", regression.Ta());
            report += String.format("\nDecision:\n %s\n", regression.decision(sL, regression.Ta()));
        }else if(parameter.equals("b")){
            report += "\nHypothesis tests for regression coefficient b:\n";
            report += "HO:b=0 H1: b<>0\n";
            report += String.format("T_%.3f = %.3f \n", regression.obs(sL), regression.getTStudent(sL));
            report += String.format("\ns2: %.4f\n", regression.S2());
            report += String.format("\ntb: %.4f\n", regression.Tb());
            report += String.format("\nDecision:\n %s\n", regression.decision(sL, regression.Tb()));
        }else if(parameter.equals("ab")){
            hypothesisTest("a", sL);
            hypothesisTest("b", sL);
        }
    }
    /**
     * calculate and create the file of the multiple linear regression
     */
    public void createMultiLinearRegression(double[] arr1, double[] arr2, double[] arr3, double sL, double cL) throws OutputException, BarcodeException, ParseException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        multilinearregression = new Multilinearregression(arr1, arr2, arr3);
        report += multilinearregression.toString();
        report += String.format("\n\n");
        report += String.format("//\nOther statistics");
        report += String.format("R2 = %.4f\n", multilinearregression.r2());
        report += String.format("R2adjusted = %.4f\n", multilinearregression.r2Adjusted());
        report += String.format("R = %.4f\n", Math.sqrt(multilinearregression.r2()));
        report += String.format("//\nHypothesis tests for multilinearregression coefficient B1\nHO:B1=0 H1: B1<>0 \n");
        report += String.format("t_%.3f = %.3f\n", multilinearregression.obs(sL), multilinearregression.tStudent(sL));
        report += String.format("tB1 = %.3f\n", multilinearregression.Tb(1));
        report += String.format("Decision:\n");
        report += multilinearregression.decisionHypothesisTests(sL, 1);
        report += String.format("\n\n");

        report += String.format("\nHypothesis tests for multilinearregression coefficient B2\nHO:B2=0 H1: B2<>0 \n");
        report += String.format("t_%.3f = %.3f\n", multilinearregression.obs(sL), multilinearregression.tStudent(sL));
        report += String.format("tB2 = %.3f\n", multilinearregression.Tb(2));
        report += String.format("Decision:\n");
        report += String.format(multilinearregression.decisionHypothesisTests(sL, 2));
        report += String.format("\n\n\n");
        report += String.format("Significance model with Anova\n");
        report += String.format("%-15s %-5s %-15s %-15s %-15s\n", "","df","SS", "MS", "F");
        report += String.format("%-15s %-5s %-15.4f %-15.4f %-15.4f\n", "Regression", "2", multilinearregression.sqr(), multilinearregression.mqr(), multilinearregression.mqr()/ multilinearregression.mqe());
        report += String.format("%-15s %-5s %-15.4f %-15.4f \n","Residual", multilinearregression.getDegreesOfFreedom(), multilinearregression.sqe(), multilinearregression.mqe());
        report += String.format("%-15s %-5s %-15.4f\n", "Total", multilinearregression.getDegreesOfFreedom()+2, multilinearregression.sqr()+ multilinearregression.sqe());
        report += String.format("\n\n");
        report += String.format("Decision : f");
        report += String.format("f > %.2f,(%d.%d)= %.3f\n", sL, 2, multilinearregression.getDegreesOfFreedom(), multilinearregression.fDistribution(sL));
        report += (multilinearregression.decision(sL));

        report += String.format("\n\n");




    }
    /**
     * add the confidance level for multiple liner regression
     */
    public void addConfLevelForMultiRegr(double[] array, double[] arrayToPredictx1, double[] arrayToPredictx2, List<Date> dates, double cL) throws OutputException, BarcodeException, ParseException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        report += String.format("%-50s %-50s %-50s %.0f%% %-50s\n","Date", "Number of OBSERVED positive cases", "Number of ESTIMATED positive cases", cL*100, "intervals");
        for(int i=0;i<array.length; i++){
            report += String.format("%-60s %7.2f %45s %7.2f %48s\n", formatter.format(dates.get(i)), array[i], "", multilinearregression.predict(arrayToPredictx1[i], arrayToPredictx2[i]), multilinearregression.confidenceInterval(arrayToPredictx1, arrayToPredictx2, array, cL/100).get(i) );
        }
    }
    /**
     * add the confidance level by weks for multiple liner regression
     */
    public void addConfLevelForWeekForMultiRegr(double[] array, double[] arrayToPredictx1, double[] arrayToPredictx2, List<Date> dateInitial, List<Date> dateFinal, double cL) throws OutputException, BarcodeException, ParseException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        report += String.format("%-50s %-50s %-50s %.0f%% %-50s\n","Date", "Number of OBSERVED positive cases", "Number of ESTIMATED positive cases", cL*100, "intervals");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        for(int i=0;i<array.length; i++){
            report += String.format("%-10s - %-50s %7.2f  %43s %7.2f %45s\n", formatter.format(dateInitial.get(i)),formatter.format(dateFinal.get(i)), array[i], "", multilinearregression.predict(arrayToPredictx1[i], arrayToPredictx2[i]), multilinearregression.confidenceInterval(arrayToPredictx1, arrayToPredictx2, array, cL/100).get(i));
        }
    }

    public double getR2Simple(){
        return regression.R2();
    }

    public void addStringToReport(String text){
        report += text;
    }




}


