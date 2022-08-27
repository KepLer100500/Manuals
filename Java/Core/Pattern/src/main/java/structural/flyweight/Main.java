package structural.flyweight;

import java.util.ArrayList;
import java.util.List;

/**
 * Flyweight (Приспособленец) - для поддержки множества мелких объектов
 */

public class Main {
    public static void main(String[] args) {
        DeveloperFactory developerFactory = new DeveloperFactory();
        List<Developer> developers = new ArrayList<>();

        developers.add(developerFactory.getDeveloperBySpeciality("java"));
        developers.add(developerFactory.getDeveloperBySpeciality("java"));
        developers.add(developerFactory.getDeveloperBySpeciality("cpp"));
        developers.add(developerFactory.getDeveloperBySpeciality("java"));
        developers.add(developerFactory.getDeveloperBySpeciality("java"));
        developers.add(developerFactory.getDeveloperBySpeciality("cpp"));

        for (Developer developer : developers) {
            developer.writeCode();
        }
    }
}
