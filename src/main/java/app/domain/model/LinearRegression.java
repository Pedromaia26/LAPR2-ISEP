package app.domain.model;

import java.util.List;

public interface LinearRegression {
    void setValuesSimpleLinearRegression(double[] x, double[] y);
    void setValuesSimpleLinearRegression(double[] x, double[] y, double[] z);
    double intercept();
    double slope();
    double R2();
    double R2Adjusted();
    double interceptStdErr();
    double slopeStdErr();
    double predict(double x);
    double getSvar();
    double obs(double sL);
    double S2();
    double Tb();
    String decision (double sL);
    double getssr();
    double getRss();
    int getDegressOfFreedom();
    String getConfidenceIntervals();
    double getTStudent(double cL);
    List<String> confidenceInterval(double[] arrayX, double cL);
    double getFDistribution(double sL);
    String decisionAnova(double sL);
    String getEquation();
}
