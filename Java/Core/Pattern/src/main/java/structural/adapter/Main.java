package structural.adapter;

/**
 * Adapter (Адаптер) - для совместной работы классов, интерфейсы которых несовместимы
 */

public class Main {
    public static void main(String[] args) {
        Database database = new AdapterJavaAppToDatabase();
        database.select();
        database.insert();
        database.update();
        database.delete();
    }
}
