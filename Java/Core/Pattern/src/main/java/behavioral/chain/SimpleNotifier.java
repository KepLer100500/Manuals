package behavioral.chain;

public class SimpleNotifier extends Notifier{
    public SimpleNotifier(int priority) {
        super(priority);
    }

    @Override
    protected void write(String message) {
        System.out.println("That's ok. " + message);
    }
}
