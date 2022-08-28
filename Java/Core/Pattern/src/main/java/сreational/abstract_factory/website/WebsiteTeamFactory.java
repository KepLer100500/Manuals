package сreational.abstract_factory.website;

import сreational.abstract_factory.Developer;
import сreational.abstract_factory.ProjectManager;
import сreational.abstract_factory.ProjectTeamFactory;
import сreational.abstract_factory.Tester;

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
