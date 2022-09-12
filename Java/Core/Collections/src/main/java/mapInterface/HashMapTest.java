package mapInterface;

import java.util.*;

public class HashMapTest {
    public static void main(String[] args) {
        Map<Integer, String> persons = new HashMap<>();
        persons.put(1, "user1");
        persons.put(2, "user2");
        persons.put(3, "user3");

        boolean isMapEmpty = persons.isEmpty();
        int mapSize = persons.size();
        boolean isContainKey = persons.containsKey(2);
        boolean isContainValue = persons.containsValue("user2");
        System.out.printf("Map: %s%n", persons);
        System.out.printf("Map size: %s%n", mapSize);
        System.out.printf("Map is empty: %s%n", isMapEmpty);
        System.out.printf("Map contain key '2': %s%n", isContainKey);
        System.out.printf("Map contain value 'user2': %s%n", isContainValue);
        // insert
        persons.put(1, "user111"); // override value
        System.out.printf("Map: %s%n", persons);
        persons.putIfAbsent(1, "user000"); // not override value
        System.out.printf("Map: %s%n", persons);
        // select
        String someValue;
        someValue = persons.get(1);
        System.out.printf("Get some value: %s%n", someValue);
        someValue = persons.getOrDefault(0, "default!!!");
        System.out.printf("Get some value: %s%n", someValue);
        someValue = persons.get(0); // undefound value
        System.out.printf("Get some value: %s%n", someValue);
        // delete
        String removedValue = persons.remove(1);
        System.out.printf("Removed value: %s%n", removedValue);
        // Set of keys and values
        Set<Map.Entry<Integer, String>> setPersons = persons.entrySet();
        System.out.printf("entrySet: %s%n", setPersons);
        for(Map.Entry<Integer, String> item : setPersons) {
            System.out.printf("entrySet item: [key: %s, value: %s, hashCode: %s]%n", 
                item.getKey(), item.getValue(), item.hashCode());
            item.setValue("new Value!");
            System.out.printf("entrySet item: [key: %s, value: %s, hashCode: %s]%n", 
                item.getKey(), item.getValue(), item.hashCode());
        }

        Set<Integer> setIntegerPersons = persons.keySet();
        System.out.printf("setIntegerPersons: %s%n", setIntegerPersons);
        Collection<String> collectionStringPersons = persons.values();
        System.out.printf("collectionStringPersons: %s%n", collectionStringPersons);

        

    }
}