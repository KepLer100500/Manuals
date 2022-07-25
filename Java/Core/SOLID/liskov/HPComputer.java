package liskov;


public class HPComputer extends Computer {

    HPComputer(String name, int memorySize) {
        super(name, memorySize);
    }

    public void setData(String name) {
        this.name = name;
        this.memorySize = 1024; // Violation principle!!!
    }
}