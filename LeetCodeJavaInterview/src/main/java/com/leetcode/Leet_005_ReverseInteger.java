package com.leetcode;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 *
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 *
 *
 *
 * Example 1:
 *
 * Input: x = 123
 * Output: 321
 * Example 2:
 *
 * Input: x = -123
 * Output: -321
 * Example 3:
 *
 * Input: x = 120
 * Output: 21
 *
 *
 * Constraints:
 *
 * -231 <= x <= 231 - 1
 */
public class Leet_005_ReverseInteger {

    public static void main(String[] args) {
        Leet_005_ReverseInteger leet = new Leet_005_ReverseInteger();
//        int intOne = 1534236469;
//        int intOne = -121;
        int intOne = 1534236469;
        System.out.println(intOne);
        System.out.println(leet.reverseInteger(intOne));
    }

    public  int reverseInteger(int x) {
        int MAX_VALUE = Integer.MAX_VALUE;
        int MIN_VALUE = Integer.MIN_VALUE;
        if (x >= MAX_VALUE || x <= MIN_VALUE) {
            return 0;
        }
        long reverse = 0;

        while (x != 0) {
            int lastDigit = x % 10;
            reverse = reverse * 10 + lastDigit;

            x /= 10;
            if (reverse > MAX_VALUE)
                return 0;
            if (reverse < MIN_VALUE)
                return 0;
        }
        return (int) reverse;
    }
    //TC: 0(log5 n) SC: 0(1)
}
