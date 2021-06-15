package app.domain.model;

import java.sql.Array;
import java.sql.SQLOutput;


public class LinearRegressionMain {

    public static void main(String[] args) {
        double[] arrayX = {30.0, 35.0, 28.0, 31.0, 25.0, 40.0};
        double[] arrayY = {22.0, 12.0, 23.0, 14.0, 20.0, 20.0};
        double sL = 0.05;

        LinearRegression regression = new LinearRegression(arrayX, arrayY);
        System.out.println("Regression model equation: ");
        System.out.println(regression);
        System.out.println();

        System.out.println("Number of ESTIMATED/EXPECTED positive cases: ");
        System.out.println();
        for (int i = 0; i < arrayX.length; i++) {
            System.out.printf("%.4f\n", regression.predict(arrayX[i]));
        }

        System.out.println();
        System.out.println("Coeficiente a:");
        System.out.println(regression.intercept());
        System.out.println("Erro-padrão para o coeficiente a:");
        System.out.println(regression.interceptStdErr());
        System.out.println("R2");
        System.out.println(regression.R2());
        System.out.println("R2 Adjusted:");
        System.out.println(regression.R2Adjusted());
        System.out.println("R:");
        System.out.println(Math.sqrt(regression.R2()));

        System.out.println("Erro-padrão para o coeficiente b:");
        System.out.println(regression.slopeStdErr());
        System.out.println("Coeficiente b:");
        System.out.println(regression.slope());

        System.out.println("-----------------------");


        System.out.println("Hypothesis tests for regression coefficients:");
        System.out.println("");
        System.out.printf("T_%.3f =  \n", regression.obs(sL));
        System.out.printf("s2: %.4f\n", regression.S2());
        System.out.printf("tb: %.4f\n", regression.Tb());
        System.out.printf("Decision: %s\n", regression.decisao(sL));

        System.out.println("-----------------------");

        System.out.println("Significance model with Anova:\n");
        System.out.println("REGRESSION:");
        //número de variáveis
        System.out.printf("df: 1\n");
        //Soma quadrática
        System.out.printf("SS: %f\n", regression.getssr());
        //Média quadrática
        System.out.printf("MS: %f\n", regression.getssr()/1);
        //F - divisao entre média quadrática de regressao e residual
        System.out.printf("F: %f\n", regression.getssr()/regression.getSvar());

        System.out.println();

        System.out.println("RESIDUAL:");
        System.out.printf("df: %d\n", regression.getDegressOfFreedom());
        //Soma quadrática
        System.out.printf("SS: %f\n", regression.getRss());
        //Média quadrática
        System.out.printf("MS: %f\n", regression.getSvar());

        System.out.println();

        System.out.println("TOTAL:");
        System.out.printf("df: %d\n", 1+regression.getDegressOfFreedom());
        System.out.printf("SS: %.1f\n", regression.getssr()+regression.getRss());


    }
}
