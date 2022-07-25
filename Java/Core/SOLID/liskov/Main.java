package liskov;


public class Main {
    public static void main(String[] args) {
        System.out.println("Run. Liskov.");

        Computer comp1 = new Computer("computer1", 5000);
        System.out.println(comp1.getName() + " " + comp1.getMemorySize());
        comp1.setData("IBM"); // this method set only name
        System.out.println(comp1.getName() + " " + comp1.getMemorySize());

        Computer comp2 = new HPComputer("HP", 8000);
        System.out.println(comp2.getName() + " " + comp2.getMemorySize());
        comp2.setData("HP"); // this method set name and memorySize!!!
        System.out.println(comp2.getName() + " " + comp2.getMemorySize() + " <- other behavior");

    }
}