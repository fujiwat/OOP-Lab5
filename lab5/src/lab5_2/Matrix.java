package lab5_2;

import java.util.Random;

public class Matrix {
    private double[][] data;
    private int rows;
    private int columns;

    // Constructor
    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.data = new double[rows][columns];
    }

    public Matrix(double[][] data) {
        this.data = new double[data.length][];
        this.rows = data.length;
        for (int i = 0; i < data.length; i++) {
            this.data[i] = new double[data[i].length];
            System.arraycopy(data[i], 0, this.data[i], 0, data[i].length);
        }
        this.columns = data[0].length;
    }

    public Matrix(Matrix matrix) {
        double[][] data;
        data = matrix.data;
        this.rows = data.length;
        this.columns = data[0].length;
        this.data = new double[data.length][];
        for (int i = 0; i < data.length; i++) {
            this.data[i] = new double[data[i].length];
            System.arraycopy(data[i], 0, this.data[i], 0, data[i].length);
        }
    }

    // method
    public void fillRandom(double a, double b) {
        Random random = new Random();
        for (int i = 0; i < this.data.length; i++) {
            for (int j = 0; j < this.data[i].length; j++) {
                data[i][j] = random.nextDouble() * Math.abs(a - b) + Math.min(a, b);
            }
        }
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }

    public void printMatrix() {
        String str = "";
        for (int i = 0; i < data.length; i++) {
            System.out.print(str.equals("") ? "{{" : ", {");
            str = "";
            for (int j = 0; j < data[i].length; j++) {
                if (str.equals("")) {
                    str = str + String.format("%.2f", data[i][j]);
                } else {
                    str = str + ", " + String.format("%.2f", data[i][j]);
                }
            }
            System.out.print(str + " }");
        }
        System.out.println("}");
    }

    public static Matrix add(Matrix a, Matrix b) {
        if (!(a.getRows() == b.getRows() && a.getColumns() == b.getColumns())) {
            // can not calculate!
            return null;
        }
        double[][] result = new double[a.getRows()][a.getColumns()];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = a.data[i][j] + b.data[i][j];
            }
        }
        return new Matrix(result);
    }

    public static Matrix multiply(Matrix a, Matrix b) {
        if (a.getColumns() != b.getRows()) {
            return null;                 // can not calculate
        }
        double[][] result = new double[a.getRows()][b.getColumns()];
        for (int i = 0; i < a.getRows(); i++) {
            for (int j = 0; j < b.getColumns(); j++) {
                double t = 0;
                for (int k = 0; k < a.getRows(); k++) {
                    t += a.data[i][k] * b.data[k][i];
                }
                result[i][j] = t;
            }
        }
        return new Matrix(result);
    }

    public static Matrix transpose(Matrix a) {
        double[][] result = new double[a.getColumns()][a.getRows()];
        for (int i=0; i<result.length; i++ ) {
            for (int j=0; j<result[i].length; j++) {
                result[i][j] = a.data[j][i];
            }
        }
        return new Matrix(result);
    }
}
