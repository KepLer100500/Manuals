package behavioral.visitor;

public class Junior implements Developer {
    @Override
    public void create(ProjectClass projectClass) {
        System.out.println("Write bad code");
    }

    @Override
    public void create(Database database) {
        System.out.println("Drop database");
    }

    @Override
    public void create(Test test) {
        System.out.println("Make bad tests");
    }
}
