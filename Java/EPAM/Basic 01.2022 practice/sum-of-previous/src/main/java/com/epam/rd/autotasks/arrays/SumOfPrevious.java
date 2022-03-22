package com.epam.rd.autotasks.arrays;

import java.util.Arrays;

public class SumOfPrevious {

    public static void main(String[] args) {
        int[] array = new int[]{1, -1, 0, 4, 6, 10, 15, 25};

        System.out.println(Arrays.toString(getSumCheckArray(array)));
    }

    public static boolean[] getSumCheckArray(int[] array){
        boolean[] solution = new boolean[array.length];
        Arrays.fill(solution, false);
        for (int i = 2; i < array.length; i++) {
            if (array[i] == array[i-1] + array[i-2]) {
                solution[i] = true;
                // System.arraycopy(new boolean[] {true}, 0, solution, i, 1);
            }
        }
        return solution;
    }
}
