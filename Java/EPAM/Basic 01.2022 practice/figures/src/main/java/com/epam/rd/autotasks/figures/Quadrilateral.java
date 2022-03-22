package com.epam.rd.autotasks.figures;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

class Quadrilateral extends Figure {
    Point a, b, c, d;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public double area() {
        // Formula Gauss for area calc
        return 0.5 * abs(a.getX() * b.getY() + b.getX() * c.getY() + c.getX() * d.getY() + d.getX() * a.getY() -
                b.getX() * a.getY() - c.getX() * b.getY() - d.getX() * c.getY() - a.getX() * d.getY());
    }

    @Override
    public String pointsToString(){
        return a + "" + b + "" + c + "" + d;
    }

    @Override
    public Point leftmostPoint() {
        return leftmostPointTriangleQuadrilateral(a, b, c, d);
    }
}
