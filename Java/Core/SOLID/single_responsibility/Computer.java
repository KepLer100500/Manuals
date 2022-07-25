package single_responsibility;


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
}