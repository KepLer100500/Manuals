package behavioral.chain;


public abstract class Notifier {
    public int priority;
    public Notifier nextNotifier;

    public Notifier(int priority) {
        this.priority = priority;
    }

    public void setNextNotifier(Notifier nextNotifier) {
        this.nextNotifier = nextNotifier;
    }

    public void notifierManager(String message, int level) {
        if(level >= priority) {
            write(message);
        }
        if(nextNotifier != null) {
            nextNotifier.notifierManager(message, level);
        }
    }

    protected abstract void write(String message);
}
