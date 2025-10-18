package com.practicing02;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * <p>
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: x = 123
 * Output: 321
 * Example 2:
 * <p>
 * Input: x = -123
 * Output: -321
 * Example 3:
 * <p>
 * Input: x = 120
 * Output: 21
 * <p>
 * <p>
 * Constraints:
 * <p>
 * -231 <= x <= 231 - 1
 */
public class Leet_005_ReverseInteger_eros {

    public static void main(String[] args) {
        Leet_005_ReverseInteger_eros leet = new Leet_005_ReverseInteger_eros();
//        int intOne = 1534236469;
//        int intOne = -121;
        int intOne = 1534236469;
        System.out.println(intOne);
        System.out.println(leet.reverseInteger(intOne));
        System.out.println("---- 123 ---");
        System.out.println(leet.reverseInteger(123));
    }

    public int reverseInteger(int n) {
        int MIN_VALUE = Integer.MIN_VALUE;
        int MAX_VALUE = Integer.MAX_VALUE;
        if (n < MIN_VALUE || n > MAX_VALUE) return 0;
        long reverse = 0;

        while (n != 0) {
            reverse = (reverse * 10) + (n % 10);
            n /= 10;
            if (reverse < MIN_VALUE) return 0;
            if (reverse > MAX_VALUE) return 0;
        }
        return (int) reverse;
    }
    //TC: 0(log5 n) SC: 0(1)
}
