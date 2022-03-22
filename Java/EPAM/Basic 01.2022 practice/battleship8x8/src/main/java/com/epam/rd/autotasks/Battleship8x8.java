package com.epam.rd.autotasks;


public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;

    public Battleship8x8(final long ships) {
        this.ships = ships;
    }

    private static <T extends Long> String get64bitStringFromValue(T value) {
        return String.format("%64s", T.toBinaryString(value)).replace(' ', '0');
    }

    private static int getPositionInFieldFromCoordsShot(String shot) {
        int column = (int) shot.charAt(0) - 64; // A = code 65
        int row = shot.charAt(1) - 49;          // "1" = code 49
        return (column - 1) + (row * 8);        // 8 positions in line;
    }

    private void writeShootAttempt(int shotPosition) {
        char[] shotsArr = get64bitStringFromValue(shots).toCharArray(); // convert number to char array
        shotsArr[shotPosition] = '1';                                   // write that the shot was fired
        shots = Long.parseUnsignedLong(new String(shotsArr), 2); // convert char array into number. 2 scale of notation
    }

    public boolean shoot(String shot) {
        String field = get64bitStringFromValue(ships);
        int shotPosition = getPositionInFieldFromCoordsShot(shot);
        boolean hit = field.charAt(shotPosition) == '1';
        writeShootAttempt(shotPosition);
        return hit;
    }

    public String state() {
        char[] field = get64bitStringFromValue(ships).toCharArray();
        char[] shotsDone = get64bitStringFromValue(shots).toCharArray();
        StringBuilder fieldAfterShooting = new StringBuilder();
        char symbol = '.';
        for (int i = 0; i < field.length; i++) {
            if (field[i] == '0' && shotsDone[i] == '0') {
                symbol = '.';
            }
            if (field[i] == '0' && shotsDone[i] == '1') {
                symbol = '×';
            }
            if (field[i] == '1' && shotsDone[i] == '0') {
                symbol = '☐';
            }
            if (field[i] == '1' && shotsDone[i] == '1') {
                symbol = '☒';
            }
            fieldAfterShooting.append(symbol);
            if ((i + 1) % 8 == 0) {
                fieldAfterShooting.append('\n');
            }
        }
        return new String(fieldAfterShooting);
    }
}
