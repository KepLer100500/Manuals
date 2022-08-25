package сreational.abstractFactory.website;

import сreational.abstractFactory.Developer;
import сreational.abstractFactory.ProjectManager;
import сreational.abstractFactory.ProjectTeamFactory;
import сreational.abstractFactory.Tester;

public class WebsiteTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new PhpDeveloper();
    }

    @Override
    public Tester getTester() {
        return new ManualTester();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new PMWebsite();
    }
}
