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
public class A21_Leet_006_Power_X_N_grok {

    public static void main(String[] args) {
        A21_Leet_006_Power_X_N_grok leet = new A21_Leet_006_Power_X_N_grok();
        System.out.println("16 -> "+leet.myPow(2, 4));//16
        System.out.println("81 -> "+leet.myPow(3, 4));//81
        System.out.println("1024 -> "+leet.myPow(2.0000, 10));//1024
        System.out.println("1024 -> "+leet.myPow(4.0000, 5));//1024
        System.out.println("1.2676506002282294E30 -> "+leet.myPow(2.0000, 100));//1.2676506002282294E30
        System.out.println("1.2676506002282294E30 -> "+leet.myPow(16.0000, 25));//1.2676506002282294E30
        System.out.println("9.26100 -> "+leet.myPow(2.10000, 3));//9.26100
        System.out.println("0.25000 -> "+leet.myPow(2.00000, -2));// 0.25000
        System.out.println("16.0 -> "+leet.myPow(2.00000, 4));// 16.0
        System.out.println("1.0 -> "+leet.myPow(0.44528, 0));// 1.0
        System.out.println("1.0 -> "+leet.myPow(1.0, 2147483647));// 1.0
        System.out.println("1024 -> "+leet.myPow(4, 5));//1024
    }

    private double myPow(double base, int exponent) {
        if (base == 1) return 1;
        if (exponent == 0) return 1;
        if (exponent < 0) {
            return 1 / this.myPow(base, -exponent);
        }
        return base * this.myPow(base, exponent - 1);
    }


}
