package сreational.abstract_factory.banking;

import сreational.abstract_factory.Developer;
import сreational.abstract_factory.ProjectManager;
import сreational.abstract_factory.ProjectTeamFactory;
import сreational.abstract_factory.Tester;

public class BankingTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new JavaDeveloper();
    }

    @Override
    public Tester getTester() {
        return new QATester();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new PMBanking();
    }
}
