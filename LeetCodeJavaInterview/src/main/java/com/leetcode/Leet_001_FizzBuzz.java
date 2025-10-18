package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Leet_001_FizzBuzz {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int int3 = sc.nextInt();
//        int int5 = sc.nextInt();
        int int15 = sc.nextInt();
        sc.close();


        Leet_001_FizzBuzz leet = new Leet_001_FizzBuzz();
//        List<String> strings =
//                leet.fizzBuzz(int3);
//        System.out.println("Input: " + int3);
//        System.out.println(strings);
//        System.out.println("\n-----------------------");
//        System.out.println("Input: " + int5);
//        strings = leet.fizzBuzz(int5);
//        System.out.println(strings);
        System.out.println("\n-----------------------");
        System.out.println("Input: " + int15);
        List<String> strings = leet.fizzBuzz(int15);
        System.out.println(strings);
    }

    public List<String> fizzBuzz(int n) {

//        int[] numbers = new int[10];
        List<String> answer = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                answer.add("FizzBuzz");
            } else if (i % 3 == 0) {
                answer.add("Fizz");
            } else if (i % 5 == 0) {
                answer.add("Buzz");
            } else {
                answer.add("" + i);
            }
        }


        return answer;
    }
} //TC: 0(n) (Time Complexity | SC: 0(n) (Space Complexity) )
