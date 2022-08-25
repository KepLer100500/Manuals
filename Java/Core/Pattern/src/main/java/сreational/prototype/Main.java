package сreational.prototype;

/**
 * Prototype (Прототип) - для создания копий заданного объекта
 */

public class Main {
    public static void main(String[] args) {
        Project master = new Project(1, "SuperProject", "HelloWorld");
        System.out.println(master);

        ProjectFactory factory = new ProjectFactory(master);
        Project newProject = factory.cloneProject();
        System.out.println(newProject);
    }
}
