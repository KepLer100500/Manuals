package com.epam.rd.autotasks.pizzasplit;

import java.util.Scanner;

public class PizzaSplit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countPeoples = scanner.nextInt();
        int countPieces = scanner.nextInt();
        for(int i=1; i <= countPeoples * countPieces; i++){
            if(countPieces * i % countPeoples == 0 ) {
                System.out.println(i);
                break;
            }
        }
    }
}
