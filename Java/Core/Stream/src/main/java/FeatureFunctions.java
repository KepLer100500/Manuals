import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class FeatureFunctions {
    public static List<String> getListStringNumbers() {
        // return list of simple string objects
        return new ArrayList<>(List.of("one", "two", "three", "four", "five"));
    }

    public static Stream<String> getStreamStringNumbers() {
        // return stream of numbers: "one", "two", "three", "four", "five"
        return getListStringNumbers().stream();
    }

    public static List<Person> getPersonList() {
        return new ArrayList<>(List.of(
                        new Person(20, "user11111"),
                        new Person(16, "user2222"),
                        new Person(32, "user333"),
                        new Person(15, "user44"),
                        new Person(40, "user5")
        ));
    }

    public static Stream<Person> getPersonStream() {
        return getPersonList().stream();
    }

    public static void StreamPrinter(Stream... streams) {
        // Prints into console all element of stream with spaces and print after =====================
        for (Stream stream : streams) {
            stream.forEach(value -> System.out.printf("%s ", value));
            System.out.println("\n=====================");
        }
    }

}

class Person {
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

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public int compare(TerminalOperationsOld.Person p1, TerminalOperationsOld.Person p2) {
        if(p1.getName().length() > p2.getName().length()) {
            return 1;
        } else if(p1.getName().length() < p2.getName().length()) {
            return -1;
        }
        return 0;
    }
}

class PersonComparatorByNameLength implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        if(p1.getName().length() > p2.getName().length()) {
            return 1;
        } else if(p1.getName().length() < p2.getName().length()) {
            return -1;
        }
        return 0;
    }
}