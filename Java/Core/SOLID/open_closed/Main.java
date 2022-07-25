package open_closed;


public class Main {
    public static void main(String[] args) {
        System.out.println("Run. Open Closed.");
        Computer comp = new Computer("IBM", 5000);
        SaveInterface saver;
        saver = new SaveComputerToFile();
        saver.save("File.txt", comp);
        saver = new SaveComputerToDB();
        saver.save("postgres://", comp);
    }
}