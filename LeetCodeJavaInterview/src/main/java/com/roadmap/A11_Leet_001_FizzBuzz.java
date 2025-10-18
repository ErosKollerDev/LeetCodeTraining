package com.roadmap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Given an integer n, return a string array answer (1-indexed) where:
 *
 * answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
 * answer[i] == "Fizz" if i is divisible by 3.
 * answer[i] == "Buzz" if i is divisible by 5.
 * answer[i] == i (as a string) if none of the above conditions are true.
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["1","2","Fizz"]
 * Example 2:
 *
 * Input: n = 5
 * Output: ["1","2","Fizz","4","Buzz"]
 * Example 3:
 *
 * Input: n = 15
 * Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 104
 */

public class A11_Leet_001_FizzBuzz {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int int3 = sc.nextInt();
//        int int5 = sc.nextInt();
        int int15 = sc.nextInt();
        sc.close();


        A11_Leet_001_FizzBuzz leet = new A11_Leet_001_FizzBuzz();
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
