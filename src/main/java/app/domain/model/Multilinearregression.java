package app.domain.model;

import org.apache.commons.math3.distribution.FDistribution;
import org.apache.commons.math3.distribution.TDistribution;

import java.util.ArrayList;
import java.util.List;

public class Multilinearregression {

    private double[][] matrixX, matrixXTransposed, matrixXTX,matrixXTXInverse,matrixYYT;
    private double[] matrixY, matrixXTY, matrixB, matrixXTYInverse, matrixYChapeu, cjj;
    private double sqt, y, sqr, f0, alpha;
    private int degreesOfFreedom;
    private List<String> confidenceIntervals = new ArrayList<>();

    public Multilinearregression(double[] x1, double[] x2, double[] y) {
        if (x1.length!=y.length){
            throw new IllegalArgumentException();
        }
        matrixY = y;
        for (int i = 0; i < y.length; i++) {
            this.y += y[i];
        }
        this.y = this.y / y.length;
        matrixX = matrixX(x1, x2);
        matrixXTransposed = transpose(matrixX);
        matrixXTX = matrixXXT(matrixXTransposed, matrixX);
        matrixXTY = matrixXTY(matrixXTransposed, y);
        matrixXTXInverse = invert(matrixXTX);

        matrixB = multiplyBiArrayWithArray(matrixXTXInverse, matrixXTY);
        matrixYChapeu = multiplyBiArrayWithArray(matrixX, matrixB);
        this.cjj = cjj();
        f0 = testStatsF();

        degreesOfFreedom = x1.length-(2+1);

    }

    private double[][] matrixX(double[] x1, double[] x2) {
        if (x1.length != x2.length) throw new IllegalArgumentException("The arrays sizes should be the same");
        int length = x1.length;

        double[][] matrixAux = new double[length][3];
        // X matrix
        for (int i = 0; i < matrixY.length; i++) {
            matrixAux[i][0] = 1;
            matrixAux[i][1] = x1[i];
            matrixAux[i][2] = x2[i];
        }
        return matrixAux;
    }

    private double[][] transpose(double[][] matrix) {
        double[][] matrixTransposed = new double[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrixTransposed[i][j] = matrix[j][i];
            }
        }

        return matrixTransposed;

    }


    public double[][] matrixXXT(double[][] matrixX, double[][] matrixXTransposed) {
        return multiplyTwoArraysBi(matrixX, matrixXTransposed);
    }

    public double[] matrixXTY(double[][] matrixXTransposed, double[] y) {
        return multiplyBiArrayWithArray(matrixXTransposed, y);

    }

    public static double[][] invert(double a[][]) {
        int n = a.length;
        double x[][] = new double[n][n];
        double b[][] = new double[n][n];
        int index[] = new int[n];
        for (int i = 0; i < n; ++i)
            b[i][i] = 1;

        // Transform the matrix into an upper triangle
        gaussian(a, index);

        // Update the matrix b[i][j] with the ratios stored
        for (int i = 0; i < n - 1; ++i)
            for (int j = i + 1; j < n; ++j)
                for (int k = 0; k < n; ++k)
                    b[index[j]][k]
                            -= a[index[j]][i] * b[index[i]][k];

        // Perform backward substitutions
        for (int i = 0; i < n; ++i) {
            x[n - 1][i] = b[index[n - 1]][i] / a[index[n - 1]][n - 1];
            for (int j = n - 2; j >= 0; --j) {
                x[j][i] = b[index[j]][i];
                for (int k = j + 1; k < n; ++k) {
                    x[j][i] -= a[index[j]][k] * x[k][i];
                }
                x[j][i] /= a[index[j]][j];
            }
        }
        return x;
    }

    // Method to carry out the partial-pivoting Gaussian
    // elimination.  Here index[] stores pivoting order.
    public static void gaussian(double a[][], int index[]) {
        int n = index.length;
        double c[] = new double[n];

        // Initialize the index
        for (int i = 0; i < n; ++i)
            index[i] = i;

        // Find the rescaling factors, one from each row
        for (int i = 0; i < n; ++i) {
            double c1 = 0;
            for (int j = 0; j < n; ++j) {
                double c0 = Math.abs(a[i][j]);
                if (c0 > c1) c1 = c0;
            }
            c[i] = c1;
        }

        // Search the pivoting element from each column
        int k = 0;
        for (int j = 0; j < n - 1; ++j) {
            double pi1 = 0;
            for (int i = j; i < n; ++i) {
                double pi0 = Math.abs(a[index[i]][j]);
                pi0 /= c[index[i]];
                if (pi0 > pi1) {
                    pi1 = pi0;
                    k = i;
                }
            }

            // Interchange rows according to the pivoting order
            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i = j + 1; i < n; ++i) {
                double pj = a[index[i]][j] / a[index[j]][j];

                // Record pivoting ratios below the diagonal
                a[index[i]][j] = pj;

                // Modify other elements accordingly
                for (int l = j + 1; l < n; ++l)
                    a[index[i]][l] -= pj * a[index[j]][l];
            }
        }
    }


    private double sqt() {
        // System.out.println("sqt part: "+matrixY.length*y*y);
        return multipleYTY() - (matrixY.length * y * y);
    }

    private double multipleYTY() {
        double som = 0;
        for (int i = 0; i < matrixY.length; i++) {
            som += Math.pow(matrixY[i], 2);
        }
        return som;
    }

    public double sqr() {
        double som=0;
        for (int i=0; i<matrixB.length; i++){
            som+=matrixB[i]*matrixXTY[i];
        }
        //  System.out.println(som);
        return som-(matrixY.length*(Math.pow(y,2)));

    }

    public double sqe() {
        double som=0;
        for (int i=0; i<matrixB.length; i++){
            som+=matrixB[i]*matrixXTY[i];
        }
        //  System.out.println("bTXtY="+ som);
        return multipleYTY() - som;

    }

    public double r2() {
        return sqr() / sqt();
    }

    public double r2Adjusted() {
        return (1-(((double)(matrixY.length-1)/(matrixY.length-matrixX[0].length))*(1-r2())));
    }

    public double standardDeviation() {
        return sqe() / (matrixY.length - matrixX[0].length);
    }

    private double[] cjj() {
        double[] xt, cjj = new double[matrixY.length];
        for (int i=0; i<matrixX.length; i++){
            xt = matrixX[i];
            double[] aux = multiplyBiArrayWithArray(xt, matrixXTXInverse);
            for (int j=0; j<aux.length; j++){
                cjj[i]+=aux[j]*xt[j];
            }
        }
        return cjj;
    }

    private double[] cjj(double[] x1, double[] x2, double[] y) {
        double[][] matrixXHP = matrixX(x1, x2);
        double[][] matrixXTransposedHP = transpose(matrixXHP);
        double[][] matrixXTXHP = matrixXXT(matrixXTransposedHP, matrixXHP);
        double[][] matrixXTXInverseHP = invert(matrixXTXHP);
        double[] xt, cjj = new double[y.length];
        for (int i=0; i<matrixXHP.length; i++){
            xt = matrixXHP[i];
            double[] aux = multiplyBiArrayWithArray(xt, matrixXTXInverseHP);
            for (int j=0; j<aux.length; j++){
                cjj[i]+=aux[j]*xt[j];
            }
        }
        return cjj;
    }

    public double obs(double sL){
        return 1-(sL/2);
    }

    public double tStudent(double sL) {
        TDistribution td = new TDistribution(degreesOfFreedom);
        double critTD;
        double alphaTD = obs(sL);
        critTD = Math.abs(td.inverseCumulativeProbability(alphaTD));
        return critTD;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("The regression model fitted using data from the interval: \ny = %.2f + %.2fx1 + %.2fx2", matrixB[0], matrixB[1], matrixB[2]));

        return stringBuilder.toString();
    }
    public double[][] multiplyTwoArraysBi(double[][] xt, double[][] x){
        double[][] temp = new double[xt.length][x[0].length];
        for (int i = 0; i < xt.length; i++) {
            for (int j = 0; j < x[0].length; j++) {
                temp[i][j] = 0;
                for (int k = 0; k < x.length; k++) {
                    temp[i][j] += xt[i][k] * x[k][j];
                }
            }
        }
        return temp;
    }
    public double[] multiplyBiArrayWithArray(double[][] x, double[]y){
        double[] temp=new double[x.length];
        int result=-1;
        for (double[] doubles : x) {
            result++;
            for (int j = 0; j < y.length; j++) {
                temp[result] += doubles[j] * y[j];
            }

        }
        return temp;
    }
    public double[] multiplyBiArrayWithArray(double[] x, double[][]y){
        double[] temp=new double[y.length];
        int result=-1;
        for (double[] doubles : y) {
            result++;
            for (int j = 0; j < y.length; j++) {
                temp[result] += doubles[j] * x[j];
            }

        }
        return temp;
    }

    public List<String> confidenceInterval(double[] x1, double[] x2, double[] y, double cL){
        this.alpha = 1-cL;
        double[] cjjHP = cjj(x1, x2, y);

        for (int i=0; i< x1.length; i++){
            confidenceIntervals.add(String.format("%.4f - %.4f\n", predict(x1[i], x2[i])-(tStudent(alpha)*Math.sqrt(standardDeviation()*(1+cjjHP[i]))), predict(x1[i], x2[i])+(tStudent(alpha)*Math.sqrt(standardDeviation()*(1+cjjHP[i])))));
        }
        return confidenceIntervals;
    }
    public double mqr(){
        return sqr()/(double) (matrixX[0].length-1);
    }
    public double mqe(){
        return sqe()/(double) (matrixY.length-matrixX[0].length);
    }
    public double testStatsF(){
        return mqr()/mqe();
    }

    public double fDistribution(double sL){
        FDistribution fd= new FDistribution(matrixX[0].length-1,matrixY.length-matrixX[0].length);
        return fd.inverseCumulativeProbability(1- sL);
    }

    public String decision(double sL){
        if (testStatsF()>fDistribution(sL)){
            return "Reject H0\nThe regression model is significant.";
        }else {
            return "No reject H0\nThe regression model is not significant.";
        }
    }

    public String decisionHypothesisTests(double sL, int parameter){
        if(Math.abs(Tb(parameter))>tStudent(sL)){
            return "Reject H0";
        }else{
            return "No reject H0";
        }
    }

    public double Tb(int parameter){
        return matrixB[parameter]/Math.sqrt((Math.pow(standardDeviation(), 2)*cjj[parameter]));
    }

    public int getDegreesOfFreedom(){
        return degreesOfFreedom;
    }

    public double predict(double x1, double x2){
       return (matrixB[0])+(matrixB[1]*x1)+(matrixB[2]*x2);
    }
}
