package com.epam.rd.autotasks;
import java.util.Arrays;


public class CarouselRun {
    private final int[] carousel;
    private int currentId;
    private final int capacity;
    private final String decreaseMethod;
    private int step;

    CarouselRun(int[] carousel, int realCapacity, String decreaseMethod) {
        this.carousel = Arrays.copyOf(carousel, realCapacity);
        for (int e: this.carousel) {
            System.out.print(e + " ");
        }
        System.out.println();
        currentId = 0;
        this.capacity = realCapacity;
        this.decreaseMethod = decreaseMethod;
        step = 1;
    }

    public int getCurrentValue(int id) {
        int currentValue = carousel[id];
        if (currentValue != 0) {
            switch (decreaseMethod) {
                case("/"): {
                    carousel[id]/=2;
                    break;
                }
                case("gradually"): {
                    carousel[id]-=step;
                    break;
                }
                default: {
                    carousel[id]--;
                    break;
                }
            }
        }
        if (carousel[id] <= 0) { // overminus fix
            carousel[id] = 0;
        }

        currentId++;
        if (currentId == capacity) { // end of line
            currentId = 0;
            step++;
        }
        return currentValue;
    }

    public int next() {
        int curValue;
        do {
            if (capacity == 0 || isFinished()) {
                return -1;
            }
            curValue = getCurrentValue(currentId);
        } while (curValue <= 0);
        return curValue;
    }

    public boolean isFinished() {
        return Arrays.stream(carousel).sum() == 0;
    }

}

