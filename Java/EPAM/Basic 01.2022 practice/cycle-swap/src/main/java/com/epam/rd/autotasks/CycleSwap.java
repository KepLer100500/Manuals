package com.epam.rd.autotasks;

class CycleSwap {
    static void cycleSwap(int[] array) {
        if (array.length != 0) {
            int lastElement = array[array.length-1];
            for (int i = array.length - 1; i > 0; i--) {
                array[i] = array[i-1];
            }
            array[0] = lastElement;
        }
    }

    static void cycleSwap(int[] array, int shift) {
        for (int i = 0; i < shift; i++) {
            cycleSwap(array);
        }
    }
}
