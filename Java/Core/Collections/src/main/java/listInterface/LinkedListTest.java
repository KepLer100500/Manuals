package listInterface;

import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> stringList = new LinkedList<>();
        stringList.add("two");

        stringList.addFirst("one");
        stringList.offerFirst("zero");

        stringList.addLast("three");
        stringList.offerLast("four");
        System.out.println("In stringList " + stringList.size() + " elements: " + stringList);

        String element;
        element = stringList.get(1);
        System.out.println("get(1): " + element);

        element = stringList.peek();
        System.out.println("peek: " + element);

        element = stringList.getFirst();
        System.out.println("getFirst: " + element);

        element = stringList.peekFirst();
        System.out.println("peekFirst: " + element);

        element = stringList.getLast();
        System.out.println("getLast: " + element);

        element = stringList.peekLast();
        System.out.println("peekLast: " + element);

        System.out.println("String List: " + stringList);

        String removedElement;
        removedElement = stringList.remove(1);
        System.out.printf("Removed element (%s): %s%n", removedElement, stringList);

        removedElement = stringList.removeFirst();
        System.out.printf("Removed element (%s): %s%n", removedElement, stringList);

        removedElement = stringList.poll();
        System.out.printf("Removed element (%s): %s%n", removedElement, stringList);

        removedElement = stringList.removeLast();
        System.out.printf("Removed element (%s): %s%n", removedElement, stringList);

        removedElement = stringList.pollLast();
        System.out.printf("Removed element (%s): %s%n", removedElement, stringList);

    }
}
