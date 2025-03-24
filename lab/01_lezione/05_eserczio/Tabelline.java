public class Tabelline {
    private static void printMatrix(int[][] a) {
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[i].length; j++)
                System.out.println(String.format("Matrix[%s][%s] = %s", i, j, a[i][j]));
    }

    private static int[][] generateTabellina(int dimension) {
        int[][] matrix = new int[dimension][dimension];

        // populating matrix:
        // starting with first row and column
        for (int i = 0; i < dimension; i++) {
            matrix[i][0] = i + 1;
            matrix[0][i] = i + 1;
        }

        // then the rest
        for (int row = 1; row < dimension; row++) {
            for (int col = 1; col < dimension; col++) {
                matrix[row][col] = matrix[row][0] * matrix[0][col];
            }
        }

        return matrix;
    }

    private static void printMatrixEx(int[][] table) {
        System.out.println("----------------------------------------");
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                System.out.print(table[i][j] + "\t");
            }
            System.out.println("");
        }
        System.out.println("----------------------------------------");
    }

    private static int matrixTimes(int[][] table, int first, int second) {
        if (table.length < first || table.length < second) {
            return -1;
        }

        if (first == 0 || second == 0) {
            return 0;
        }

        return table[first - 1][second - 1];
    }

    public static void main(String[] args) {
        int[][] table = generateTabellina(10);
        printMatrix(table);
        printMatrixEx(table);

        System.out.println("matrixTimes(table, 1, 1) = " + matrixTimes(table, 1, 1));
        System.out.println("matrixTimes(table, 3, 5) = " + matrixTimes(table, 3, 5));
        System.out.println("matrixTimes(table, 9, 9) = " + matrixTimes(table, 9, 9));
    }
}
