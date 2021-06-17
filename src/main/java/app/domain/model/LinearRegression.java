package app.domain.model; /******************************************************************************
 *  Compute least squares solution to y = beta * x + alpha.
 *  Simple linear regression.
 ******************************************************************************/

import org.apache.commons.math3.distribution.FDistribution;
import org.apache.commons.math3.distribution.TDistribution;

import java.util.ArrayList;
import java.util.List;

/**
 *  The code LinearRegression class performs a simple linear regression
 *  on an set of n data points (y_i, x_i).
 *  That is, it fits a straight line y = alpha + beta * x,
 *  (where y is the response variable, x is the predictor variable,
 *  alpha is the y-intercept, and beta is the slope)
 *  that minimizes the sum of squared residuals of the linear regression model.
 *  It also computes associated statistics, including the coefficient of
 *  determination R^2 and the standard deviation of the
 *  estimates for the slope and y-intercept.
 *
 */
public class LinearRegression {
    private final double intercept, slope;
    private final double r2;
    private final double rss;
    private final int degressOfFreedom;
    private double r2adjusted;
    private final double svar0, svar1;
    private final double s2;
    private final double tb;
    private final double ssr;
    private final double svar;
    private final double xxBar;
    private TDistribution tDistribution;
    private FDistribution fDistribution;
    private List<String> confidenceIntervals = new ArrayList<>();




    /**
     * Performs a linear regression on the data points (y[i], x[i]).
     *
     * @param  x the values of the predictor variable
     * @param  y the corresponding values of the response variable
     * @throws IllegalArgumentException if the lengths of the two arrays are not equal
     */
    public LinearRegression(double[] x, double[] y) {
        if (x.length != y.length) {
            throw new IllegalArgumentException("array lengths are not equal");
        }
        int n = x.length;

        // first pass
        double sumx = 0.0, sumy = 0.0, sumx2 = 0.0;
        for (int i = 0; i < n; i++) {
            sumx  += x[i];
            sumx2 += x[i]*x[i];
            sumy  += y[i];
        }
        double xbar = sumx / n;
        double ybar = sumy / n;

        // second pass: compute summary statistics
        double xxbar = 0.0, yybar = 0.0, xybar = 0.0;
        for (int i = 0; i < n; i++) {
            xxbar += (x[i] - xbar) * (x[i] - xbar);
            yybar += (y[i] - ybar) * (y[i] - ybar);
            xybar += (x[i] - xbar) * (y[i] - ybar);
        }

        slope  = xybar / xxbar;
        intercept = ybar - slope * xbar;
        //System.out.println(slope);

        // more statistical analysis
        double rss = 0.0;      // residual sum of squares
        double ssr = 0.0;      // regression sum of squares
        for (int i = 0; i < n; i++) {
            double fit = slope*x[i] + intercept;
            rss += (fit - y[i]) * (fit - y[i]);
            ssr += (fit - ybar) * (fit - ybar);
        }

        this.ssr = ssr;
        this.rss = rss;


        int degreesOfFreedom = n-2;

        tDistribution = new TDistribution(degreesOfFreedom);

        this.degressOfFreedom = degreesOfFreedom;
        r2    = ssr / yybar;
        double svar  = rss / degreesOfFreedom;

        this.svar = svar;

        svar1 = svar / xxbar;
        //System.out.println(svar1);
        svar0 = svar/n + xbar*xbar*svar1;
        r2adjusted = 1 - ((double)(n - 1) / (double)(n - (2))) * (1 - r2);

        s2 = 1/(double)(n-2) * rss;
        tb = slope/(Math.sqrt(s2)/Math.sqrt(xxbar));

        xxBar = xxbar;

    }



    /**
     * Returns the y-intercept alpha of the best of the best-fit line y = alpha + beta * x.
     *
     * @return the y-intercept alpha of the best-fit line y = alpha + beta * x
     */
    public double intercept() {
        return intercept;
    }

    /**
     * Returns the slope beta of the best of the best-fit line y = alpha + beta * x.
     *
     * @return the slope beta of the best-fit line y = alpha + beta * x
     */
    public double slope() {
        return slope;
    }

    /**
     * Returns the coefficient of determination R^2.
     *
     * @return the coefficient of determination R^2,
     *         which is a real number between 0 and 1
     */
    public double R2() {
        return r2;
    }


    public double R2Adjusted(){
        return r2adjusted;
    }

    /**
     * Returns the standard error of the estimate for the intercept.
     *
     * @return the standard error of the estimate for the intercept
     */
    public double interceptStdErr() {
        return Math.sqrt(svar0);
    }



    /**
     * Returns the standard error of the estimate for the slope.
     *
     * @return the standard error of the estimate for the slope
     */
    public double slopeStdErr() {
        return Math.sqrt(svar1);
    }

    /**
     * Returns the expected response y given the value of the predictor
     * variable x.
     *
     * @param  x the value of the predictor variable
     * @return the expected response y given the value of the predictor
     *         variable x
     */
    public double predict(double x) {
        return slope*x + intercept;
    }

    /**
     * Returns a string representation of the simple linear regression model.
     *
     * @return a string representation of the simple linear regression model,
     *         including the best-fit line and the coefficient of determination
     *         R^2
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(String.format("%.2f n + %.2f", slope(), intercept()));
        s.append("  (R^2 = " + String.format("%.3f", R2()) + ")");
        return s.toString();
    }

    public double getSvar() {
        return svar;
    }

    public double obs(double sL){
        return 1-(sL/2);
    }

    public double S2() {
        return s2;
    }

    public double Tb() {
        return tb;
    }

    public String decision (double sL){
       // System.out.println(tDistribution.inverseCumulativeProbability(obs(sL)));

        if (Math.abs(tb)>tDistribution.cumulativeProbability(obs(sL)))

            return "Reject HO";

        return "No reject H0";
    }

    public double getssr() {
        return ssr;
    }

    public double getRss() {
        return rss;
    }

    public int getDegressOfFreedom() {
        return degressOfFreedom;
    }

//    public void decisionFDist(double sL){
//        FDistribution fDistribution = new FDistribution(1, getDegressOfFreedom());;
//        if(0>fDistribution.inverseCumulativeProbability(1-sL)){
//            return ""
//        }
//    }

    public String getConfidenceIntervals() {
        return confidenceIntervals.toString();
    }

    public double getTStudent(double cL){
        return tDistribution.inverseCumulativeProbability(cL);
    }

    public List<String> confidenceInterval(double[] arrayX, double cL){
        double soma = 0;
        for (int i = 0; i < arrayX.length; i++) {
            soma += arrayX[i];
        }

        double media = soma/arrayX.length;

        double delta = getTStudent(cL) * Math.sqrt(s2)*Math.sqrt((double) 1/arrayX.length+(Math.pow((arrayX[0]-media),2))/xxBar);


        for (int i = 0; i < arrayX.length; i++) {
            confidenceIntervals.add(String.format("%.4f - %.4f\n" ,predict(arrayX[i])-delta, predict((arrayX[i]))+delta));
        }
        return confidenceIntervals;
    }



}

