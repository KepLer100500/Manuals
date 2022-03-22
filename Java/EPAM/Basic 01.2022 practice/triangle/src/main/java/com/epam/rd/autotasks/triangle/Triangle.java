package com.epam.rd.autotasks.triangle;

import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;


class Triangle {
    Point a, b, c;
    double ab, bc, ca;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;

        ab = lengthBetweenTwoPoints(a, b);
        bc = lengthBetweenTwoPoints(b, c);
        ca = lengthBetweenTwoPoints(c, a);

        if(ab + bc <= ca || ab + ca <= bc || bc + ca <= ab) {
            throw new IllegalArgumentException();
        }
    }

    public double lengthBetweenTwoPoints(Point m, Point n) {
        return sqrt(pow(n.getX() - m.getX(), 2) + pow(n.getY() - m.getY(), 2));
    }

    public double area() {
        double s = (ab + bc + ca) / 2; // semiperimeter
        return sqrt(s * (s - ab) * (s - bc) * (s - ca));
    }

    public Point middleBetweenTwoPoints(Point m, Point n) {
        double x1 = m.getX();
        double y1 = m.getY();
        double x2 = n.getX();
        double y2 = n.getY();

        return new Point((x1 + x2) / 2, (y1 + y2) / 2);
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
}
