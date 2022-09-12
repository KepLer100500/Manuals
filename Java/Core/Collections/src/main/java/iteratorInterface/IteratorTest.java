package iteratorInterface;

import java.util.*;

public class IteratorTest {
    public static void main(String[] args) {
        System.out.println("===============\nIterator test\n===============");
        Integer[] array = {1, 2, 3, 4, 5};
        List<Integer> integerList = new ArrayList<>(Arrays.asList(array));
        Iterator iterator = integerList.iterator();
        while(iterator.hasNext()) {
            System.out.printf("%s%n", iterator.next());
        }

        System.out.println("===============\nListIterator test\n===============");
        ListIterator<Integer> listIterator = integerList.listIterator();
        System.out.printf("Has next: %s%n", listIterator.hasNext());
        Integer element;
        element = listIterator.next();
        System.out.printf("First element: %s%n", element);

        listIterator.add(-2); // add -> -2
        listIterator.next();

        listIterator.set(-3); // change 2 -> -3
        listIterator.next();

        listIterator.remove(); // delete -> 3

        // print elements desc
        while(listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }

        System.out.printf("Now list is: %s%n", integerList);

    }
}
