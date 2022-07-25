package interface_segregation;


public class Line implements LineInterface {
    @Override
    public void drawLine() {
        System.out.println("It's line");
    }
}