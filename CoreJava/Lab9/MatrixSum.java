package CoreJava.Lab9;

import java.util.Scanner;

public class MatrixSum {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of row and column(positive): ");
        int row = sc.nextInt();
        int col = sc.nextInt();

        int[][] matrix1 = new int[row][col];
        int[][] matrix2 = new int[row][col];
        int[][] sum = new int[row][col];

        System.out.println("Enter first matrix elements: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Enter [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrix1[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter second matrix elements: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Enter [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrix2[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sum[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        System.out.println("Matrix1: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix1[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("Matrix2: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix2[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("Sum of matrix1 and matrix2: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(sum[i][j] + "\t");
            }
            System.out.println();
        }
        sc.close();
    }
}
