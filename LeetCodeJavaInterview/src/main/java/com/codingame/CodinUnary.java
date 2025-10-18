package com.codingame;

import java.util.Scanner;

public class CodinUnary {


    public static void main(String args[]) {
//        Scanner in = new Scanner(System.in);
//        String MESSAGE = in.nextLine();

        var MESSAGE = "C";

        var res = "";
        var pre = -1;

        for (var i = 0; i < MESSAGE.length(); i++) {

            for (var j = 6; j >= 0; j--) {
                int code = MESSAGE.charAt(i) - 0;
//                var bit = code >> j & 1;
                var bit = (code >> j) % 2 == 0 ? 0 : 1;

                if (bit != pre) {
                    if (-1 != pre) {
                        res += " ";
                    }
                    res += 1 == bit ? "0 " : "00 ";
                    pre = bit;
                }
                res += "0";
            }
        }
        //0 0 00 0000 0 00
        //0 0 00 0000 0 00
        System.out.println(res);
    }
}
