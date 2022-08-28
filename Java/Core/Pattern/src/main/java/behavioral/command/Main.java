package behavioral.command;

/**
 * Command (Команда) - превращает запросы в объекты, позволяя передавать их как
 * аргументы при вызове методов, ставить запросы в очередь, логировать их,
 * а также поддерживать отмену операций.
 */

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        Developer developer = new Developer(
                new SelectCommand(database),
                new InsertCommand(database),
                new UpdateCommand(database),
                new DeleteCommand(database)
        );

        developer.selectCommand();
        developer.insertCommand();
        developer.updateCommand();
        developer.deleteCommand();
    }
}
