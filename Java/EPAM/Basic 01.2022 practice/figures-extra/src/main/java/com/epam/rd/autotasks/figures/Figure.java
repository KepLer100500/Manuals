package com.epam.rd.autotasks.figures;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;


abstract class Figure {
    public static final double delta = 0.0001;

    public abstract Point centroid();

    public abstract boolean isTheSame(Figure figure);

    public abstract double area();

    public abstract Point leftmostPoint();

    public abstract String pointsToString();

    public boolean deltaCompare(double value1, double value2) {
        return Math.abs(value1 - value2) < delta;
    }

    public String toString() {
        return this.getClass().getSimpleName() + "[" + pointsToString() + "]";
    }

    public Point middleBetweenTwoPoints(Point m, Point n) {
        return new Point((m.getX() + n.getX()) / 2, (m.getY() + n.getY()) / 2);
    }

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
