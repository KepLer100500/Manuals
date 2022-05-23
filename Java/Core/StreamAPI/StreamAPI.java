import java.util.stream.*;
import java.util.*;


class Person {
    String name;
    String surname;
    String email;

    Person(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    @Override
    public String toString() {
        return name + ", " + surname + " - " + email;
    }
}

class SurnameEmail {
    String surname;
    String email;

    SurnameEmail(String surname, String email) {
        this.surname = surname;
        this.email = email;
    }

    @Override
    public String toString() {
        return surname + " - " + email;
    }

    @Override
    public int hashCode() {
        int result = surname != null ? surname.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SurnameEmail surnameEmail = (SurnameEmail) o;

        if (surname != null ? !surname.equals(surnameEmail.surname) : surnameEmail.surname != null) return false;
        return email != null ? email.equals(surnameEmail.email) : surnameEmail.email == null;
    }
}


public class StreamAPI {
    private static void objectFilter() {
        Person[] persons = new Person[3];
        persons[0] = new Person("Ivan", "Ivanov", "Ivan@Ivanov.ru");
        persons[1] = new Person("Sidor", "Sidorov", "Sidor@Sidorov.ru");
        persons[2] = new Person("Ivan", "Petrov", "Ivan@Petrov.ru");

        Stream<Person> myStream = Arrays.stream(persons);
        myStream.filter(n -> n.name.equals("Ivan")).forEach(System.out::println);
        System.out.println();

        Arrays.stream(persons).filter(n -> n.surname.contains("ov")).forEach(System.out::println);
    }

    private static ArrayList<Integer> listBuilder() {
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(7);
        myList.add(3);
        myList.add(4);
        myList.add(2);
        myList.add(5);
        myList.add(1);
        myList.add(6);
        return myList;
    }

    private static void minMax(ArrayList<Integer> myList) {
        Stream<Integer> myStream = myList.stream();
        Optional<Integer> minValue = myStream.min(Integer::compare);
        if(minValue.isPresent()) {
            System.out.println("Min: " + minValue.get());
        }

        Optional<Integer> maxValue = myList.stream().max(Integer::compare);
        if(maxValue.isPresent()) {
            System.out.println("Max: " + maxValue.get());
        }
    }

    private static void reduceTest(ArrayList<Integer> myList) {
        Optional<Integer> sumValue = myList.stream().reduce((a, b) -> (a + b));
        if(sumValue.isPresent()) {
            myList.stream().sorted().forEach(result -> System.out.print(result + " + "));
            System.out.println("= " + sumValue.get());
        }

        int sum = myList.stream().reduce(500, (a, b) -> (a + b)); // 500 - first item
        System.out.println(sum);

        int sumEven = myList.stream().reduce(1000, (a, b) -> {
            if(b % 2 == 0) {
                return a + b;
            }
            return a;
        }); // 1000 - first item
        System.out.println(sumEven);
    }

    private static void sortStream(ArrayList<Integer> myList) {
        Stream<Integer> myStream = myList.stream().sorted();
        myStream.forEach(System.out::print);
        System.out.println();

        myList.stream().sorted().forEach(result -> System.out.print(result + " "));
        System.out.println();

        myList.stream().
                sorted().
                filter((n) -> (n % 2) == 1).
                filter((n) -> (n > 3)).
                forEach(n -> System.out.print(n + " "));
        System.out.println();
    }

    private static void parallelTest(ArrayList<Integer> myList) {
        int sumRoots = myList.parallelStream().reduce(1000, 
                                                        (a, b) -> (a + (int)Math.pow(b, 2)), // storage
                                                        (a, b) -> (a + b)); // combiner
        System.out.println("sumRoots: " + sumRoots);
    }

    private static void mapTest() {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("Ivan", "Ivanov", "Ivan@Ivanov.ru"));
        persons.add(new Person("Sidor", "Sidorov", "Sidor@Sidorov.ru"));
        persons.add(new Person("Ivan", "Petrov", "Ivan@Petrov.ru"));

        // name, surname, email -> surname, email
        Stream<SurnameEmail> surnameEmailStream = persons.stream().map(
            (person) -> new SurnameEmail(person.surname, person.email)
        );
        surnameEmailStream.forEach(System.out::println);
    }

    private static void streamToList() {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("Ivan", "Ivanov", "Ivan@Ivanov.ru"));
        persons.add(new Person("Sidor", "Sidorov", "Sidor@Sidorov.ru"));
        persons.add(new Person("Ivan", "Petrov", "Ivan@Petrov.ru"));
        persons.add(new Person("Ivan", "Petrov", "Ivan@Petrov.ru"));
        persons.add(new Person("Ivan", "Petrov", "Ivan@Petrov.ru"));
        // toList
        Stream<SurnameEmail> surnameEmailStream = persons.stream().map(
            (person) -> new SurnameEmail(person.surname, person.email)
        );
        List<SurnameEmail> surnameEmailList = surnameEmailStream.collect(Collectors.toList());
        System.out.println(surnameEmailList);
        // toSet
        surnameEmailStream = persons.stream().map(
            (person) -> new SurnameEmail(person.surname, person.email)
        );
        Set<SurnameEmail> surnameEmailSet = surnameEmailStream.collect(Collectors.toSet());
        System.out.println(surnameEmailSet);

    }

    public static void main(String[] args) {
        System.out.println("=== RUN ===");
        ArrayList<Integer> myList = listBuilder();
        System.out.println("Source list: " + myList);
        minMax(myList);
        sortStream(myList);
        reduceTest(myList);
        objectFilter();
        parallelTest(myList);
        mapTest();
        streamToList();
    }

}