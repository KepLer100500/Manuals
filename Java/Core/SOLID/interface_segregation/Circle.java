package interface_segregation;


public class Circle implements CircleInterface {
    @Override
    public void drawCircle() {
        System.out.println("It's circle");
    }
}