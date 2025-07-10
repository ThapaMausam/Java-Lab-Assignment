package CoreJava.Lab10;

import java.util.Scanner;

public class MatrixMultiply {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of row and column for first matrix(positive): ");
        int row1 = sc.nextInt();
        int col1 = sc.nextInt();

        System.out.print("Enter number of row and column for second matrix(positive): ");
        int row2 = sc.nextInt();
        int col2 = sc.nextInt();

        if (col1 != row2) {
            System.out.println("Matrix multiplication not possible.");
        } else {
            int[][] matrix1 = new int[row1][col1];
            int[][] matrix2 = new int[row2][col2];
            int[][] multiply = new int[row1][col2];

            System.out.println("Enter first matrix elements: ");
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < col1; j++) {
                    System.out.print("Enter [" + (i + 1) + "][" + (j + 1) + "]: ");
                    matrix1[i][j] = sc.nextInt();
                }
            }

            System.out.println("Enter second matrix elements: ");
            for (int i = 0; i < row2; i++) {
                for (int j = 0; j < col2; j++) {
                    System.out.print("Enter [" + (i + 1) + "][" + (j + 1) + "]: ");
                    matrix2[i][j] = sc.nextInt();
                }
            }

            // Multiply Logic
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < col2; j++) {
                    for (int k = 0; k < col1; k++) {
                        multiply[i][j] += matrix1[i][k] * matrix2[k][j];
                    }
                }
            }

            System.out.println("Matrix1: ");
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < col1; j++) {
                    System.out.print(matrix1[i][j] + "\t");
                }
                System.out.println();
            }

            System.out.println("Matrix2: ");
            for (int i = 0; i < row2; i++) {
                for (int j = 0; j < col2; j++) {
                    System.out.print(matrix2[i][j] + "\t");
                }
                System.out.println();
            }

            System.out.println("Matrix1 X Matrix2: ");
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < col2; j++) {
                    System.out.print(multiply[i][j] + "\t");
                }
                System.out.println();
            }
        }

        sc.close();
    }
}
