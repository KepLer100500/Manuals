package single_responsibility;


public class SaveComputer {
    public void saveToFile(String path, Computer comp) {
        System.out.println("Saved to file " + path + ", " + comp.getName());
    }

}