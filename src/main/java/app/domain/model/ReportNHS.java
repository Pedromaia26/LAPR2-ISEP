package app.domain.model;

import com.nhs.report.Report2NHS;
import com.sun.javafx.binding.StringFormatter;

import java.util.Date;
import java.util.List;

public class ReportNHS {
    LinearRegression regression;
    String report;

    public ReportNHS(){
        report = "";
    }



    public void sendReportNHS(String reportToSend){
        Report2NHS.writeUsingFileWriter(reportToSend);
    }

    public double[] createLinearRegression(double[] arr1, double[] arr2, double sL){
        double[] predict = new double[arr1.length];
        regression = new LinearRegression(arr1, arr2);

        for(int i=0; i<predict.length; i++){
            predict[i] = regression.predict(arr1[i]);
        }
        report += "Regression model equation: \n";
        report += regression;
        report += "\n";

//        report += "Number of ESTIMATED/EXPECTED positive cases: ";
//        report += "\n";
//        for (int i = 0; i < arr1.length; i++) {
//            report += String.format("%.4f\n", regression.predict(arr1[i]));
//        }
//        report += "\n";

//        report += "Coeficiente a:\n";
//        report += regression.intercept();
//        report += "\nErro-padrão para o coeficiente a:\n";
//        report += regression.interceptStdErr();
        report += "Other statistics";
        report += String.format("\nR2 = %.2f", regression.R2());
        report += String.format("\nR2 Adjusted = %.2f", regression.R2Adjusted());
        report += String.format("\nR = %.2f \n", Math.sqrt(regression.R2()));
        report += "\n-----------------------\n";

//        report += "Erro-padrão para o coeficiente b:\n";
//        report += regression.slopeStdErr();
//        report +="\nCoeficiente b:\n";
//        report += regression.slope();
//
//        report += "\n-----------------------\n";


        report += "\nHypothesis tests for regression coefficients:\n";
        report += "HO:b=0 H1: b<>0\n";
        report += String.format("T_%.3f =  \n", regression.obs(sL));
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

        report += String.format("%-15s %-40s %-40s %.0f%% %-40s","Date", "Number of OBSERVED positive cases", "Number of ESTIMATED positive cases", ((1-sL)*100), "intervals");


        report += regression.getConfidenceIntervals();


//        //número de variáveis
//        report += String.format("df: 1\n");
//        //Soma quadrática
//        report += String.format("SS: %f\n", regression.getssr());
//        //Média quadrática
//        report += String.format("MS: %f\n", regression.getssr()/1);
//        //F - divisao entre média quadrática de regressao e residual
//        report += String.format("F: %f\n", regression.getssr()/regression.getSvar());

//        report += "\n";
//
//        report += ("RESIDUAL:");
//        report += String.format("df: %d\n", regression.getDegressOfFreedom());
//        //Soma quadrática
//        report += String.format("SS: %f\n", regression.getRss());
//        //Média quadrática
//        report += String.format("MS: %f\n", regression.getSvar());
//
//        report += "\n";

//        report += ("TOTAL:");
//        report += "\n";
//        report += String.format("df: %d\n", 1+regression.getDegressOfFreedom());
       // report += String.format("SS: %.1f\n", regression.getssr()+regression.getRss());

        return predict;
    }

    public String getReport(){
        return report;
    }
}


