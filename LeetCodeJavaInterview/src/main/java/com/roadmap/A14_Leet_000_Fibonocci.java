package com.roadmap;

import com.util.PrintHelper;
import lombok.Data;

@Data
public class A14_Leet_000_Fibonocci {

    private static long[] fibonacciCache;


    public static void main(String[] args) {
        A14_Leet_000_Fibonocci leet = new A14_Leet_000_Fibonocci();
//        System.out.println();
        System.out.println("---------------");
        int n = 6;
        fibonacciCache = new long[n + 1];
        System.out.println(leet.fibonacciSimple(n));
    }

    //Fibonacci sequence starts with Zero and than One, and the next numbers will be the sum of the Two previous;
    //0 1 2 3 4 5 6
    //0 1 1 2 3 5 8
    //f(n) = f(n - 1) + f (n - 2)
    private long fibonacciSimple(int n) {
        var arr = new long[n + 1];
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        PrintHelper.printArray(arr);
        return arr[arr.length - 1];
    }
}