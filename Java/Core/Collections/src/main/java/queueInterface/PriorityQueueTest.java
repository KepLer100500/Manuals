package queueInterface;

import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {
    // default size = 11
    public static void main(String[] args) {
        Queue<String> priorityQueue = new PriorityQueue<>();
        // insert - add / offer
        boolean isAdded;
        isAdded = priorityQueue.add("zero");
        System.out.printf("Queue has %s elements: %s%n", priorityQueue.size(), priorityQueue);

        isAdded = priorityQueue.offer("one");
        System.out.printf("Queue has %s elements: %s%n", priorityQueue.size(), priorityQueue);
        // select - element / peek
        String element;
        try {
            element = priorityQueue.element();
            System.out.printf("Get last element: %s%n", element);
        } catch (NoSuchElementException err) {
            err.printStackTrace();
        }
        element = priorityQueue.peek();
        System.out.printf("Get last element: %s%n", element);
        // delete - remove / poll
        try {
            element = priorityQueue.remove();
            System.out.printf("Remove and get last element: %s%n", element);
        } catch (NoSuchElementException err) {
            err.printStackTrace();
        }

        element = priorityQueue.poll();
        System.out.printf("Remove and get last element: %s%n", element);
    }
}
