public class MatrixMultiplicationDemo {
    public static void main(String[] args) {
   
        int[][] A = {
            {1, 2, 3},
            {4, 5, 6}
        };

        int[][] B = {
            {7, 8},
            {9, 10},
            {11, 12}
        };

        try {
            System.out.println("Matrix A:");
            MatrixOperations.printMatrix(A);

            System.out.println("\nMatrix B:");
            MatrixOperations.printMatrix(B);

            int[][] result = MatrixOperations.multiplyMatrices(A, B);

            System.out.println("\nResultant Matrix (A x B):");
            MatrixOperations.printMatrix(result);

        } catch (MatrixMismatchException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}