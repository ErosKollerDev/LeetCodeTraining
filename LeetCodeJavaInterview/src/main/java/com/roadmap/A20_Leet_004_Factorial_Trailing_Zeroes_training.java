package com.roadmap;

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
public class A20_Leet_004_Factorial_Trailing_Zeroes_training {

    public static void main(String[] args) {
//        int three = Leet_004_Factorial_Trailing_Zeroes.trailingZeroes(3);
//        System.out.println("Factorial of 3 should be "+three);
//        Factorial of 5 1*2*3*4*5 = 120
//
//        1*2 = 2
//        2*3 = 6
//        6*4 = 24
//        24 * 5 = 120
        System.out.println("---------Factorial of 5 1*2*3*4*5 = 120 ----------");
        int five = A20_Leet_004_Factorial_Trailing_Zeroes_training.trailingZeroes(5);
        System.out.println("Factorial of 5 should be 1 -> " + five);
        System.out.println("-------------------");
        int ten = A20_Leet_004_Factorial_Trailing_Zeroes_training.trailingZeroes(10);
        System.out.println("Factorial of 10 should be 2 -> " + ten);
        System.out.println("-------------------");
        int n20 = A20_Leet_004_Factorial_Trailing_Zeroes_training.trailingZeroes(20);
        System.out.println("Factorial of 20 should be 4 -> " + n20);
        System.out.println("-------------------");
        int n25 = A20_Leet_004_Factorial_Trailing_Zeroes_training.trailingZeroes(25);
        System.out.println("Factorial of 25 should be 6 -> " + n25);
        System.out.println("-------------------");
        int n125 = A20_Leet_004_Factorial_Trailing_Zeroes_training.trailingZeroes(125);
        System.out.println("Factorial of 125 should be 31 ->  " + n125);
        System.out.println("-------------------");
    }
    //Obs hint Every even number multiplied by 5 produces a trailing zero numbers
    // 5 factorial -> 5x4x3x2x1 = 120 just one zero
    //10 factorial -> 10x9x8x7x6x5x4x3x2x1 = 3_628_800 two zeros
    public static int trailingZeroes(int factorialNumber) {
        if(factorialNumber < 5) return 0;
        var zeros = 0;
        var currentPoserOfFive = 5;
        while(currentPoserOfFive <= factorialNumber){
            zeros = zeros + (factorialNumber / currentPoserOfFive);
            currentPoserOfFive *= 5;
        }

        return zeros;
    }
    //TC: 0(log5 n) SC: 0(1)
}
