public class Classes {
    static int staticValue1;
    static int staticValue2;

    static int staticSum() {
        return staticValue1 + staticValue2;
    }

    static {
        System.out.println("This message printed before class object will be created. Static block.");
    }

    public static void main(String[] args) {
        QueueCleanable ochered1 = new QueueCleanable(3);
        System.out.println(ochered1.get());
        ochered1.put('a');
        ochered1.put('b');
        ochered1.put('c');
        ochered1.put('d');
        System.out.println(ochered1.get());
        System.out.println(ochered1.get());

        FailSafeArray fsa = new FailSafeArray(3);
        System.out.println("Array size: " + fsa.length);
        System.out.println(fsa.getValue(2));
        System.out.println(fsa.getValue(5));
        fsa.setValue(0, 111);
        fsa.setValue(1, 222);
        fsa.setValue(2, 333);
        System.out.println(fsa.getValue(2));

        OverloadConstructor oc1 = new OverloadConstructor(1);
        OverloadConstructor oc2 = new OverloadConstructor(1, 2);
        OverloadConstructor oc3 = new OverloadConstructor(1, 2, 3);

        int[] n = {1, 2, 3, 4, 5};
        Outer ou = new Outer(n);
        ou.Analyze();

        Rectangle rect1 = new Rectangle(10, 20, "red");
        System.out.println("Area rectangle: " + rect1.area());
        System.out.println("Color rectangle: " + rect1.color);
        Rectangle rect2 = new Rectangle(10, "green");
        System.out.println("Area rectangle: " + rect2.area());
        System.out.println("Color rectangle: " + rect2.color);
        Rectangle rect3 = new Rectangle("blue");
        System.out.println("Area rectangle: " + rect3.area());
        System.out.println("Color rectangle: " + rect3.color);
        VisibledRectangle rect4 = new VisibledRectangle(20, 40, "yellow", true);
        System.out.println("Area rectangle: " + rect4.area());
        System.out.println("Color rectangle: " + rect4.color);
        System.out.println("Visible rectangle: " + rect4.visible);

        B xObj = new B(1, 2);
        xObj.show();

        OrderRunConstructorC orderRunConstructorCCC = new OrderRunConstructorC();
        OrderRunConstructorA orderRunConstructorAAA; 
        orderRunConstructorAAA = orderRunConstructorCCC;
        System.out.println(orderRunConstructorAAA.a);
        // System.out.println(orderRunConstructorAAA.c); // <- error, this class is A! Not C! 

        TwoDShape shape1 = new TwoDShape(10, 20);
        System.out.println(shape1.width + " / " + shape1.height);
        TwoDShape shape2 = new TwoDShape(shape1);
        System.out.println(shape2.width + " / " + shape2.height);
        TwoDRectangle rectangle1 = new TwoDRectangle(30, 50, "Solid");
        System.out.println(rectangle1.width + " / " + rectangle1.height + " / " + rectangle1.fillType);
        TwoDRectangle rectangle2 = new TwoDRectangle(shape2, "Dashed");
        System.out.println(rectangle2.width + " / " + rectangle2.height);

        RedefinitionMethodSub redefinitionMethod = new RedefinitionMethodSub();
        redefinitionMethod.show();

        DynamicDispatcherMethodSuper dispatcherSuper = new DynamicDispatcherMethodSuper();
        DynamicDispatcherMethodSub1 dispatcherSub1 = new DynamicDispatcherMethodSub1();
        DynamicDispatcherMethodSub2 dispatcherSub2 = new DynamicDispatcherMethodSub2();
        DynamicDispatcherMethodSuper dispatcherReference;
        dispatcherReference = dispatcherSuper;
        dispatcherReference.show();
        dispatcherReference = dispatcherSub1;
        dispatcherReference.show();
        dispatcherReference = dispatcherSub2;
        dispatcherReference.show();

        AreaShape arCircle = new AreaCircle(5, "circle");
        AreaShape arRectangle = new AreaRectangle(5, 10, "rectangle");
        AreaShape arTriangle = new AreaTriangle(5, 6, 7, "triangle");
        // AreaShape arFigure = new AreaShape("figure"); // abstract class can't have copy
        arCircle.calculateArea();
        arRectangle.calculateArea();
        arTriangle.calculateArea();

        System.out.println(FinalClassC.STATIC_CONSTANTA);
        FinalClassC FCC = new FinalClassC();
        System.out.println(FCC.CONSTANTA);
        // FCC.CONSTANTA = 3; // Error! Can't put data into final variable!
        // FinalClassC.STATIC_CONSTANTA = 7; // Error! Can't put data into final variable!
    }

}

class QueueCleanable {
    char[] q;
    int pos;

    QueueCleanable(int size){
        q = new char[size];
        pos = 0;
    }

    void put(char ch) {
        if(pos == q.length) {
            System.out.println("Trying put: " + ch + ", but queue is full!");
            return;
        }
        q[pos++] = ch;
    }

    char get() {
        if(pos == 0) {
            System.out.println("Queue is empty!");
            return '0';
        }
        char first_element = q[0];
        for(int i=1; i<q.length; i++) {
            q[i-1] = q[i];
        }
        pos--;
        return first_element;
    }
}

class FailSafeArray {
    private int[] a;
    public int length;

    FailSafeArray(int length) {
        this.length = length;
        a = new int[length];
    }

    public int setValue(int index, int value) {
        if(checkIndex(index)) {
            a[index] = value;
            return 0;
        }
        return -1;
    }

    public int getValue(int index) {
        if(checkIndex(index)) {
            return a[index];
        }
        return -1;
    }

    private boolean checkIndex(int index) {
        if(index >= 0 && index < length) {
            return true;
        }
        return false;
    }
}

class OverloadConstructor {
    OverloadConstructor(int a) {
        System.out.println(a);
    }

    OverloadConstructor(int a, int b) {
        System.out.println(a + " | " + b);
    }

    OverloadConstructor(int a, int b, int c) {
        System.out.println(a + " | " + b + " | " + c);
    }
}

class Outer {
    int[] numbers;

    Outer(int[] n) {
        numbers = n;
    }

    void Analyze() {
        Inner obj = new Inner();
        System.out.println("Min value is: " + obj.min());
        System.out.println("Max value is: " + obj.max());
        System.out.println("Avg value is: " + obj.avg());
    }

    class Inner {
        int max() {
            int maxN = numbers[0];
            for(int i=1; i<numbers.length; i++) {
                if(numbers[i] > maxN) {
                    maxN = numbers[i];
                }
            }
            return maxN;
        }

        int min() {
            int minN = numbers[0];
            for(int i=1; i<numbers.length; i++) {
                if(numbers[i] < minN) {
                    minN = numbers[i];
                }
            }
            return minN;
        }

        int avg() {
            int avgN = 0;
            for(int number: numbers) {
                avgN += number;
            }
            return avgN / numbers.length;
        }

    }
}

class Shape {
    int height;
    int width;

    Shape() {
        height = width = 0;
    }

    Shape(int oneSide) {
        height = width = oneSide;
    }

    Shape(int height, int width) {
        this.height = height;
        this.width = width;
    }
}

class Rectangle extends Shape {
    String color;

    Rectangle(String color) {
        super(); // Call constructor superclass
        this.color = color;
    }

    Rectangle(int oneSide, String color) {
        super(oneSide); // Call constructor superclass
        this.color = color;
    }

    Rectangle(int height, int width, String color) {
        super(height, width); // Call constructor superclass
        this.color = color;
    }

    int area() {
        return height * width;
    }
}

class VisibledRectangle extends Rectangle {
    boolean visible;

    VisibledRectangle(int height, int width, String color, boolean visible) {
        super(height, width, color);
        this.visible = visible;
    }
}

class A {
    int x;
}

class B extends A {
    int x; // hiding X in subclass

    B(int a, int b) {
        super.x = a;
        x = b;
    }

    void show() {
        System.out.println("X in superclass: " + super.x);
        System.out.println("X in subclass:   " + x);
    }
}


class OrderRunConstructorA {
    int a = 1;
    OrderRunConstructorA() {
        System.out.println("Constructor A");
    }
}

class OrderRunConstructorB extends OrderRunConstructorA {
    int b = 2;
    OrderRunConstructorB() {
        System.out.println("Constructor B");
    }
}

class OrderRunConstructorC extends OrderRunConstructorB {
    int c = 3;
    OrderRunConstructorC() {
        System.out.println("Constructor C");
    }
}

class TwoDShape {
    int width;
    int height;

    TwoDShape(int width, int height) {
        this.width = width;
        this.height = height;
    }

    TwoDShape(TwoDShape shape) {
        width = shape.width;
        height = shape.height;
    }
}

class TwoDRectangle extends TwoDShape {
    String fillType;

    TwoDRectangle(int width, int height, String fillType) {
        super(width, height);
        this.fillType = fillType;
    }

    TwoDRectangle(TwoDShape shape, String fillType) {
        super(shape);
        this.fillType = fillType;
    }
}

class RedefinitionMethodSuper {
    void show() {
        System.out.println("Show super class");
    } 
}

class RedefinitionMethodSub extends RedefinitionMethodSuper {
    void show() {
        super.show();
        System.out.println("Show sub class");
    }
}

class DynamicDispatcherMethodSuper {
    void show() {
        System.out.println("Super class");
    }
}

class DynamicDispatcherMethodSub1 extends DynamicDispatcherMethodSuper {
    void show() {
        System.out.println("Sub 1 class");
    }
}

class DynamicDispatcherMethodSub2 extends DynamicDispatcherMethodSuper {
    void show() {
        System.out.println("Sub 2 class");
    }
}


abstract class AreaShape {
    private String nameShape;

    String getNameShape() {
        return nameShape;
    }

    AreaShape(String nameShape) {
        this.nameShape = nameShape;
    }

    abstract void calculateArea();
}

class AreaCircle extends AreaShape {
    private int radius;

    AreaCircle(int radius, String nameShape) {
        super(nameShape);
        this.radius = radius;
    }

    void calculateArea() {
        double area = Math.PI * Math.pow(radius, 2);
        System.out.println("Area " + super.getNameShape() + ": " + area);
    }
}

class AreaRectangle extends AreaShape {
    private int width;
    private int height;

    AreaRectangle(int width, int height, String nameShape) {
        super(nameShape);
        this.width = width;
        this.height = height;
    }

    void calculateArea() {
        double area = width * height;
        System.out.println("Area " + super.getNameShape() + ": " + area);
    }
}

class AreaTriangle extends AreaShape {
    private int a;
    private int b;
    private int c;

    AreaTriangle(int a, int b, int c, String nameShape) {
        super(nameShape);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    void calculateArea() {
        double p = (a + b + c) / 2; // half perimeter
        double area = Math.sqrt(p * (p - a) * (p - b) * (p - c)); // formula Geron'a
        System.out.println("Area " + super.getNameShape() + ": " + area);
    }
}


final class FinalClassA {

}

// class NotFinalClass extends FinalClass {} // Error! Can't inherit final classes!

class FinalClassB {
    final void show() {
        System.out.println("It's final method!");
    }
}

class FinalClassC extends FinalClassB {
    final int CONSTANTA = 5;
    final static int STATIC_CONSTANTA = 10;

    /* 
    void show() { // Error! Can't inherit final method!
        System.out.println("It's not final method!");
    }
    */
}