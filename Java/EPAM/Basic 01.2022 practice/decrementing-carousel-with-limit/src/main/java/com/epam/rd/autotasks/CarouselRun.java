package com.epam.rd.autotasks;
import java.util.Arrays;


public class CarouselRun {
    private final int[] carousel;
    private final String decreaseMethod;
    private final int actionLimit;
    private final int capacity;
    private int currentId;
    private int nextCount;
    private int step;

    CarouselRun(int[] carousel, int realCapacity, String decreaseMethod, int actionLimit) {
        this.carousel = Arrays.copyOf(carousel, realCapacity);
        this.capacity = realCapacity;
        this.decreaseMethod = decreaseMethod;
        this.actionLimit = actionLimit;
        currentId = 0;
        nextCount = 0;
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
                }
            }
            nextCount++;
        }
        if (carousel[id] <= 0) { // overminus fix
            carousel[id] = 0;
        }
        currentId++;                 // let's get next item
        if (currentId == capacity) { // end of line
            currentId = 0;
            step++;                  // minus more big number!
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
        return Arrays.stream(carousel).sum() == 0 || (actionLimit !=-1 && nextCount == actionLimit);
    }

}
