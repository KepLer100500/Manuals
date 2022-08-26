package structural.facade;

public class BugTracker {
    private boolean activeSprint;

    public boolean isActiveSprint() {
        return activeSprint;
    }

    public void startSprint() {
        System.out.println("Sprint is starting.");
        activeSprint = true;
    }

    public void finishSprint() {
        System.out.println("Sprint is finished.");
        activeSprint = false;
    }
}
