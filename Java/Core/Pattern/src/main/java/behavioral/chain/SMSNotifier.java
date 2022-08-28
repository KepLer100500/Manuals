package behavioral.chain;

public class SMSNotifier extends Notifier{
    public SMSNotifier(int priority) {
        super(priority);
    }

    @Override
    protected void write(String message) {
        System.out.println("Floor in the fire. " + message);
    }
}
