package com.roadmap;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * Example 2:
 *
 * Input: n = 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * Example 3:
 *
 * Input: n = 0
 * Output: 0
 *
 *
 * Constraints:
 *
 * 0 <= n <= 104
 *
 *
 * Follow up: Could you write a solution that works in logarithmic time complexity?
 */
public class A20_Leet_004_Factorial_Trailing_Zeroes_easy {

    public static void main(String[] args) {
//        int three = Leet_004_Factorial_Trailing_Zeroes.trailingZeroes(3);
//        System.out.println("Factorial of 3 is "+three);
//        Factorial of 5 1*2*3*4*5 = 120
//
//        1*2 = 2
//        2*3 = 6
//        6*4 = 24
//        24 * 5 = 120 = 1 occurrency of zero
        System.out.println("---------Factorial of 5 1*2*3*4*5 = 120 ----------");
        int five = A20_Leet_004_Factorial_Trailing_Zeroes_easy.trailingZeroes(5);
        System.out.println("Factorial of 5 is "+five);
        System.out.println("-------------------");
        int ten = A20_Leet_004_Factorial_Trailing_Zeroes_easy.trailingZeroes(10);
        System.out.println("Factorial of 10 is "+ten);
        System.out.println("-------------------");
        int n20 = A20_Leet_004_Factorial_Trailing_Zeroes_easy.trailingZeroes(20);
        System.out.println("Factorial of 20 is " + n20);
        System.out.println("-------------------");
        int n25 = A20_Leet_004_Factorial_Trailing_Zeroes_easy.trailingZeroes(25);
        System.out.println("Factorial of 25 is " + n25);
        System.out.println("-------------------");
        int n125 = A20_Leet_004_Factorial_Trailing_Zeroes_easy.trailingZeroes(125);
        System.out.println("Factorial of 125 is " + n125);
        System.out.println("-------------------");
    }

    public static int trailingZeroes(int n) {

        if (n == 0) return 0;
        if (n < 5) return 0;
        int zeros = 0;
        int result = 1;
        for ( int i = 1; i <= n; i ++){
            result = result * i;
            if(result % 10 == 0){
                zeros ++;
            }
        }
        return zeros;
    }
    //TC: 0(log5 n) SC: 0(1)
}
