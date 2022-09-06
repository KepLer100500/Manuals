package behavioral.observer;

/**
 * Наблюдатель — это поведенческий паттерн проектирования, который создаёт механизм подписки,
 * позволяющий одним объектам следить и реагировать на события, происходящие в других объектах.
 */

public class Main {
    public static void main(String[] args) {
        JavaDeveloperWebsite javaDeveloperWebsite = new JavaDeveloperWebsite();
        Subscriber subscriber1 = new Subscriber("subscriber1");
        Subscriber subscriber2 = new Subscriber("subscriber2");
        javaDeveloperWebsite.addVacancy("Java");
        javaDeveloperWebsite.addVacancy("Cpp");
        javaDeveloperWebsite.addObserver(subscriber1);
        javaDeveloperWebsite.addObserver(subscriber2);
        javaDeveloperWebsite.addVacancy("SQL");
        javaDeveloperWebsite.removeVacancy("Cpp");

    }
}
