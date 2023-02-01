import java.util.*;
import java.util.stream.*;

public class OptionalTest {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>(); // empty list
        Stream<Integer> integerStream;
        integerStream = integerList.stream();
        Optional<Integer> min = integerStream.min(Integer::compare);
        // get()
        try {
            System.out.printf("Min element in integer stream: %s%n", min.get());
        } catch(NoSuchElementException e) {
            e.printStackTrace();
        }
        System.out.println("=========================");
        // isPresent()
        if(min.isPresent()) {
            System.out.printf("Min element in integer stream: %s%n", min.get());
        } else {
            System.out.println("List is empty!");
        }
        System.out.println("=========================");
        // orElse()
        System.out.printf("Min element in integer stream: %s%n", min.orElse(-500)); // if not elements: -500
        System.out.println("=========================");
        // orElseThrow() - generate exception
        try {
            System.out.printf("Min element in integer stream: %s%n", min.orElseThrow(IllegalStateException::new));
        } catch(IllegalStateException e) {
            e.printStackTrace();
        }
        System.out.println("=========================");
        // ifPresentOrElse()
        min.ifPresentOrElse(
            n -> System.out.printf("Min element in integer stream: %s%n", n),
            () -> System.out.println("List is empty!")
        );
        System.out.println("=========================");

    }
}
