package behavioral.iterator;

/**
 * Итератор — это поведенческий паттерн проектирования, который даёт возможность последовательно обходить
 * элементы составных объектов, не раскрывая их внутреннего представления.
 */

public class Main {
    public static void main(String[] args) {
        String[] skills = {"Java", "Hibernate", "Postgres"};
        JavaDeveloper javaDeveloper = new JavaDeveloper("KepLer", skills);

        Iterator iterator = javaDeveloper.getIterator();
        System.out.println("Java developer name: " + javaDeveloper.getName());
        System.out.print("Skills: ");
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
