class Matrix {
    private int _rows;
    private int _columns;
    private int _matrix[][];

    public Matrix(int rows, int cols) {
        _rows = rows;
        _columns = cols;
        _matrix = new int[rows][cols];
    }

    public int get(int x, int y) {
        return _matrix[x][y];
    }

    public void set(int x, int y, int value) {
        assert _matrix != null;
        _matrix[x][y] = value;
    }

    public int rows() {
        return _rows;
    }

    public int columns() {
        return _columns;
    }

    public Matrix sum(Matrix second) {
        if (this.columns() != second.columns() || this.rows() != second.rows()) {
            System.out.println("Both matrixes must have the same dimension!");
            return null;
        }

        Matrix sumMatrix = new Matrix(this.rows(), this.columns());
        for (int r = 0; r < this.rows(); r++) {
            for (int c = 0; c < this.columns(); c++) {
                sumMatrix.set(r, c, this.get(r, c) + second.get(r, c));
            }
        }
        return sumMatrix;
    }

    private void multiplyIrr(Matrix second) {
        if (this.columns() != second.rows()) {
            return;
        }

        for (int row = 0; row < this.rows(); row++) {
            for (int col = 0; col < this.columns(); col++) {
                int value = 0;
                for (int leftCol = 0; leftCol < this.columns(); leftCol++) {
                    int partial = this.get(row, leftCol) * second.get(leftCol, col);
                    value += partial;
                }

                this.set(row, col, value);
            }
        }
    }

    public Matrix multiply(Matrix second) {
        if (this.columns() != second.rows()) {
            return null;
        }

        Matrix result = new Matrix(this.rows(), second.columns());

        for (int row = 0; row < result.rows(); row++) {
            for (int col = 0; col < result.columns(); col++) {
                int value = 0;
                for (int leftCol = 0; leftCol < this.columns(); leftCol++) {
                    int partial = this.get(row, leftCol) * second.get(leftCol, col);
                    value += partial;
                }

                result.set(row, col, value);
            }
        }

        return result;
    }

    public Matrix pow(int exp) {
        if (exp == 0) {
            Matrix zeroResult = new Matrix(this.columns(), this.columns());
            for (int c = 0; c < this.columns(); c++) {
                zeroResult.set(c, c, 1);
            }
            return zeroResult;
        }

        Matrix mat = new Matrix(this.rows(), this.columns());

        for (int r = 0; r < mat.rows(); r++) {
            for (int c = 0; c < mat.columns(); c++) {
                mat.set(r, c, this.get(r, c));
            }
        }

        if (exp == 1) {
            return mat;
        }

        for (int e = 2; e <= exp; e++) {
            mat = mat.multiply(mat);
        }

        return mat;
    }
}

public class MatrixDemo {
    public static void main(String args[]) {
        Matrix m1 = new Matrix(3, 3);
        m1.set(0, 0, 1);
        m1.set(0, 1, 2);
        m1.set(0, 2, 3);

        m1.set(1, 0, 4);
        m1.set(1, 1, 5);
        m1.set(1, 2, 6);

        m1.set(2, 0, 7);
        m1.set(2, 1, 8);
        m1.set(2, 2, 9);

        Matrix m2 = new Matrix(3, 3);
        m2.set(0, 0, 1);
        m2.set(0, 1, 1);
        m2.set(0, 2, 1);

        m2.set(1, 0, 1);
        m2.set(1, 1, 1);
        m2.set(1, 2, 1);

        m2.set(2, 0, 1);
        m2.set(2, 1, 1);
        m2.set(2, 2, 1);

        Matrix m3 = m1.sum(m2);
        assert m3.get(0, 0) == 2;
        assert m3.get(0, 1) == 3;
        assert m3.get(0, 2) == 4;

        assert m3.get(1, 0) == 5;
        assert m3.get(1, 1) == 6;
        assert m3.get(1, 2) == 7;

        assert m3.get(2, 0) == 8;
        assert m3.get(2, 1) == 9;
        assert m3.get(2, 2) == 10;

        // mul test
        Matrix mulLeft = new Matrix(3, 3);
        mulLeft.set(0, 0, 2);
        mulLeft.set(0, 1, 3);
        mulLeft.set(0, 2, 2);

        mulLeft.set(1, 0, 2);
        mulLeft.set(1, 1, 3);
        mulLeft.set(1, 2, 1);

        mulLeft.set(2, 0, 2);
        mulLeft.set(2, 1, 1);
        mulLeft.set(2, 2, 0);

        Matrix mulRight = new Matrix(3, 2);
        mulRight.set(0, 0, 3);
        mulRight.set(0, 1, 1);

        mulRight.set(1, 0, 3);
        mulRight.set(1, 1, 2);

        mulRight.set(2, 0, 1);
        mulRight.set(2, 1, 0);

        Matrix mulResult = mulLeft.multiply(mulRight);
        assert mulResult.get(0, 0) == 17 : "Error, value should be: 17";
        assert mulResult.get(0, 1) == 8 : "Error, value should be: 8";

        assert mulResult.get(1, 0) == 16 : "Error, value should be: 16";
        assert mulResult.get(1, 1) == 8 : "Error, value should be: 8";

        assert mulResult.get(2, 0) == 9 : "Error, value should be: 9";
        assert mulResult.get(2, 1) == 4 : "Error, value should be: 4";

        // pow
        Matrix powMat = new Matrix(2, 2);
        powMat.set(0, 0, 1);
        powMat.set(0, 1, 2);

        powMat.set(1, 0, 3);
        powMat.set(1, 1, 4);

        Matrix zeroMat = powMat.pow(0);
        assert zeroMat.get(0, 0) == 1 : "Error, value should be: 1";
        assert zeroMat.get(0, 1) == 0 : "Error, value should be: 0";

        assert zeroMat.get(1, 0) == 0 : "Error, value should be: 0";
        assert zeroMat.get(1, 1) == 1 : "Error, value should be: 1";

        Matrix oneMat = powMat.pow(1);
        assert oneMat.get(0, 0) == 1 : "Error, value should be: 1";
        assert oneMat.get(0, 1) == 2 : "Error, value should be: 2";

        assert oneMat.get(1, 0) == 3 : "Error, value should be: 3";
        assert oneMat.get(1, 1) == 4 : "Error, value should be: 4";
    }
}