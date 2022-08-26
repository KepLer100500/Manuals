package structural.decorator;

public class TeamLeadJavaDeveloper extends JavaDeveloperDecorator{
    public TeamLeadJavaDeveloper(Developer developer) {
        super(developer);
    }

    private String makeReport() {
        return "Make report.\n";
    }

    @Override
    public String makeJob() {
        return developer.makeJob() + makeReport();
    }
}
