package com.codingame;

import java.util.Scanner;

public class CodinHeighestMountain {



    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int heighter = 0;
        int index = 0;
        // game loop
        while (true) {
            for (int i = 0; i < 8; i++) {
                int mountainH = in.nextInt(); // represents the height of one mountain.
                if(mountainH > heighter){
                    heighter = mountainH;
                    index = i;
                }
            }
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            System.out.println(heighter);
            System.out.println(index); // The index of the mountain to fire on.
           break;
        }
        in.close();
    }
}
