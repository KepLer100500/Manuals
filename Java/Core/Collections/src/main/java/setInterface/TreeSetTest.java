package setInterface;

import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Set;

public class TreeSetTest {
    public static void main(String[] args) {
        // SortedSet, NavigableSet <- interfaces
        NavigableSet<String> stringSet = new TreeSet<>();
        boolean isAdded;
        isAdded = stringSet.add("el 1");
        System.out.printf("Set added new element %s: %s%n", isAdded, stringSet);
        isAdded = stringSet.add("el 22");
        System.out.printf("Set added new element %s: %s%n", isAdded, stringSet);
        isAdded = stringSet.add("el 333");
        System.out.printf("Set added new element %s: %s%n", isAdded, stringSet);
        isAdded = stringSet.add("el 1");
        System.out.printf("Set added new element %s: %s%n", isAdded, stringSet);
        System.out.printf("Set size %s: %s%n", stringSet.size(), stringSet);

        String first = stringSet.first();
        String last = stringSet.last();
        System.out.printf("Firts element: %s, Last element: %s%n", first, last);

        SortedSet<String> stringSubSet = new TreeSet<>();
        stringSubSet = stringSet.headSet("el 333");
        System.out.printf("headSet: %s%n", stringSubSet);
        stringSubSet = stringSet.subSet("el 22", "el 333");
        System.out.printf("subSet: %s%n", stringSubSet);
        stringSubSet = stringSet.tailSet("el 22");
        System.out.printf("tailSet: %s%n", stringSubSet);

        boolean isContain = stringSet.contains("el 1");
        System.out.printf("Set contain element 'el 1': %s, size %s: %s%n", isContain, stringSet.size(), stringSet);

        boolean isRemoved =  stringSet.remove("el 1");
        System.out.printf("Set remove element: %s, size %s: %s%n", isRemoved, stringSet.size(), stringSet);

        NavigableSet<Integer> integerSet = new TreeSet<>();
        integerSet.addAll(new TreeSet<>(Set.of(2, 4, 1, 5, 3)));
        System.out.printf("Set integer elements, size %s: %s%n", integerSet.size(), integerSet);
        
        Integer leastElementBigger = integerSet.ceiling(2); // e>=obj
        System.out.printf("leastElementBigger: %s%n", leastElementBigger);
        Integer biggerElementLeast = integerSet.floor(3); // e<=obj
        System.out.printf("biggerElementLeast: %s%n", biggerElementLeast);
        Integer leastElementBiggerStrong = integerSet.higher(2); // e>obj
        System.out.printf("leastElementBiggerStrong: %s%n", leastElementBiggerStrong);
        Integer biggerElementLeastStrong = integerSet.lower(3); // e<obj
        System.out.printf("biggerElementLeastStrong: %s%n", biggerElementLeastStrong);

        Integer firstElement = integerSet.pollFirst();
        Integer lastElement = integerSet.pollLast();
        System.out.printf("Firts element: %s, Last element: %s, Set: %s%n", 
            firstElement, lastElement, integerSet);

        NavigableSet<Integer> descSet = integerSet.descendingSet();
        System.out.printf("Desc Set: %s%n", descSet);

        Person person1 = new Person(20, "TestUser1");
        Person person2 = new Person(40, "TestUser2");
        Person person3 = new Person(30, "TestUser3");
        Set<Person> personSet = new TreeSet<>(Set.of(person1, person2, person3));
        // Sorting set persons auto -> release interface Comparable in Person class
        System.out.printf("Set of persons: %s%n", personSet);
    }

    static class Person implements Comparable<Person> {
        private Integer age;
        private String name;

        public Person(Integer age, String name) {
            this.age = age;
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public String toString() {
            return name + ": " + age;
        }

        public int compareTo(Person p) {
            return age.compareTo(p.getAge());
        }

    }
}
