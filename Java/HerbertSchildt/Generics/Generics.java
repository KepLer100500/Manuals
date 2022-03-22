class PointGeneric <T> {
    public T x, y;

    PointGeneric(T x, T y) {
        this.x = x;
        this.y = y;
    }

    T getX() {
        return x;
    }

    T getY() {
        return y;
    }

    Object[] getCoords() {
        return new Object[] {x, y}; // new T[] {x, y} <- error!
    }
}

class PointGenericExtended <T extends Number> { // .doubleValue() only in Numbers
    public T x, y;

    PointGenericExtended(T x, T y) {
        this.x = x;
        this.y = y;
    }

    double getMaxCoord() {
        if (x.doubleValue() > y.doubleValue()) {
            return x.doubleValue();
        }
        return y.doubleValue();
    }

    boolean equalsPoint(PointGenericExtended <?> anotherPoint) { // wildcard - for mix different types
        return (this.x.doubleValue() == anotherPoint.x.doubleValue() &&
                this.y.doubleValue() == anotherPoint.y.doubleValue());
    }

}

class InArrayGeneric {
    public static <T> boolean elementPresentInArray(T val, T[] arr) {
        for (T element: arr) {
            if (element == val) {
                return true;
            }
        }
        return false;
    }
}

public class Generics {
    public static void main(String[] args) {
        PointGeneric<Integer> point1 = new PointGeneric<>(1, 2);
        System.out.println(point1.getX() + " " + point1.getY());

        PointGeneric<Double> point2 = new PointGeneric<>(1.0, 2.0);
        System.out.println(point2.getX() + " " + point2.getY());

        PointGeneric<Short> point3 = new PointGeneric<>((short) 3, (short) 8);
        for (Object obj : point3.getCoords()) {
            System.out.print((Short) obj + " ");
        }
        System.out.println();

        PointGenericExtended<Integer> point4 = new PointGenericExtended<>(10, 20);
        System.out.println("Max coordinate: " + point4.getMaxCoord());
        PointGenericExtended<Double> point5 = new PointGenericExtended<>(10.0, 20.0);
        System.out.println("Point equals? : " + point4.equalsPoint(point5));

        Integer genericElement1 = 5;
        Integer[] genericArray1 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(InArrayGeneric.elementPresentInArray(genericElement1, genericArray1));

        Double genericElement2 = 50.0;
        Double[] genericArray2 = {1.0, 2.0, 3.0};

        System.out.println(InArrayGeneric.elementPresentInArray(genericElement2, genericArray2));
    }

}

