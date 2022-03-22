package com.epam.rd.autotasks.figures;
import static java.lang.Math.abs;


class Quadrilateral extends Figure {
    Point a, b, c, d;
    private Triangle triangleA, triangleB, triangleC, triangleD;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;

        if (a == null || b == null || c == null || d == null || isDegenerate() || centroid() == null) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDegenerate() {
        triangleA = new Triangle(b, c, d);
        triangleB = new Triangle(c, d, a);
        triangleC = new Triangle(a, b, d);
        triangleD = new Triangle(a, b, c);
        return false;
    }

    public Point centroid() {
        Point Ga = triangleA.centroid();
        Point Gb = triangleB.centroid();
        Point Gc = triangleC.centroid();
        Point Gd = triangleD.centroid();
        return intersection(Ga, Gc, Gb, Gd);
    }

    private Point intersection(Point m, Point n, Point o, Point p) {
        // m, n - first line
        // o, p - second line
        double x1 = m.getX();
        double x2 = n.getX();
        double x3 = o.getX();
        double x4 = p.getX();

        double y1 = m.getY();
        double y2 = n.getY();
        double y3 = o.getY();
        double y4 = p.getY();

        double t = ((x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4)) / ((x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4));
        double u = ((x1 - x3) * (y1 - y2) - (y1 - y3) * (x1 - x2)) / ((x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4));

        if( (t >= 0 && t <= 1) && (u >= 0 && u <= 1) ) {
            return new Point(x1 + t * (x2 - x1), y1 + t * (y2 - y1));
        } else {
            return null; // have not intersection point
        }
    }

    public boolean isTheSame(Figure figure) {
        if (figure instanceof Quadrilateral && this.equals((Quadrilateral)figure)){
            return true;
        }
        return false;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quadrilateral quadrilateral = (Quadrilateral) o;

        Point[] pointsThis = {a, b, c, d};
        Point[] pointsOther = {quadrilateral.a, quadrilateral.b, quadrilateral.c, quadrilateral.d};

        if (compareAllPoints(pointsThis, pointsOther)) {
            return true;
        } else {
            pointsThis = reversePoints(pointsThis);
            return compareAllPoints(pointsThis, pointsOther);
        }
    }

    private Point[] reversePoints(Point[] pointsThis) {
        int j = 0;
        Point[] reversePointsThis = new Point[pointsThis.length];
        for (int i = pointsThis.length - 1; i >= 0; i--) {
            reversePointsThis[j] = pointsThis[i];
            j++;
        }
        return reversePointsThis;
    }

    private boolean compareAllPoints(Point[] pointsThis, Point[] pointsOther) {
        for (int i = 0; i < pointsThis.length; i++) {
            if (tryToEqualPoints(pointsThis, pointsOther)) {
                return true;
            } else {
                pointsThis = movePointsForward(pointsThis);
            }
        }
        return false;
    }

    private boolean tryToEqualPoints(Point[] pointsThis, Point[] pointsOther) {
        int equalsPoints = 0;
        for (int j = 0; j < pointsThis.length; j++) {
            if (pointsThis[j].equals(pointsOther[j])) {
                equalsPoints++;
            }
        }
        return equalsPoints == pointsThis.length;
    }

    private Point[] movePointsForward(Point[] pointsThis) {
        Point firstPointThis = pointsThis[0];
        for (int j = 1; j < pointsThis.length; j++) {
            pointsThis[j-1] = pointsThis[j];
        }
        pointsThis[pointsThis.length-1] = firstPointThis;
        return pointsThis;
    }

    @Override
    public int hashCode() {
        int result = a.hashCode();
        result = 31 * result + b.hashCode();
        result = 31 * result + c.hashCode();
        result = 31 * result + d.hashCode();
        return result;
    }
}
