package com.epam.rd.autotasks;

public class CompleteByRequestTask implements Task {
    boolean stopStatus;
    boolean lastCommand;

    CompleteByRequestTask() {
        stopStatus = false;
        lastCommand = false;
    }

    @Override
    public void execute() {
        if (lastCommand) {
            stopStatus = true;
        }
    }

    @Override
    public boolean isFinished() {
        return stopStatus;
    }

    public void complete() {
        lastCommand = true;
    }

    @Override
    public String toString() {
        return "CompleteByRequestTask{" +
                "stopStatus=" + stopStatus +
                ", lastCommand=" + lastCommand +
                '}';
    }

}
