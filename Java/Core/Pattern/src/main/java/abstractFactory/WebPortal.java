package abstractFactory;

import abstractFactory.website.WebsiteTeamFactory;

/**
 * Абстрактная фабрика - для создания множеств взаимосвязанных объектов
 */

public class WebPortal {
    public static void main(String[] args) {
        WebsiteTeamFactory websiteTeamFactory = new WebsiteTeamFactory();
        Developer developer = websiteTeamFactory.getDeveloper();
        Tester tester = websiteTeamFactory.getTester();
        ProjectManager projectManager = websiteTeamFactory.getProjectManager();

        System.out.println("Start Web Portal project");
        developer.writeCode();
        tester.testCode();
        projectManager.manageProject();
    }
}
