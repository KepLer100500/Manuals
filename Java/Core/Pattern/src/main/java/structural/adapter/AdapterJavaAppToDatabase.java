package structural.adapter;

public class AdapterJavaAppToDatabase extends JavaApp implements Database{
    @Override
    public void select() {
        loadObject();
    }

    @Override
    public void insert() {
        createObject();
    }

    @Override
    public void update() {
        updateObject();
    }

    @Override
    public void delete() {
        removeObject();
    }
}
