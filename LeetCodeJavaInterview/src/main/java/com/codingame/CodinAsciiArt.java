package com.codingame;

import java.util.Scanner;

public class CodinAsciiArt {


    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int H = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        String T = in.nextLine().toUpperCase();

        System.err.println("Letter: " + T + ", L: " + L + ", H: " + H);
        StringBuilder lineToPrint = new StringBuilder();
        for (int i = 0; i < H; i++) {
            String ROW = in.nextLine();
            System.err.println(ROW);
            for (int j = 0; j < T.length(); j++) {

                char at = T.charAt(j);
                if (at < 65) {
                    at = 'Z' + 1;
                }
                int indexLetter = at - 'A';
                int indexStart = indexLetter * 4;
                lineToPrint.append(ROW.substring(indexStart, indexStart + 3));
                lineToPrint.append(" ");
                if (j + 1 == T.length()) {
                    lineToPrint.append("\n");
                }
            }
        }
        System.out.println(lineToPrint.toString());
    }
}
