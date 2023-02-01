import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntermediateOperations {
    private static void forEachTest() {
        Stream stream;
        stream = FeatureFunctions.getStreamStringNumbers();
        stream.forEach(System.out::print);
        System.out.println("\n=====================");

        stream = FeatureFunctions.getStreamStringNumbers();
        stream.forEach(n -> System.out.println(n + " "));
        System.out.println("=====================");
    }

    private static void filterTest() {
        Stream<String> stringStream = FeatureFunctions.getStreamStringNumbers();
        stringStream = stringStream.filter(n -> n.length() == 3);

        Stream<Person> personStream = FeatureFunctions.getPersonStream();
        personStream = personStream.filter(n -> n.getAge() > 18);

        FeatureFunctions.StreamPrinter(stringStream, personStream);
    }

    private static void mapTest() {
        Stream<Person> personStream;
        personStream = FeatureFunctions.getPersonStream();
        Stream<Object> objectStream = personStream.map(n -> "Age: " + n.getAge() +
                ", name: " + n.getName()); // map() returns Object stream

        personStream = FeatureFunctions.getPersonStream();
        IntStream personAgesStream = personStream.map(n -> n.getAge()).mapToInt(n -> n);
        // or map(Person::getAge) - also works
        // mapToDouble, mapToLong -> convert stream to numeric types
        // mapToObj -> convert to object stream

        personStream = FeatureFunctions.getPersonStream();
        Stream<Object> personTwoStreams = personStream.flatMap(n -> Stream.of( //flatMap - link two or more streams
                String.format("[Age: %s, name: %s]", n.getAge(), n.getName()),
                String.format("(Age: %s, name: %s)", n.getAge(), "Mr." + n.getName())
        ));

        FeatureFunctions.StreamPrinter(objectStream, personAgesStream.boxed(), personTwoStreams);
    }

    public static void main(String[] args) {
        forEachTest();
        filterTest();
        mapTest();
    }

}
