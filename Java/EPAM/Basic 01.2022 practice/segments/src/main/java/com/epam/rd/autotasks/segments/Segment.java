package com.epam.rd.autotasks.segments;

import java.util.StringJoiner;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;


class Segment {
    private final Point start;
    private final Point end;

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public Segment(Point start, Point end) {
        this.start = start;
        this.end = end;

        if(start.getX() == end.getX() && start.getY() == end.getY()) {
            throw new IllegalArgumentException();
        }
    }

    double length() {
        return sqrt(pow(end.getX() - start.getX(), 2) + pow(end.getY() - start.getY(), 2));
    }

    Point middle() {
        double x1 = start.getX();
        double y1 = start.getY();
        double x2 = end.getX();
        double y2 = end.getY();

        return new Point((x1 + x2) / 2, (y1 + y2) / 2);
    }

    Point intersection(Segment another) {
        double x1 = this.getStart().getX();
        double x2 = this.getEnd().getX();
        double x3 = another.getStart().getX();
        double x4 = another.getEnd().getX();

        double y1 = this.getStart().getY();
        double y2 = this.getEnd().getY();
        double y3 = another.getStart().getY();
        double y4 = another.getEnd().getY();

        double t = ((x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4)) / ((x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4));
        double u = ((x1 - x3) * (y1 - y2) - (y1 - y3) * (x1 - x2)) / ((x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4));

        if( (t >= 0 && t <= 1) && (u >= 0 && u <= 1) ) {
            return new Point(x1 + t * (x2 - x1), y1 + t * (y2 - y1));
        } else {
            return null;
        }
    }

}
