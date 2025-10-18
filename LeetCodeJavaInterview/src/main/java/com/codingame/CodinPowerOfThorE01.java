package com.codingame;

import java.util.Scanner;

public class CodinPowerOfThorE01 {



    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int lightX = in.nextInt(); // the X position of the light of power
        int lightY = in.nextInt(); // the Y position of the light of power
        int initialTx = in.nextInt(); // Thor's starting X position
        int initialTy = in.nextInt(); // Thor's starting Y position

        // game loop
        while (true) {
            int remainingTurns = in.nextInt(); // The remaining amount of turns Thor can move. Do not remove this line.

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            String moviment = "";
            if(initialTy == lightY){
                moviment = "";
                System.err.println("mov: "+moviment+", dont do anytrhing");
            }else if(initialTy > lightY){
                moviment += "N";
                initialTy--;
            }else if(initialTy  < lightY  ){
                moviment += "S";
                initialTy++;
            }

            if(initialTx == lightX){
                System.err.println("X: "+initialTx+", Y: "+ initialTy );
            }else if(initialTx < lightX ){
                moviment += "E";
                initialTx++;
            }else if(initialTx > lightX ){
                moviment += "W";
                initialTx--;
            }

            System.out.println(moviment);
        }
    }
}
