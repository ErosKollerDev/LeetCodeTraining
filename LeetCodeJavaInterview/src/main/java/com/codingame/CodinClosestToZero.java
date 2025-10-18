package com.codingame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodinClosestToZero {

//7 5 9 1 4
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of temperatures to analyse

        boolean isZero = false;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int t = in.nextInt(); // a temperature expressed as an integer ranging from -273 to 5526
            if (t >= -273 && t <= 5526) {
                list.add(t);
            }
            isZero = t == 0 ? true : false;
        }


        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");
        if (isZero) {
            System.out.println(0);
        } else {
            int lower = Integer.MIN_VALUE + 1;
            int higher = Integer.MAX_VALUE;

            for (Integer i : list) {
                if (i < 0) {
                    lower = Math.max(lower, i);
                } else {
                    higher = Math.min(higher, i);
                }

            }

            int absN = Math.abs(lower);
            if (list.size() > 0) {
                if (absN == higher) {
                    System.out.println(higher);
                } else if (absN > higher) {
                    System.out.println(higher);
                } else {
                    System.out.println(lower);
                }
            } else {
                System.out.println(0);
            }

        }

    }
}

