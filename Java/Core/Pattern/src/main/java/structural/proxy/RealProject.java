package structural.proxy;


public class RealProject implements Project{
    private final String url;

    public RealProject(String url) {
        this.url = url;
        load();
    }

    public void load() {
        System.out.println("Load RealProject: " + url + "...");
    }

    @Override
    public void run() {
        System.out.println("Run RealProject: " + url + "...");
    }
}
