package com.epam.rd.autotasks;

import java.util.Arrays;

class Spiral {
    static int[][] spiral(int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        for (int[] row: matrix) {
            Arrays.fill(row, 0);
        }
        int i = 0, j = 0;
        int dest = columns == 1 ? 2 : 1;
        for (int num = 1; num <= rows * columns; num++) {
            matrix[i][j] = num;
            switch (dest) {
                case 1: j++; break;
                case 2: i++; break;
                case 3: j--; break;
                case 4: i--; break;
            }
            if (dest == 1 && (j + 1 >= columns || matrix[i][j+1] != 0)) {
                dest = 2;
                continue;
            }
            if (dest == 2 && (i + 1 >= rows || matrix[i+1][j] != 0)) {
                dest = 3;
                continue;
            }
            if (dest == 3 && (j <= 0 || matrix[i][j-1] != 0)) {
                dest = 4;
                continue;
            }
            if (dest == 4 && (i <= 0 || matrix[i-1][j] != 0)) {
                dest = 1;
            }
        }
        return matrix;
    }
}
