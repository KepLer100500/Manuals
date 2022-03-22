package com.epam.rd.autotasks.matrices;
import java.util.Arrays;

public class MultiplyMatrix {
    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {

        int[][] solve = new int[matrix1.length][matrix2[0].length];
        int tempSum = 0;
        for (int a = 0; a < solve.length; a++) {
            for (int b = 0; b < solve[a].length; b++) {
                for (int i = 0; i < matrix1[a].length; i++) {
                    tempSum += matrix1[a][i] * matrix2[i][b];
                }
                solve[a][b] = tempSum;
                tempSum = 0;
            }
        }
        return solve;
    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        // Get a result of your code

        int[][] a = {
                {0, 12345},
                {4509, 0},
                {3, 567} };

        int[][] b = {
                {653, 0, 25353},
                {0, 61, 6} };

        int[][] result = multiply(a, b);
        System.out.println(Arrays.deepToString(result).replace("],", "]\n"));
    }
}
