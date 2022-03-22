package com.epam.rd.autotasks.godutch;

import java.util.Scanner;

public class GoDutch {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int total = input.nextInt();
        int friends = input.nextInt();
        if(total < 0) {
            System.out.println("Bill total amount cannot be negative");
        } else if(friends <= 0) {
            System.out.println("Number of friends cannot be negative or zero");
        } else {
            if(friends >= total && total > 0) {
                System.out.println(1);
            } else {
                System.out.println((total / friends) + ((total / friends) / 10));
            }
        }
    }
}
