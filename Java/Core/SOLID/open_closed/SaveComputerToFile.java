package open_closed;


public class SaveComputerToFile implements SaveInterface {
    public void save(String path, Computer comp) {
        System.out.println("Saved to file " + path + ", " + comp.getName());
    }
}
