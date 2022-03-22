package com.epam.rd.autotasks.meetstrangers;

import java.io.IOException;
import java.util.Scanner;

public class HelloStrangers {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int countStrangers = input.nextInt();
        String nameStranger;
        if(countStrangers == 0) {
            System.out.println("Oh, it looks like there is no one here");
        } else if(countStrangers < 0) {
            System.out.println("Seriously? Why so negative?");
        } else {
            for(int i=0; i <= countStrangers; i++) {
                nameStranger = input.nextLine();
                System.out.println("Hello, " + nameStranger);
            }
        }
    }
}
