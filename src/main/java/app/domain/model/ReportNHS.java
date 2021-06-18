package app.domain.model;

import com.nhs.report.Report2NHS;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

public class ReportNHS extends TimerTask {
    LinearRegression regression;
    String report;

    public ReportNHS(){
        report = "";
    }

    @Override
    public void run() {
        Report2NHS.writeUsingFileWriter(report);
    }

    public ReportNHS(String report){
        this.report = report;
    }



    public void sendReportNHS(){
        Report2NHS.writeUsingFileWriter(report);
    }

    public void createLinearRegression(double[] arr1, double[] arr2, double sL, double cL){
        double[] predict = new double[arr1.length];
        regression = new LinearRegression(arr1, arr2);

        for(int i=0; i<predict.length; i++){
            predict[i] = regression.predict(arr1[i]);
        }
        report += "Regression model equation: \n";
        report += regression;
        report += "\n";

        report += "Other statistics";
        report += String.format("\nR2 = %.2f", regression.R2());
        report += String.format("\nR2 Adjusted = %.2f", regression.R2Adjusted());
        report += String.format("\nR = %.2f \n", Math.sqrt(regression.R2()));
        report += "\n-----------------------\n";

        report += "\nHypothesis tests for regression coefficients:\n";
        report += "HO:b=0 H1: b<>0\n";
        report += String.format("T_%.3f = %.3f \n", regression.obs(sL), regression.getTStudent(sL));
        report += String.format("\ns2: %.4f\n", regression.S2());
        report += String.format("\ntb: %.4f\n", regression.Tb());
        report += String.format("\nDecision:\n %s\n", regression.decision(sL));

        report += ("\n-----------------------\n");

        report += "Significance model with Anova:\n";
        report += "H0: b=0  H1:b<>0 \n \n";
        report += String.format("%-15s %-5s %-15s %-15s %-15s\n", "","df","SS", "MS", "F");
        report += String.format("%-15s %-5s %-15.4f %-15.4f %-15.4f\n", "Regression", "1",regression.getssr(), regression.getssr(), regression.getssr()/regression.getSvar());
        report += String.format("%-15s %-5s %-15.4f %-15.4f \n", "Residual",regression.getDegressOfFreedom(),regression.getRss(), regression.getSvar());
        report += String.format("%-15s %-5s %-15.4f\n", "Total",1+regression.getDegressOfFreedom(),regression.getssr()+regression.getRss());

        report += ("\n-----------------------\n");

        report += "Decision: f\n";
        report += String.format("0 > f%.2f,(%d.%d)=",sL ,1, regression.getDegressOfFreedom(),regression.getRss());

        report += ("\n\n\n-----------------------\n\n");

        report += String.format("%-50s %-50s %-50s %.0f%% %-50s\n","Date", "Number of OBSERVED positive cases", "Number of ESTIMATED positive cases", cL, "intervals");
    }

    public void addConfLevel(double[] array, double[] arrayToPredict, List<Date> dates, double cL){
        System.out.println("array "+ array.length);
        System.out.println("datas "+ dates.size());
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        regression.confidenceInterval(array, cL);
        for(int i=0;i<array.length; i++){
            report += String.format("%-60s %7.2f %45s %7.2f %48s\n", formatter.format(dates.get(i)), array[i], "", regression.predict(arrayToPredict[i]), regression.confidenceInterval(array, cL).get(i) );
        }
        sendReportNHS();
    }

    public void addConfLevelForWeek(double[] array, double[] arrayToPredict, List<Date> dateInitial, List<Date> dateFinal, double cL){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        for(int i=0;i<array.length; i++){
            report += String.format("%-10s - %-50s %7.2f  %43s %7.2f %45s\n", formatter.format(dateInitial.get(i)),formatter.format(dateFinal.get(i)), array[i], "", regression.predict(arrayToPredict[i]), regression.confidenceInterval(array, cL).get(i) );
        }
        sendReportNHS();
    }



    public String getReport(){
        return report;
    }
}


