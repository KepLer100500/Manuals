package com.epam.rd.autotasks.intersection;


public class Line {
    private final int k;
    private final int b;

    public Line(int k, int b) {
        this.k = k;
        this.b = b;
    }

    public Point intersection(Line other) {
        if((this.k == other.k && this.b == other.b) || this.k - other.k == 0) {
            return null;
        }
        int intersectionX = (other.b - this.b) / (this.k - other.k);
        int intersectionY = this.k * intersectionX + this.b;
        return new Point(intersectionX, intersectionY);
    }

}
