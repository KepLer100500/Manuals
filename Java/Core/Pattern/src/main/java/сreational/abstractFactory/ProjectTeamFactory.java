package сreational.abstractFactory;

public interface ProjectTeamFactory {
    public Developer getDeveloper();
    public Tester getTester();
    public ProjectManager getProjectManager();
}
