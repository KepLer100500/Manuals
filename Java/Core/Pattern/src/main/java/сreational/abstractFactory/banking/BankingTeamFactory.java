package сreational.abstractFactory.banking;

import сreational.abstractFactory.Developer;
import сreational.abstractFactory.ProjectManager;
import сreational.abstractFactory.ProjectTeamFactory;
import сreational.abstractFactory.Tester;

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
