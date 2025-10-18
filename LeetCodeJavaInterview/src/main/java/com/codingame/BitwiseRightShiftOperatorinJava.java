package com.codingame;

public class BitwiseRightShiftOperatorinJava {
    public static void main(String[] args) {
        int a = 8;
        int b = a << 2;// 1 0 0 0  -> 1 0 0 0 (0 0) - append 2 more zeros at the end
        System.out.println(b); //32
        int c = b >> 2;
        System.out.println(c); //1 0 0 0 (0 0) -> 1 0 0 0  - Remove 2 zeros at the end
        //c => 1 0 0 0 , now, lets remove to more zeros, will be 10 = 2
        int d = c >> 2; //10
        System.out.println(d);
        int e = d >> 1; //1
        System.out.println(e);
        int f = e >> 1; //1 will be 0
        System.out.println(f);
    }
}
