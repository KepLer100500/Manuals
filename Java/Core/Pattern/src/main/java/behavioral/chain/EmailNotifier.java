package behavioral.chain;

public class EmailNotifier extends Notifier{
    public EmailNotifier(int priority) {
        super(priority);
    }

    @Override
    protected void write(String message) {
        System.out.println("Something's wrong. " + message);
    }
}
