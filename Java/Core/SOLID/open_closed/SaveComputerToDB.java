package open_closed;


public class SaveComputerToDB implements SaveInterface {
    public void save(String path, Computer comp) {
        System.out.println("Saved to database " + path + ", " + comp.getName());
    }
}
