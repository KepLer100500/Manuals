package сreational.builder;

/**
 * Builder (Строитель) - для создания различных объектов из одного набора данных
 */

public class Main {
    public static void main(String[] args) {
        Website website = null;
        Director director = new Director();
        director.setBuilder(new VisitCardWebsiteBuilder());
        website = director.buildWebsite();
        System.out.println(website);

        director.setBuilder(new EnterpriseWebsiteBuilder());
        website = director.buildWebsite();
        System.out.println(website);
    }
}
