package behavioral.visitor;

public class Senior implements Developer {
    @Override
    public void create(ProjectClass projectClass) {
        System.out.println("Write clean code");
    }

    @Override
    public void create(Database database) {
        System.out.println("Fix database");
    }

    @Override
    public void create(Test test) {
        System.out.println("Make good tests");
    }
}
