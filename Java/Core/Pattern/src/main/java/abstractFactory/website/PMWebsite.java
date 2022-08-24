package abstractFactory.website;

import abstractFactory.ProjectManager;

public class PMWebsite implements ProjectManager {
    @Override
    public void manageProject() {
        System.out.println("PM manage website project");
    }
}
