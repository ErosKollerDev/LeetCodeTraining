package com.codingame;

import java.util.Scanner;

public class CodinShadowsoftheKnight {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // width of the building.
        int H = in.nextInt(); // height of the building.
        int N = in.nextInt(); // maximum number of turns before game over.
        int X0 = in.nextInt();
        int Y0 = in.nextInt();
        int h0 = 0;
        int w0 = 0;

        System.err.println("W: " + W + ", H: " + H + ", N:" + N + ", X0: " + X0 + ", Y0: " + Y0);

        // game loop
        while (true) {
            String bombDir = in.next(); // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)
            System.err.println(bombDir);

           //descreasing Y
            if(bombDir.contains("U")){
                H = Y0;
                Y0 = (Y0 + h0) / 2;
            }
            //increasing Y
            if(bombDir.contains("D")){
                h0 = Y0;
                Y0 = (Y0 + H) / 2;
            }

            //decreasing X
            if(bombDir.contains("L")){
                W = X0;
                X0 = (X0 + w0) / 2;
            }
            //increasing X
            if(bombDir.contains("R")){
                w0 = X0;
                X0 = (X0 + W) / 2;
            }


            System.out.println(X0 + " " + Y0);
        }
    }

}
