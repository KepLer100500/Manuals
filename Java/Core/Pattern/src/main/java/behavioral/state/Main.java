package behavioral.state;

/**
 * Состояние — это поведенческий паттерн проектирования, который позволяет объектам менять поведение
 * в зависимости от своего состояния. Извне создаётся впечатление, что изменился класс объекта.
 */

public class Main {
    public static void main(String[] args) {
        Activity activity = new Sleeping();
        Developer developer = new Developer();
        developer.setActivity(activity);

        for (int i = 0; i < 8; i++) {
            developer.justDoIt();
            developer.changeActivity();
        }
    }
}
