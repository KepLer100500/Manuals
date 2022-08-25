package сreational.singleton;

/**
 * Singleton (Одиночка) - для создания единственного экземпляра класса
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(Logger.getLogger());
        System.out.println(Logger.getLogger());
        System.out.println(Logger.getLogger());

        Logger.getLogger().addMessage("One");
        Logger.getLogger().addMessage("Two");
        Logger.getLogger().addMessage("Three");

        Logger.getLogger().showLog();
    }
}
