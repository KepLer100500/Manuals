import java.util.*;
import java.util.stream.*;

public class TerminalOperationsOld {
    static class Person {
        private int age;
        private String name;

        Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        public String toString() {
            return String.format("[%s: %s]", name, age);
        }

        public static int compare(Person p1, Person p2) {
            if(p1.getName().length() > p2.getName().length()) {
                return 1;
            } else if(p1.getName().length() < p2.getName().length()) {
                return -1;
            } 
            return 0;
        }
    }

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>(List.of("Tom", "Bob", "Kate", "Jane", "Viktor"));
        stringList.forEach(System.out::println);
        System.out.println("=========================");
        // count
        Stream<String> stringStream;
        stringStream = stringList.stream();
        System.out.printf("Count elements: %s%n", stringStream.count());
        System.out.println("=========================");

        stringStream = stringList.stream();
        System.out.printf("Count elements with length=3: %s%n", 
            stringStream.filter(n -> n.length() == 3).count());
        System.out.println("=========================");
        // find
        stringStream = stringList.stream();
        Optional<String> firstElem = stringStream.findFirst();
        System.out.printf("First element: %s%n", firstElem.get());
        System.out.println("=========================");

        stringStream = stringList.stream();
        Optional<String> anyElem = stringStream.findAny();
        System.out.printf("Any element: %s%n", anyElem.get());
        System.out.println("=========================");
        // match -> returns true/false
        stringStream = stringList.stream();
        boolean anyInStream = stringStream.anyMatch(n -> n.length() > 3);
        System.out.printf("Any element length > 3: %s%n", anyInStream);
        System.out.println("=========================");

        stringStream = stringList.stream();
        boolean allInStream = stringStream.allMatch(n -> n.length() > 3);
        System.out.printf("All elements length > 3: %s%n", allInStream);
        System.out.println("=========================");

        stringStream = stringList.stream();
        boolean notInStream = stringStream.noneMatch(n -> n.equals("MrFix"));
        System.out.printf("Stream not contain 'MrFix': %s%n", notInStream);
        System.out.println("=========================");
        // min/max
        List<Integer> integerList = new ArrayList<>(List.of(2, 4, 5, 1, 8, 10));
        Stream<Integer> integerStream;
        integerStream = integerList.stream();
        Optional<Integer> min = integerStream.min(Integer::compare);
        System.out.printf("Min element in integer stream: %s%n", min.get());
        System.out.println("=========================");

        Stream<Person> personStream = Stream.of(
            new Person(1, "user111"),
            new Person(2, "user22"),
            new Person(3, "user3")
        );
        Optional<Person> max = personStream.max(Person::compare); // compare method release in Person class, and it static method
        System.out.printf("Max length of name person = %s%n", max.get());
        System.out.println("=========================");
        // reduce
        Stream<Integer> intStream = Stream.of(1, 2, 3, 4, 5);
        Optional<Integer> reduceIntStream = intStream.reduce((x, y) -> x * y);
        System.out.printf("Multiply stream: %s%n", reduceIntStream.get());
        System.out.println("=========================");

        Stream<String> strStream;
        strStream = Stream.of("One", "Two", "Three");
        Optional<String> reduceStrStream = strStream.reduce((x, y) -> x + " / " + y);
        System.out.printf("Concat stream words: %s%n", reduceStrStream.get());
        System.out.println("=========================");

        strStream = Stream.of("One", "Two", "Three");
        String firstElementByReduce = "Zero";
        // In this case -> don't need to use Optional<String>, 
        // if use first parameter -> returned value be type first parameter
        String reduceStrStreamWithFirstItem = strStream.reduce(firstElementByReduce, (x, y) -> x + " / " + y);
        System.out.printf("Concat stream words, start with 'Zero': %s%n", reduceStrStreamWithFirstItem);
        System.out.println("=========================");
        
        Stream<Person> personStreamReduce = Stream.of(
            new Person(15, "user111"),
            new Person(20, "user22"),
            new Person(33, "user3")
        );
        
        int sumAges = personStreamReduce.reduce(
            0,          // 0 -> start value
            (x, y) -> { // preparing step - find people age > 18
                if(y.getAge() > 18) {
                    return x + y.getAge();
                } else {
                    return x + 0;
                }
            },
            (x, y) -> { // summing result values
                int sum = x + y;
                return sum;
            }
        );
        System.out.printf("Sum ages persons > 18: %s%n", sumAges);
        System.out.println("=========================");


    }
}
