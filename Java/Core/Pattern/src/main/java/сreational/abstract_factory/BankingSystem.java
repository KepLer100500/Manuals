package сreational.abstract_factory;

import сreational.abstract_factory.banking.BankingTeamFactory;

/**
 * Абстрактная фабрика - для создания множеств взаимосвязанных объектов
 */

public class BankingSystem {
    public static void main(String[] args) {
        BankingTeamFactory bankingTeamFactory = new BankingTeamFactory();
        Developer developer = bankingTeamFactory.getDeveloper();
        Tester tester = bankingTeamFactory.getTester();
        ProjectManager projectManager = bankingTeamFactory.getProjectManager();

        System.out.println("Start banking project");
        developer.writeCode();
        tester.testCode();
        projectManager.manageProject();
    }
}
