package com.epam.rd.autotasks.meetautocode;

import java.util.Scanner;

public class ElectronicWatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seconds = scanner.nextInt();
        seconds %= 86400;
        int hours, minutes;
        hours = seconds / 3600;
        minutes = seconds % 3600 / 60;
        seconds %= 60;
        System.out.printf("%d:%02d:%02d", hours, minutes, seconds);
    }
}
