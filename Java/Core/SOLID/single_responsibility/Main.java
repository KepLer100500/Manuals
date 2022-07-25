package single_responsibility;


public class Main {
    public static void main(String[] args) {
        System.out.println("Run. Single Responsibility.");
        Computer comp = new Computer("IBM", 5000);
        SaveComputer saver = new SaveComputer();
        saver.saveToFile("File.txt", comp);
    }
}