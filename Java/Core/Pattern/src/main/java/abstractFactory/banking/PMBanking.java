package abstractFactory.banking;

import abstractFactory.ProjectManager;

public class PMBanking implements ProjectManager {
    @Override
    public void manageProject() {
        System.out.println("PM manage banking system");
    }
}
