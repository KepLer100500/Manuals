package сreational.abstract_factory;

public interface ProjectTeamFactory {
    public Developer getDeveloper();
    public Tester getTester();
    public ProjectManager getProjectManager();
}
