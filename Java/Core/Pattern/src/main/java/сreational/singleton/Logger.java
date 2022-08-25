package сreational.singleton;

public class Logger {
    private static Logger logger;
    private static String logInfo = "This is log.\n";

    private Logger() {

    }

    public static synchronized Logger getLogger() {
        if(logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    public void addMessage(String message) {
        logInfo += message + "\n";
    }

    public void showLog() {
        System.out.println(logInfo);
    }

}