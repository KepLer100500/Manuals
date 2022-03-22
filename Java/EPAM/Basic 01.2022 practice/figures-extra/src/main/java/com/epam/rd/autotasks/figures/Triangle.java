package com.epam.rd.autotasks.figures;
import static java.lang.Math.sqrt;


class Triangle extends Figure {
    Point a, b, c;
    double ab, bc, ca;

    Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;

        if (a == null || b == null || c == null || isDegenerate()) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDegenerate() {
        return deltaCompare(area(), 0);
    }

    public Point centroid() {
        double x1 = middleBetweenTwoPoints(a, b).getX();
        double x2 = middleBetweenTwoPoints(b, c).getX();
        double x3 = middleBetweenTwoPoints(c, a).getX();

        double y1 = middleBetweenTwoPoints(a, b).getY();
        double y2 = middleBetweenTwoPoints(b, c).getY();
        double y3 = middleBetweenTwoPoints(c, a).getY();

        return new Point(1 / 3.0 * (x1 + x2 + x3),1 / 3.0 * (y1 + y2 + y3));
    }

    public boolean isTheSame(Figure figure) {
        if (figure instanceof Triangle && this.equals((Triangle)figure)){
            return true;
        }
        return false;
    }

    @Override
    public double area() {
        ab = lengthBetweenTwoPoints(a, b);
        bc = lengthBetweenTwoPoints(b, c);
        ca = lengthBetweenTwoPoints(c, a);
        double s = (ab + bc + ca) / 2; // semiperimeter
        //System.out.println("TRIANGLE: " + a + " / " + b + " / " + c + " AREA: " + sqrt(s * (s - ab) * (s - bc) * (s - ca)));
        return sqrt(s * (s - ab) * (s - bc) * (s - ca));
    }

    @Override
    public String pointsToString(){
        return a + "" + b + "" + c;
    }

    @Override
    public Point leftmostPoint() {
        return leftmostPointTriangleQuadrilateral(a, b, c);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (!a.equals(triangle.a)) return false;
        if (!b.equals(triangle.b)) return false;
        if (!c.equals(triangle.c)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = a.hashCode();
        result = 31 * result + b.hashCode();
        result = 31 * result + c.hashCode();
        return result;
    }
}
