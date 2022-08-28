package сreational.abstract_factory.website;

import сreational.abstract_factory.ProjectManager;

public class PMWebsite implements ProjectManager {
    @Override
    public void manageProject() {
        System.out.println("PM manage website project");
    }
}
