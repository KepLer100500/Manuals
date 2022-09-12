package listInterface;

import java.util.*;

public class ArrayListTest {
    public static void main(String[] args) {
        // default size = 10
        List<String> stringList = new ArrayList<>();
        stringList.add("one");
        stringList.add("two");
        stringList.add("three");
        stringList.add(0, "zero");
        stringList.add("two");
        System.out.println(stringList);

        String elem = stringList.get(1);
        System.out.println(elem);

        int firstIndex = stringList.indexOf("two");
        System.out.println("First index of 'two': " + firstIndex);

        int lastIndex = stringList.lastIndexOf("two");
        System.out.println("Last index of 'two': " + lastIndex);

        ListIterator<String> stringListIterator = stringList.listIterator();
        System.out.print("ListIterator: ");
        while(stringListIterator.hasNext()) {
            System.out.print(stringListIterator.next() + " ");
        }
        System.out.println();

        List<String> stringList1 = List.of("el 1", "el 22", "el 333");
        System.out.println(stringList1);

        String element1 = stringList.remove(0);
        System.out.println("Removed: " + element1);
        System.out.println(stringList);

        boolean isElementRemoved = stringList.remove("two");
        System.out.println("Removed first element 'two': " + isElementRemoved);
        System.out.println(stringList);

        String changedElement = stringList.set(2, "five");
        System.out.println("changedElement: " + changedElement);
        System.out.println(stringList);

        boolean isAddedNewElements = stringList.addAll(0, stringList1);
        System.out.println("Added new elements: " + isAddedNewElements);
        System.out.println(stringList);

        List<String> subList = stringList.subList(1, 4);
        System.out.println("Sublist by indexes 1-4 of original list: " + subList);

        Object[] objects = stringList.toArray();
        System.out.print("Now it is array: ");
        Arrays.stream(objects).forEach(n -> System.out.print(n + " "));
        System.out.println();

        Comparator myComparator = new ComparatorBySize();
        stringList.sort(myComparator);
        System.out.println("Sorted list by strings size: " + stringList);

        stringList.clear();
        System.out.println("Now, list is empty: " + stringList);

        Person person1 = new Person(30, "Tom");
        Person person2 = new Person(20, "Tom");
        Person person3 = new Person(10, "Bill");
        Person person4 = new Person(40, "Bill");
        Person person5 = new Person(50, "Gary");
        List<Person> personList = new ArrayList<>(List.of(
            person1, person2, person3, person4, person5
        ));
        // java 8 -> thenComparing()
        Comparator<Person> nameAndAge = new PersonNameComparator().thenComparing(new PersonAgeComparator());
        personList.sort(nameAndAge);
        System.out.println("Sorting by name and age personList: " + personList);

    }

    static class ComparatorBySize implements Comparator<String> {
        // interface "Comparator" is more agile than interface "Comparable"
        @Override
        public int compare(String o1, String o2) {
            if(o1.length() > o2.length()) {
                return 1;
            } else if(o1.length() < o2.length()) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    static class Person {
        Integer age;
        String name;

        public Person(Integer age, String name) {
            this.age = age;
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        public String toString() {
            return name + ": " + age;
        }
    }

    static class PersonNameComparator implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            return p1.getName().compareTo(p2.getName());
        }
    }

    static class PersonAgeComparator implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            if(p1.getAge() > p2.getAge()) {
                return 1;
            } else if(p1.getAge() < p2.getAge()) {
                return -1;
            } else {
                return 0;
            }
        }
    }


}
