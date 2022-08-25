package сreational.abstractFactory.banking;

import сreational.abstractFactory.ProjectManager;

public class PMBanking implements ProjectManager {
    @Override
    public void manageProject() {
        System.out.println("PM manage banking system");
    }
}
