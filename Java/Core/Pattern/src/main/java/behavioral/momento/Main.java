package behavioral.momento;

/**
 * Снимок — это поведенческий паттерн проектирования, который позволяет сохранять и восстанавливать
 * прошлые состояния объектов, не раскрывая подробностей их реализации.
 */

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Project project = new Project();
        GitHub gitHub = new GitHub();
        project.setVersionAndDate("1.0");
        System.out.println(project);

        Thread.sleep(1000);
        gitHub.setSave(project.save());
        project.setVersionAndDate("1.1");
        System.out.println(project);

        project.load(gitHub.getSave());
        System.out.println(project);
    }
}
