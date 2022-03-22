package com.epam.rd.autotasks;

public class CountDownTask implements Task{
    int countDown;

    public CountDownTask(int value) {
        countDown = Math.max(value, 0); // countDown >= 0
    }

    public int getValue() {
        return countDown;
    }

    @Override
    public void execute() {
        if (!isFinished()) {
            countDown--;
        }
    }

    @Override
    public boolean isFinished() {
        return countDown == 0;
    }

    @Override
    public String toString() {
        return "CountDownTask{" +
                "countDown=" + countDown +
                '}';
    }
}
