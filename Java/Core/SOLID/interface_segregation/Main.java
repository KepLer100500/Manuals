package interface_segregation;


public class Main {
    public static void main(String[] args) {
        System.out.println("Run. Interface segregatiuon.");

        Line line = new Line();
        line.drawLine();

        Circle circle = new Circle();
        circle.drawCircle();
    }
}