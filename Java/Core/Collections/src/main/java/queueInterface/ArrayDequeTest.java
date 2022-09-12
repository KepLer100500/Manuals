package queueInterface;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class ArrayDequeTest {
    public static void main(String[] args) {
        Deque<String> stringDeque = new ArrayDeque<>();
        // insert - add / addFirst / addLast / push / offer / offerFirst / offerLast
        boolean isAdded;
        isAdded = stringDeque.add("three");
        stringDeque.addFirst("two");
        stringDeque.addLast("four");
        stringDeque.push("one");
        isAdded = stringDeque.offerFirst("zero");
        isAdded = stringDeque.offerLast("five");
        isAdded = stringDeque.offer("six");
        System.out.printf("Deque has %s elements: %s%n", stringDeque.size(), stringDeque);
        // select - getFirst / getLast / peek / peekFirst / peekLast
        String element;
        element = stringDeque.getFirst();
        System.out.printf("getFirst element: %s%n", element);
        element = stringDeque.getLast();
        System.out.printf("getLast element: %s%n", element);
        element = stringDeque.peek();
        System.out.printf("peek element: %s%n", element);
        element = stringDeque.peekFirst();
        System.out.printf("peekFirst element: %s%n", element);
        element = stringDeque.peekLast();
        System.out.printf("peekLast element: %s%n", element);
        // delete - poll / pollFirst / pollLast / pop / remove / removeFirst / removeLast
        element = stringDeque.poll();
        System.out.printf("poll element: %s, Deque: %s%n", element, stringDeque);
        element = stringDeque.pollFirst();
        System.out.printf("pollFirst element: %s, Deque: %s%n", element, stringDeque);
        element = stringDeque.pollLast();
        System.out.printf("pollLast element: %s, Deque: %s%n", element, stringDeque);
        try {
            element = stringDeque.pop();
            System.out.printf("pop element: %s, Deque: %s%n", element, stringDeque);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

        try {
            element = stringDeque.remove();
            System.out.printf("remove element: %s, Deque: %s%n", element, stringDeque);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

        try {
            element = stringDeque.removeFirst();
            System.out.printf("removeFirst element: %s, Deque: %s%n", element, stringDeque);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

        try {
            element = stringDeque.removeLast();
            System.out.printf("removeLast element: %s, Deque: %s%n", element, stringDeque);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        stringDeque.push("one");
        stringDeque.push("two");
        stringDeque.push("one");
        stringDeque.push("three");
        stringDeque.push("one");
        System.out.printf("Deque: %s%n", stringDeque);
        boolean isFind;
        isFind = stringDeque.removeFirstOccurrence("one");
        System.out.printf("removeFirstOccurrence. Element found and successfully removed: %s, Deque: %s%n", isFind, stringDeque);
        isFind = stringDeque.removeLastOccurrence("one");
        System.out.printf("removeLastOccurrence. Element found and successfully removed: %s, Deque: %s%n", isFind, stringDeque);

    }
}
