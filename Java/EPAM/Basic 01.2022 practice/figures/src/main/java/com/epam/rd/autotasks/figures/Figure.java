package com.epam.rd.autotasks.figures;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

abstract class Figure{

    public abstract double area();

    public abstract String pointsToString();

    public String toString() {
        return this.getClass().getSimpleName() + "[" + pointsToString() + "]";
    }

    public abstract Point leftmostPoint();

    public double lengthBetweenTwoPoints(Point m, Point n) {
        return sqrt(pow(n.getX() - m.getX(), 2) + pow(n.getY() - m.getY(), 2));
    }

    public Point leftmostPointTriangleQuadrilateral(Point ... points) {
        Point leftMost = points[0];
        for (Point point: points) {
            if (point.getX() < leftMost.getX() || (point.getX() == leftMost.getX() && point.getY() < leftMost.getY())) {
                leftMost = point;
            }
        }
        return leftMost;
    }
}
