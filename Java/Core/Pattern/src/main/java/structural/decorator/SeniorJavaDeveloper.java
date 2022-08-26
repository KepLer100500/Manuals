package structural.decorator;


public class SeniorJavaDeveloper extends JavaDeveloperDecorator{
    public SeniorJavaDeveloper(Developer developer) {
        super(developer);
    }

    private String makeCodeReview() {
        return "Make code review.\n";
    }

    @Override
    public String makeJob() {
        return developer.makeJob() + makeCodeReview();
    }
}
