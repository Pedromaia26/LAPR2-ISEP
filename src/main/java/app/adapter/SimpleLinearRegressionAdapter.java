package app.adapter;

import app.domain.model.LinearRegression;
import app.domain.model.SimpleLinearRegression;

import java.util.List;

public class SimpleLinearRegressionAdapter implements LinearRegression {

    private SimpleLinearRegression simpleLinearRegression = new SimpleLinearRegression();

//    public SimpleLinearRegressionAdapter(double[] arr1, double[] arr2){
//        this.simpleLinearRegression = new SimpleLinearRegression(arr1, arr2);
//    }

    @Override
    public void setValuesSimpleLinearRegression(double[] x, double[] y) {
        simpleLinearRegression.setValuesSimpleLinearRegression(x, y);
    }

    @Override
    public void setValuesSimpleLinearRegression(double[] x, double[] y, double[] z) {
    }

    @Override
    public double intercept() {
        return simpleLinearRegression.intercept();
    }

    @Override
    public double slope() {
        return simpleLinearRegression.slope();
    }

    @Override
    public double R2() {
        return simpleLinearRegression.R2();
    }

    @Override
    public double R2Adjusted() {
        return simpleLinearRegression.R2Adjusted();
    }

    @Override
    public double interceptStdErr() {
        return simpleLinearRegression.interceptStdErr();
    }

    @Override
    public double slopeStdErr() {
        return simpleLinearRegression.slopeStdErr();
    }

    @Override
    public double predict(double x) {
        return simpleLinearRegression.predict(x);
    }

    @Override
    public double getSvar() {
        return simpleLinearRegression.getSvar();
    }

    @Override
    public double obs(double sL) {
        return simpleLinearRegression.obs(sL);
    }

    @Override
    public double S2() {
        return simpleLinearRegression.S2();
    }

    @Override
    public double Tb() {
        return simpleLinearRegression.Tb();
    }

    @Override
    public String decision(double sL) {
        return simpleLinearRegression.decision(sL);
    }

    @Override
    public double getssr() {
        return simpleLinearRegression.getssr();
    }

    @Override
    public double getRss() {
        return simpleLinearRegression.getRss();
    }

    @Override
    public int getDegressOfFreedom() {
        return simpleLinearRegression.getDegressOfFreedom();
    }

    @Override
    public String getConfidenceIntervals() {
        return simpleLinearRegression.getConfidenceIntervals();
    }

    @Override
    public double getTStudent(double cL) {
        return simpleLinearRegression.getTStudent(cL);
    }

    @Override
    public List<String> confidenceInterval(double[] arrayX, double cL) {
        return simpleLinearRegression.confidenceInterval(arrayX, cL);
    }

    @Override
    public double getFDistribution(double sL) {
        return simpleLinearRegression.getFDistribution(sL);
    }

    @Override
    public String decisionAnova(double sL) {
        return simpleLinearRegression.decisionAnova(sL);
    }

    @Override
    public String getEquation() {
        return simpleLinearRegression.getEquation();
    }
}
