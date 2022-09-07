package behavioral.strategy;

/**
 * Стратегия — это поведенческий паттерн проектирования,
 * который определяет семейство схожих алгоритмов и помещает каждый из них в собственный класс,
 * после чего алгоритмы можно взаимозаменять прямо во время исполнения программы.
 */

public class Main {
    public static void main(String[] args) {
        Developer developer = new Developer();

        developer.setActivity(new Sleeping());
        developer.executeSomething();

        developer.setActivity(new Training());
        developer.executeSomething();

        developer.setActivity(new Coding());
        developer.executeSomething();

        developer.setActivity(new Reading());
        developer.executeSomething();

        developer.setActivity(new Sleeping());
        developer.executeSomething();

    }
}
