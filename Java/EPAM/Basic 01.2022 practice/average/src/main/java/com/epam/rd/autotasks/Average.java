package com.epam.rd.autotasks;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int avgValue, nextValue, counter;
        avgValue = scanner.nextInt();
        nextValue = scanner.nextInt();
        counter = 1;
        while(nextValue != 0) {
            avgValue += nextValue;
            nextValue = scanner.nextInt();
            counter++;
        }
        System.out.println(avgValue / counter);
    }

}