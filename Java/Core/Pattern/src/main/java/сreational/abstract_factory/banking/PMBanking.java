package сreational.abstract_factory.banking;

import сreational.abstract_factory.ProjectManager;

public class PMBanking implements ProjectManager {
    @Override
    public void manageProject() {
        System.out.println("PM manage banking system");
    }
}
