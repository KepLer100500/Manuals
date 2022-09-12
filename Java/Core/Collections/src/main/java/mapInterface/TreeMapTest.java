package mapInterface;

import java.util.*;

public class TreeMapTest {
    public static void main(String[] args) {
        // sorted by keys map
        NavigableMap<Integer, String> persons = new TreeMap<>();
        persons.put(5, "user5");
        persons.put(1, "user1");
        persons.put(3, "user3");
        persons.put(4, "user4");
        persons.put(2, "user2");

        System.out.printf("Map: %s%n", persons);
        Integer firstKey = persons.firstKey();
        Integer lastKey = persons.lastKey();
        System.out.printf("firstKey: %s, lastKey: %s%n", firstKey, lastKey);

        SortedMap<Integer, String> personsHeadMap = persons.headMap(3); // not include key 3!
        System.out.printf("personsHeadMap: %s%n", personsHeadMap);
        SortedMap<Integer, String> personsTailMap = persons.tailMap(3); // include key 3!
        System.out.printf("personsTailMap: %s%n", personsTailMap);
        SortedMap<Integer, String> personsSubMap = persons.subMap(2, 4); // include key 2, not include key 4!
        System.out.printf("personsSubMap: %s%n", personsSubMap);

        Map.Entry<Integer, String> personFirstEntry = persons.firstEntry(); // firstEntry
        System.out.printf("personFirstEntry item: [key: %s, value: %s]%n", 
                personFirstEntry.getKey(), personFirstEntry.getValue());
        Map.Entry<Integer, String> personLastEntry = persons.lastEntry(); // lastEntry
        System.out.printf("personLastEntry item: [key: %s, value: %s]%n", 
                personLastEntry.getKey(), personLastEntry.getValue());

        Map.Entry<Integer, String> personCeilingEntry = persons.ceilingEntry(3); // k>=obj
        System.out.printf("personCeilingEntry item: [key: %s, value: %s]%n", 
                personCeilingEntry.getKey(), personCeilingEntry.getValue());
        Map.Entry<Integer, String> personFloorEntry = persons.floorEntry(2); // k<=obj
        System.out.printf("personFloorEntry item: [key: %s, value: %s]%n", 
                personFloorEntry.getKey(), personFloorEntry.getValue());

        Map.Entry<Integer, String> personCeilingEntryStrong = persons.higherEntry(3); // k>obj
        System.out.printf("personCeilingEntryStrong item: [key: %s, value: %s]%n", 
                personCeilingEntryStrong.getKey(), personCeilingEntryStrong.getValue());
        Map.Entry<Integer, String> personFloorEntryStrong = persons.lowerEntry(2); // k<obj
        System.out.printf("personFloorEntryStrong item: [key: %s, value: %s]%n", 
                personFloorEntryStrong.getKey(), personFloorEntryStrong.getValue());

        Map.Entry<Integer, String> personPolledFirstEntry = persons.pollFirstEntry(); // get and remove firstEntry
        System.out.printf("personPolledFirstEntry item: [key: %s, value: %s]%n", 
                personPolledFirstEntry.getKey(), personPolledFirstEntry.getValue());
        Map.Entry<Integer, String> personPolledLastEntry = persons.pollLastEntry(); // get and remove lastEntry
        System.out.printf("personPolledLastEntry item: [key: %s, value: %s]%n", 
                personPolledLastEntry.getKey(), personPolledLastEntry.getValue());
        System.out.printf("Map: %s%n", persons);

        // has methods by find keys: ceilingKey(), floorKey(), lowerKey(), higherKey()

    }
}