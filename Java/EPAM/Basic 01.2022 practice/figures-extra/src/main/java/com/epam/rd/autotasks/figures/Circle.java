package com.epam.rd.autotasks.figures;
import static java.lang.Math.PI;


class Circle extends Figure {
    Point center;
    double radius;

    Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;

        if (center == null || radius < 0 || isDegenerate()) {
            throw new IllegalArgumentException();
        }
    }

    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    private boolean isDegenerate() {
        return area() == 0;
    }

    public Point centroid() {
        return center;
    }

    public boolean isTheSame(Figure figure) {
        if (figure instanceof Circle && this.equals((Circle) figure)){
            return true;
        }
        return false;
    }

    @Override
    public double area() {
        return PI * radius * radius;
    }

    @Override
    public String pointsToString(){
        return center + "";
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[" + pointsToString() + radius + "]";
    }

    @Override
    public Point leftmostPoint() {
        return new Point(center.getX() - radius, center.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circle circle = (Circle) o;

        if (!deltaCompare(this.getRadius(), circle.getRadius())) return false;
        return center.equals(circle.center);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = center.hashCode();
        temp = Double.doubleToLongBits(radius);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
