package behavioral.visitor;

/**
 * Посетитель — это поведенческий паттерн проектирования, который позволяет добавлять в программу новые операции,
 * не изменяя классы объектов, над которыми эти операции могут выполняться.
 */

public class Main {
    public static void main(String[] args) {
        Project project = new Project();
        Developer junior = new Junior();
        Developer senior = new Senior();

        System.out.println("Junior in Action:");
        project.beWritten(junior);
        System.out.println("\n=================\n");
        System.out.println("Senior in Action:");
        project.beWritten(senior);

    }
}
