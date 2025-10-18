package com.roadmap;

/**
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 * Example 2:
 * <p>
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 * Example 3:
 * <p>
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * <p>
 * <p>
 * Constraints:
 * <p>
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * n is an integer.
 * Either x is not zero or n > 0.
 * -104 <= xn <= 104
 */
public class A21_Leet_006_Power_X_N_recursion {

    public static void main(String[] args) {
        A21_Leet_006_Power_X_N_recursion leet = new A21_Leet_006_Power_X_N_recursion();
        System.out.println("16 -> " + leet.pow(2, 4));//16
        System.out.println("81 -> " + leet.pow(3, 4));//81
        System.out.println("1024 -> " + leet.pow(2.0000, 10));//1024
        System.out.println("1024 -> " + leet.pow(4.0000, 5));//1024
        System.out.println("1.2676506002282294E30 -> " + leet.pow(2.0000, 100));//1.2676506002282294E30
        System.out.println("1.2676506002282294E30 -> " + leet.pow(16.0000, 25));//1.2676506002282294E30
        System.out.println("9.26100 -> " + leet.pow(2.10000, 3));//9.26100
        System.out.println("0.25000 -> " + leet.pow(2.00000, -2));// 0.25000
        System.out.println("16.0 -> " + leet.pow(2.00000, 4));// 16.0
        System.out.println("1.0 -> " + leet.pow(0.44528, 0));// 1.0
        System.out.println("1.0 -> " + leet.pow(1.0, 2147483647));// 1.0
        System.out.println("1024 -> " + leet.pow(4, 5));//1024
    }

    // (5 of Power of 5) -> 5*5*5*5*5 = 3125
    private double pow(double base, int powerOf) {
        if (powerOf == 0) return 1.0;
        if (base == 1.0) return 1.0;

        if (powerOf < 0) {
            return 1 / this.pow(base, -powerOf);
        }
        return base * this.pow(base, powerOf - 1);
    }


}
