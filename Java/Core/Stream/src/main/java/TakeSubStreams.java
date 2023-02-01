import java.util.*;
import java.util.stream.*;

public class TakeSubStreams {
    public static void main(String[] args) {
        Stream<Integer> intStream;
        // get items while not found something
        intStream = Stream.of(-3, -2, -1, 0 , 2, 5, -3, 8);
        intStream.takeWhile(n -> n < 0).forEach(System.out::println);
        System.out.println("=========================");
        // not get items while not found something, but if found -> get it
        intStream = Stream.of(-3, -2, -1, 0 , 2, 5, -3, 8);
        intStream.dropWhile(n -> n < 0).forEach(System.out::println);
        System.out.println("=========================");
        // concat - sum two streams
        Stream<String> strStream1 = Stream.of("Tom", "Jerry", "Kate");
        Stream<String> strStream2 = Stream.of("Tom", "Jerry", "Bob");
        Stream.concat(strStream1, strStream2).forEach(System.out::println);
        System.out.println("=========================");
        // distinct - get unique values 
        strStream1 = Stream.of("Tom", "Jerry", "Kate");
        strStream2 = Stream.of("Tom", "Jerry", "Bob");
        Stream.concat(strStream1, strStream2).distinct().forEach(System.out::println);
        System.out.println("=========================");
        // skip - skip first elements and work with other
        Stream<String> phones;
        phones = Stream.of("iPhone", "ASUS", "Sony Xperia", "Xaiomi", "Huawei");
        phones.skip(2).forEach(System.out::println);
        System.out.println("=========================");
        // limit - take only set count elements
        phones = Stream.of("iPhone", "ASUS", "Sony Xperia", "Xaiomi", "Huawei");
        phones.limit(4).forEach(System.out::println);
        System.out.println("=========================");
        
    }
}
