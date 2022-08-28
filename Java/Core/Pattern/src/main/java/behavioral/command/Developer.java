package behavioral.command;

public class Developer {
    Command select;
    Command insert;
    Command update;
    Command delete;

    public Developer(Command select, Command insert, Command update, Command delete) {
        this.select = select;
        this.insert = insert;
        this.update = update;
        this.delete = delete;
    }

    public void selectCommand() {
        select.execute();
    }

    public void insertCommand() {
        insert.execute();
    }

    public void updateCommand() {
        update.execute();
    }

    public void deleteCommand() {
        delete.execute();
    }
}
