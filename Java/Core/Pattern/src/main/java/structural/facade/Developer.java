package structural.facade;

public class Developer {
    public void doJobBeforeDeadline(BugTracker bugTracker) {
        if(bugTracker.isActiveSprint()) {
            System.out.println("Developer writes code.");
        } else {
            System.out.println("Developer is chilling.");
        }
    }
}
