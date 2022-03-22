package com.epam.rd.autotasks.meetanagent;

import java.util.Scanner;

public class MeetAnAgent {
    final static int password = 133976; //You can change pass, but don't change the type

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int key = input.nextInt();
        if(key == password) {
            System.out.println("Hello, Agent");
        } else {
            System.out.println("Access denied");
        }
    }
}
