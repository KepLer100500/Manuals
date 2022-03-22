package com.epam.rd.autotasks;
import java.util.Arrays;


public class CarouselRun {
    private final int[] carousel;
    private int currentId;
    private final int capacity;
    private final String decreaseMethod;

    CarouselRun(int[] carousel, int realCapacity, String decreaseMethod) {
        this.carousel = Arrays.copyOf(carousel, realCapacity);
        for (int e: this.carousel) {
            System.out.print(e + " ");
        }
        System.out.println();
        currentId = 0;
        this.capacity = realCapacity;
        this.decreaseMethod = decreaseMethod;
    }

    public int getCurrentValue(int id) {
        int currentValue = carousel[id];
        if (currentValue != 0) {
            switch (decreaseMethod) {
                case("/"): {
                    carousel[id]/=2; break;
                }
                default: carousel[id]--; break;
            }
        }
        currentId++;
        if (currentId == capacity) {
            currentId = 0;
        }
        return currentValue;
    }

    public int next() {
        int curValue;
        do {
            if (capacity == 0 || Arrays.stream(carousel).sum() == 0) {
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

