package com.epam.rd.autotasks.figures;
import static java.lang.Math.sqrt;

class Triangle extends Figure {
    Point a, b, c;
    double ab, bc, ca;

    Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
        ab = lengthBetweenTwoPoints(a, b);
        bc = lengthBetweenTwoPoints(b, c);
        ca = lengthBetweenTwoPoints(c, a);
    }

    @Override
    public double area() {
        double s = (ab + bc + ca) / 2; // semiperimeter
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
}
