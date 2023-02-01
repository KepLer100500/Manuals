import java.util.*;
import java.util.stream.*;

/**
 * Life stages:
 * 1: Create stream
 * 2: Intermediate operations
 * 3: Terminate operation
 */

public class CreateStream {

    public static void main(String[] args) {
        List<String> stringList = FeatureFunctions.getListStringNumbers();
        Stream<String> stringStream1 = stringList.stream();
        Stream<String> stringStream2 = Stream.of("one", "two", "three");

        IntStream intStream1 = Arrays.stream(new int[] {1, 2, 3, 4, 5}); // intStream1.boxed() -> convert to object stream
        IntStream intStream2 = IntStream.of(1, 2, 3, 4, 5);

        LongStream longStream1 = Arrays.stream(new long[] {100, 250, 30000, 400000000, 555});
        LongStream longStream2 = LongStream.of(100, 250, 30000, 400000000, 555);

        DoubleStream doubleStream1 = Arrays.stream(new double[] {1.2, 2.5, 3.8, 4.0, 5.1});
        DoubleStream doubleStream2 = DoubleStream.of(1.2, 2.5, 3.8, 4.0, 5.1);

        FeatureFunctions.StreamPrinter(stringStream1, stringStream2, intStream1.boxed(), intStream2.boxed(),
                longStream1.boxed(), longStream2.boxed(),doubleStream1.boxed(), doubleStream2.boxed());
    }

}
