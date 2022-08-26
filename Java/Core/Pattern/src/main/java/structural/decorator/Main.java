package structural.decorator;

/**
 * Decorator (Декоратор) - для динамического добавления новых обязанностей объекту
 */

public class Main {
    public static void main(String[] args) {
        Developer developer = new TeamLeadJavaDeveloper(new SeniorJavaDeveloper(new JavaDeveloper()));

        System.out.println(developer.makeJob());
    }
}
