/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;

class MatrixMismatchException extends Exception {
    public MatrixMismatchException(String message) {
        super(message);
    }
}

public class MatrixMultiplication {

    public static int[][] multiplyMatrices(int[][] A, int[][] B) throws MatrixMismatchException {
        int rowsA = A.length;
        int colsA = A[0].length;
        int rowsB = B.length;
        int colsB = B[0].length;

        // Step 2: Validate dimensions
        if (colsA != rowsB) {
            throw new MatrixMismatchException(
                "Cannot multiply matrices: columns of A (" + colsA +
                ") must equal rows of B (" + rowsB + ")"
            );
        }

        // Step 3: Initialize result matrix
        int[][] result = new int[rowsA][colsB];

        // Step 4: Triple nested loop for dot product computation
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                int sum = 0;
                for (int k = 0; k < colsA; k++) {
                    sum += A[i][k] * B[k][j];
                }
                result[i][j] = sum;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter rows and cols for Matrix A: ");
            int rA = sc.nextInt();
            int cA = sc.nextInt();
            int[][] A = new int[rA][cA];
            for (int i = 0; i < rA; i++)
                for (int j = 0; j < cA; j++)
                    A[i][j] = sc.nextInt();

            System.out.print("Enter rows and cols for Matrix B: ");
            int rB = sc.nextInt();
            int cB = sc.nextInt();
            int[][] B = new int[rB][cB];
            for (int i = 0; i < rB; i++)
                for (int j = 0; j < cB; j++)
                    B[i][j] = sc.nextInt();

            int[][] result = multiplyMatrices(A, B);
            System.out.println("Resulting Matrix:");
            for (int[] row : result)
                System.out.println(Arrays.toString(row));

        } catch (MatrixMismatchException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}