package setInterface;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {
        // default size = 16
        Set<String> stringSet = new HashSet<>();
        boolean isAdded;
        isAdded = stringSet.add("one");
        System.out.printf("Set added new element %s: %s%n", isAdded, stringSet);
        isAdded = stringSet.add("two");
        System.out.printf("Set added new element %s: %s%n", isAdded, stringSet);
        isAdded = stringSet.add("three");
        System.out.printf("Set added new element %s: %s%n", isAdded, stringSet);
        isAdded = stringSet.add("one");
        System.out.printf("Set added new element %s: %s%n", isAdded, stringSet);
        System.out.printf("Set size %s: %s%n", stringSet.size(), stringSet);
        stringSet.addAll(new HashSet<>(Set.of("one", "two", "three", "four", "five")));
        System.out.printf("Set size %s: %s%n", stringSet.size(), stringSet);

        boolean isContain = stringSet.contains("one");
        System.out.printf("Set contain element 'one': %s, size %s: %s%n", isContain, stringSet.size(), stringSet);

        boolean isRemoved =  stringSet.remove("one");
        System.out.printf("Set remove element: %s, size %s: %s%n", isRemoved, stringSet.size(), stringSet);
    }
}
