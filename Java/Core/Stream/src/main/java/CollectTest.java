import java.util.*;
import java.util.stream.*;

public class CollectTest {
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

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * age;
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Person person = (Person) o;

            if (name != null ? !name.equals(person.getName()) : person.getName() != null) return false;
            return age == person.getAge();
        }  
    }

    public static void main(String[] args) {
        List<Person> userList = new ArrayList<>();
        Collections.addAll(
            userList, 
            new Person(10, "user111"), 
            new Person(20, "user22"), 
            new Person(30, "user3"), 
            new Person(10, "user111"), 
            new Person(20, "user22")
        );
        System.out.println("=========================");
        System.out.println("Original list: " + userList);
        System.out.println("=========================");
        // Collectors.toList()
        List<Person> userListLengthMoreFiveSimbols = 
            userList.stream().filter(n->n.getName().length()>5).collect(Collectors.toList());
        System.out.println("List: " + userListLengthMoreFiveSimbols);
        System.out.println("=========================");
        // Collectors.toSet()
        Set<Person> userSetLengthMoreFiveSimbols = 
            userList.stream().filter(n->n.getName().length()>5).collect(Collectors.toSet());
        System.out.println("Set: " + userSetLengthMoreFiveSimbols);
        System.out.println("=========================");
        // Collectors.toMap()
        /*
        Map<String, Integer> userMapLengthMoreFiveSimbols = 
            userList.stream().filter(n->n.getName().length()>5).collect(Collectors.toMap(
                k -> k.getName(),
                v -> v.getAge()
            ));
        System.out.println("Map: " + userMapLengthMoreFiveSimbols);
        System.out.println("=========================");
        */
    }
}
