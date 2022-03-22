package com.epam.rd.autotasks.sequence;
import java.util.Scanner;

public class FindMaxInSeq {
    public static int max() {
        Scanner input = new Scanner(System.in);
        int maxValue = input.nextInt();
        int newValue = input.nextInt();
        while (newValue != 0) {
            if(newValue > maxValue) {
                maxValue = newValue;
            }
            newValue = input.nextInt();
        }
        return maxValue;
    }

    public static void main(String[] args) {
        System.out.println("Test your code here!\n");
        System.out.println(max());
    }
}
