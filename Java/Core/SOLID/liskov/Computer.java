package liskov;


public class Computer {
    String name;
    int memorySize;

    Computer(String name, int memorySize) {
        this.name = name;
        this.memorySize = memorySize;
    }

    public String getName() {
        return name;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public void setData(String name) {
        this.name = name;
    }
}