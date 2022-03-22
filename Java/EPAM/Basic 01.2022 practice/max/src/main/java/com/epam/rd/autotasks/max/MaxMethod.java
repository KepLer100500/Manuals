package com.epam.rd.autotasks.max;

public class MaxMethod {
    public static int max(int[] values) {
        // throw new UnsupportedOperationException();
        int maxValue = values[0];
        for (int element: values) {
            if(element > maxValue){
                maxValue = element;
            }
        }

        return maxValue;
    }
}

