import java.util.*;
import java.util.stream.*;

public class FilterAndEnumerationStream {


    public static void main(String[] args) {
        // forEach
        Stream stream;
        stream = FeatureFunctions.getStreamStringNumbers();
        stream.forEach(System.out::println);
        System.out.println("=========================");
        
        stream = FeatureFunctions.getStreamStringNumbers();
        stream.forEach(n -> System.out.println(n));
        System.out.println("=========================");
        // filter
        Stream<String> streamStr;
        streamStr = FeatureFunctions.getStreamStringNumbers();
        streamStr.filter(n -> n.length()==3).forEach(n-> System.out.println(n));
        System.out.println("=========================");

        List<Person> personList = new ArrayList<>(
            List.of(
                new Person(20, "user111"),
                new Person(17, "user22"),
                new Person(32, "user3")
            )
        );
        Stream<Person> streamPerson;
        streamPerson = personList.stream();
        streamPerson.filter(n -> n.getAge() > 18).forEach(System.out::println);
        System.out.println("=========================");
        // map
        streamPerson = personList.stream();
        streamPerson.map(n -> "Age: " + n.getAge() + ", name: " + n.getName())
            .forEach(System.out::println);
        System.out.println("=========================");

        IntStream streamAges = personList.stream().map(n -> n.getAge()).mapToInt(n -> n);
        streamAges.forEach(System.out::println);
        System.out.println("=========================");
        // mapToDouble, mapToLong -> convert stream to numeric types
        // mapToObj -> convert to object stream

        //flatMap - link two or more streams
        streamPerson = personList.stream();
        streamPerson.flatMap(n -> Stream.of(
            String.format("Age: %s, name: %s", n.getAge(), n.getName()),
            String.format("Age: %s, name: %s", n.getAge(), "Mr. " + n.getName()) 
        )).forEach(System.out::println);
        System.out.println("=========================");
        // Sorted
        streamPerson = personList.stream();
        // sorted() <- work without arguments if Class implements "Comparable" interface
        streamPerson.sorted(new PersonComparatorByNameLength()).forEach(System.out::println);
        System.out.println("=========================");

    }
}
