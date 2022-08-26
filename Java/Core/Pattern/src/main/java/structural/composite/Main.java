package structural.composite;

/**
 * Компоновщик (Composite) - для группировки малых компонентов в более крупные структуры
 */

public class Main {
    public static void main(String[] args) {
        Team team = new Team();
        Developer firstJavaDeveloper = new JavaDeveloper();
        Developer secondJavaDeveloper = new JavaDeveloper();
        Developer cppDeveloper = new CppDeveloper();

        team.addDeveloper(firstJavaDeveloper);
        team.addDeveloper(secondJavaDeveloper);
        team.addDeveloper(cppDeveloper);

        team.createProject();
    }
}