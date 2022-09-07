package behavioral.strategy;

public class Developer {
    Activity activity;

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void executeSomething() {
        activity.justDoIt();
    }
}
