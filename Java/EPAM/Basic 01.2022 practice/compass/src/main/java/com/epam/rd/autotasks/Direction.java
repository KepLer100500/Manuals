package com.epam.rd.autotasks;

import java.util.Optional;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private int degrees;

    public static int checkDegrees(int degrees) {
        if(degrees >= 360 ) {
            degrees %= 360;
        }
        if(degrees < 0) {
            degrees += 360;
        }
        return degrees;
    }

    public static Direction ofDegrees(int degrees) {
        degrees = checkDegrees(degrees);

        for (Direction direction : Direction.values()) {
            if (direction.degrees == degrees) {
                return direction;
            }
        }
        return null;
    }

    public static Direction closestToDegrees(int degrees) {
        degrees = checkDegrees(degrees);

        Direction closestDirection = Direction.values()[0];
        int closedDegrees = Math.abs(closestDirection.degrees - degrees);
        int currentDifference;
        for (Direction direction : Direction.values()) {
            currentDifference = Math.abs(direction.degrees - degrees);
            if (currentDifference < closedDegrees) {
                closedDegrees = currentDifference;
                closestDirection = direction;
            }
        }
        return closestDirection;
    }

    public Direction opposite() {
        if (this.degrees > 180) {
            return Direction.ofDegrees(this.degrees - 180);
        }
        return Direction.ofDegrees(this.degrees + 180);
    }

    public int differenceDegreesTo(Direction direction) {
        int difference = Math.abs(this.degrees - direction.degrees);
        if (difference == 315) { // N - NW or NW - N
            difference = 45;
        }
        return difference;
    }
}

