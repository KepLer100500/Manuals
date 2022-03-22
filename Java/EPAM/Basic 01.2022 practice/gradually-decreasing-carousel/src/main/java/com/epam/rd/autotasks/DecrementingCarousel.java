package com.epam.rd.autotasks;


public class DecrementingCarousel {
    private final int[] carousel;
    private int currentId;
    private final int capacity;
    private boolean isRun;
    private final String decreaseMethod;

    public DecrementingCarousel(int capacity) {
        carousel = new int[capacity];
        this.capacity = capacity;
        currentId = 0;
        isRun = false;
        decreaseMethod = "-";
    }

    public DecrementingCarousel(int capacity, String decreaseMethod) {
        carousel = new int[capacity];
        this.capacity = capacity;
        currentId = 0;
        isRun = false;
        this.decreaseMethod = decreaseMethod;
    }

    public boolean addElement(int element) {
        if (element <= 0 || currentId >= capacity || isRun) {
            return false;
        }
        carousel[currentId] = element;
        currentId++;
        return true;
    }

    public CarouselRun run() {
        if (!isRun) {
            isRun = true;
            return new CarouselRun(carousel, currentId, decreaseMethod);
        }
        return null;
    }

}

