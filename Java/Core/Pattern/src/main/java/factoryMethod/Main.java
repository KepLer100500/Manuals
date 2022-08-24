package factoryMethod;

public class Main {
    private static DeveloperFactory createDeveloperBySpeciality(String speciality) {
        switch(speciality) {
            case "java" : return new JavaDeveloperFactory();
            case "cpp" : return new CppDeveloperFactory();
        }
        throw new RuntimeException(speciality + " is not support");
    }

    /**
     * Фабричный метод - для делегирования создания экземпляров, другому классу
     */

    public static void main(String[] args) {
        DeveloperFactory developerFactory = createDeveloperBySpeciality("java");
        Developer developer = developerFactory.createDeveloper();
        developer.writeCode();
    }
}
