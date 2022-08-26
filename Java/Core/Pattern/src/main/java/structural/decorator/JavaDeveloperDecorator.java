package structural.decorator;


public class JavaDeveloperDecorator implements Developer{
    Developer developer;

    public JavaDeveloperDecorator(Developer developer) {
        this.developer = developer;
    }

    @Override
    public String makeJob() {
        return developer.makeJob();
    }
}
