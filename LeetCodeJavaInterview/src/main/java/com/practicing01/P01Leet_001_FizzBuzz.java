package com.practicing01;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, return a string array answer (1-indexed) where:
 * <p>
 * answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
 * answer[i] == "Fizz" if i is divisible by 3.
 * answer[i] == "Buzz" if i is divisible by 5.
 * answer[i] == i (as a string) if none of the above conditions are true.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 3
 * Output: ["1","2","Fizz"]
 * Example 2:
 * <p>
 * Input: n = 5
 * Output: ["1","2","Fizz","4","Buzz"]
 * Example 3:
 * <p>
 * Input: n = 15
 * Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 */
public class P01Leet_001_FizzBuzz {


    public static void main(String[] args) {
        P01Leet_001_FizzBuzz leet = new P01Leet_001_FizzBuzz();
        List<String> strings = leet.fizzBuzz(3);
        strings.stream().forEach(s -> System.out.println(s));
        System.out.println("###");
        strings = leet.fizzBuzz(5);
        strings.stream().forEach(s -> System.out.println(s));
        System.out.println("###");
        strings = leet.fizzBuzz(15);
        strings.stream().forEach(s -> System.out.println(s));
    }

    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0 ) {
                ans.add("FizzBuzz");
            }else if (i % 3 == 0) {
                ans.add("Fizz");
            }else if( i % 5 ==0 ){
                ans.add("Buzz");
            }else{
                ans.add(i+"");
            }
        }

        return ans;
    }
} //TC: 0(n) (Time Complexity | SC: 0(n) (Space Complexity) )
