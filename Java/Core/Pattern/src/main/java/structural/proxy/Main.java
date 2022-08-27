package structural.proxy;

/**
 * Proxy (Прокси) - для замещения одного объекта другим
 * и для контроля доступа к нему
 */

public class Main {
    public static void main(String[] args) {
        Project project = new ProxyProject("https://github.com/KepLer100500/Phonogram");
        project.run();
    }
}
