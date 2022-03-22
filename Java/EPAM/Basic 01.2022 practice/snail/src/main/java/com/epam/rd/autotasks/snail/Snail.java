package com.epam.rd.autotasks.snail;

import java.util.Scanner;

public class Snail
{
    public static void main(String[] args)
    {
        //Write a program that reads a,b and h (line by lyne in this order) and prints
        //the number of days for which the snail reach the top of the tree.
        //a - feet that snail travels up each day, b - feet that slides down each night, h - height of the tree
        Scanner input = new Scanner(System.in);
        int a, b, h;
        double daysToWin;
        a = input.nextInt();
        b = input.nextInt();
        h = input.nextInt();
        if(h <= a) {
            System.out.println(1);
        } else if(b >= a) {
            System.out.println("Impossible");
        } else {
            daysToWin = (h - b) / (a - b);
            System.out.println((int)daysToWin);
        }
    }
}
