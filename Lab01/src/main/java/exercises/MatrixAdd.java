package exercises;

import java.util.Scanner;

public class MatrixAdd {
    private static void print(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so hang ma tran: ");
        int rows = sc.nextInt();
        System.out.print("Nhap so cot ma tran: ");
        int cols = sc.nextInt();

        int[][] matrixA = new int[rows][cols];
        int[][] matrixB = new int[rows][cols];
        int[][] res = new int[rows][cols];

        System.out.println("Nhap phan tu cho A:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrixA[i][j] = sc.nextInt();
            }
        }

        System.out.println("Nhap phan tu cho B:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrixB[i][j] = sc.nextInt();
            }
        }

        // Cộng hai ma trận
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }

        System.out.println("A:");
        print(matrixA);

        System.out.println("B:");
        print(matrixB);

        System.out.println("A + B:");
        print(res);
    }
}
