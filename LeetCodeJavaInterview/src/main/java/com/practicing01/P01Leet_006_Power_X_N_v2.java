package com.practicing01;

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
public class P01Leet_006_Power_X_N_v2 {

    public static void main(String[] args) {
        P01Leet_006_Power_X_N_v2 leet = new P01Leet_006_Power_X_N_v2();
//        System.out.println(leet.myPow(2, 4));//1024
//        System.out.println(leet.myPow(4, 5));//1024
//        System.out.println(leet.myPow(2.0000, 10));//9.26100
//        System.out.println(leet.myPow(4.0000, 5));//9.26100
        System.out.println(leet.myPow(2.0000, 100));//9.26100
        System.out.println(leet.myPow(16.0000, 25));//9.26100
        System.out.println(leet.myPow(2.10000, 3));//9.26100
        System.out.println(leet.myPow(2.00000, -2));// 0.25000
//        System.out.println(leet.myPow(0.44528, 0));// 1.0
//        System.out.println(leet.myPow(1.0, 2147483647));// 1.0
    }

    public double myPow(double x, int n) {
        //convert in positive
        long power = Math.abs((long) n);
        double result = 1.0;

        while (power != 0) {

            if(power % 2 == 1){
                result = result *x;
                power--;
            }

            power = power / 2;
            x = x * x;
        }

        return n < 0 ? 1.0 / result : result;
    }
}
