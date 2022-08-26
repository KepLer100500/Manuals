package structural.facade;

public class Workflow {
    Job job = new Job();
    BugTracker bugTracker = new BugTracker();
    Developer developer = new Developer();


    public void runProcess() {
        job.doJob();
        bugTracker.startSprint();
        developer.doJobBeforeDeadline(bugTracker);
        bugTracker.finishSprint();
        developer.doJobBeforeDeadline(bugTracker);
    }
}
