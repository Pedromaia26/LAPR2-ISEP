package app.domain.model;

import com.nhs.report.Report2NHS;
import com.sun.javafx.binding.StringFormatter;

import java.util.Date;
import java.util.List;

public class ReportNHS {
    LinearRegression regression;
    String report;

    public ReportNHS(String report){
        this.report = report;
    }



    public void sendReportNHS(){
        Report2NHS.writeUsingFileWriter(report);
    }

    public void createLinearRegression(double[] arr1, double[] arr2, double sL){
        regression = new LinearRegression(arr1, arr2);
        report += "Regression model equation: ";
        report += regression;
        report += "\n";

        report += "Number of ESTIMATED/EXPECTED positive cases: ";
        report += "\n";
        for (int i = 0; i < arr1.length; i++) {
            report += String.format("%.4f\n", regression.predict(arr1[i]));
        }
        report += "\n";

        report += "Coeficiente a:\n";
        report += regression.intercept();
        report += "\nErro-padrão para o coeficiente a:\n";
        report += regression.interceptStdErr();
        report += "\nR2\n";
        report += regression.R2();
        report += "\nR2 Adjusted:\n";
        report += regression.R2Adjusted();
        report += "\nR:\n";
        report += Math.sqrt(regression.R2());
        report += "\n";

        report += "Erro-padrão para o coeficiente b:\n";
        report += regression.slopeStdErr();
        report +="\nCoeficiente b:\n";
        report += regression.slope();

        report += "\n-----------------------\n";


        report += "\nHypothesis tests for regression coefficients:\n";
        report += "\n";
        report += String.format("T_%.3f =  \n", regression.obs(sL));
        report += String.format("\ns2: %.4f\n", regression.S2());
        report += String.format("\ntb: %.4f\n", regression.Tb());
        report += String.format("\nDecision: %s\n", regression.decision(sL));

        report += ("\n-----------------------\n");

        report += "Significance model with Anova:\n";
        report += "REGRESSION:\n";
        //número de variáveis
        report += String.format("df: 1\n");
        //Soma quadrática
        report += String.format("SS: %f\n", regression.getssr());
        //Média quadrática
        report += String.format("MS: %f\n", regression.getssr()/1);
        //F - divisao entre média quadrática de regressao e residual
        report += String.format("F: %f\n", regression.getssr()/regression.getSvar());

        report += "\n";

        report += ("RESIDUAL:");
        report += String.format("df: %d\n", regression.getDegressOfFreedom());
        //Soma quadrática
        report += String.format("SS: %f\n", regression.getRss());
        //Média quadrática
        report += String.format("MS: %f\n", regression.getSvar());

        report += "\n";

        report += ("TOTAL:");
        report += "\n";
        report += String.format("df: %d\n", 1+regression.getDegressOfFreedom());
        report += String.format("SS: %.1f\n", regression.getssr()+regression.getRss());


    }
}


