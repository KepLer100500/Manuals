package com.epam.rd.autotasks;
import java.util.Arrays;

public class TaskCarousel {
    int maxLength;
    int currentLength;
    int currentTaskId;
    Task[] tasks;

    public TaskCarousel(int capacity) {
        maxLength = capacity;
        tasks = new Task[maxLength];
        currentTaskId = -1;
        currentLength = 0;
    }

    public boolean addTask(Task task) {
        if (isFull() || task == null || task.isFinished()) {
            return false;
        }
        if (currentLength == tasks.length) {
            tasks = Arrays.copyOf(tasks, tasks.length + 1);
        }
        tasks[currentLength] = task;
        currentLength++;
        return true;
    }

    public boolean execute() {
        do {
            if (isEmpty()) {
                return false;
            }
            currentTaskId++;
            if (currentTaskId == tasks.length) {
                currentTaskId = 0;
            }
        } while (tasks[currentTaskId] == null || tasks[currentTaskId].isFinished());
        tasks[currentTaskId].execute();
        return true;
    }

    private int getCountActualTasks() {
        int actualTasks = 0;
        for (Task t: tasks) {
            if(t != null && !t.isFinished()) {
                actualTasks++;
            }
        }
        return actualTasks;
    }

    public boolean isFull() {
        return getCountActualTasks() == maxLength;
    }

    public boolean isEmpty() {
        return getCountActualTasks() == 0;
    }

    @Override
    public String toString() {
        return "TaskCarousel{" +
                "maxLength=" + maxLength +
                ", currentLength=" + currentLength +
                ", currentTaskId=" + currentTaskId +
                ", tasks=" + Arrays.toString(tasks) +
                '}';
    }
}
