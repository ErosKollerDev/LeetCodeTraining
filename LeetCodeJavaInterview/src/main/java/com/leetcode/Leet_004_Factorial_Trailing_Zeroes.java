package com.leetcode;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * <p>
 * Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * Example 2:
 * <p>
 * Input: n = 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * Example 3:
 * <p>
 * Input: n = 0
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= n <= 104
 * <p>
 * <p>
 * Follow up: Could you write a solution that works in logarithmic time complexity?
 */
public class Leet_004_Factorial_Trailing_Zeroes {

    public static void main(String[] args) {
//        int three = Leet_004_Factorial_Trailing_Zeroes.trailingZeroes(3);
//        System.out.println("Factorial of 3 is "+three);
        System.out.println("-------------------");
//        int five = Leet_004_Factorial_Trailing_Zeroes.trailingZeroes(5);
//        System.out.println("Factorial of 5 is "+five);
//        System.out.println("-------------------");
//        int ten = Leet_004_Factorial_Trailing_Zeroes.trailingZeroes(10);
//        System.out.println("Factorial of 10 is "+ten);
//        System.out.println("-------------------");

        int thirdFive = Leet_004_Factorial_Trailing_Zeroes.trailingZeroes(35);
        System.out.println("Factorial of 35 is " + thirdFive);
        System.out.println("-------------------");
//        int n20 = Leet_004_Factorial_Trailing_Zeroes.trailingZeroes(20);
//        System.out.println("Factorial of 20 is " + n20);
        System.out.println("-------------------");
//        int n25 = Leet_004_Factorial_Trailing_Zeroes.trailingZeroes(25);
//        System.out.println("Factorial of 25 is " + n25);
//        System.out.println("-------------------");

//        int n125 = Leet_004_Factorial_Trailing_Zeroes.trailingZeroes(125);
//        System.out.println("Factorial of 125 is " + n125);
        System.out.println("-------------------");
    }

    public static int trailingZeroes(int n) {
//TODO get the explanation for trailing Zeros
        if (n == 0) return 0;
        if (n < 5) return 0;
        int zeros = 0;
        int currentPowerOf5 = 5;
        while (n >= currentPowerOf5) {
            zeros += n / currentPowerOf5;
            currentPowerOf5 *= 5;
        }
        return zeros;
    }
    //TC: 0(log5 n) SC: 0(1)
}
