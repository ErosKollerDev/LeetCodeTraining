package com.leetcode;

/**
 * Given an integer x, return true if x is a
 * palindrome
 * , and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * Example 2:
 *
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */
public class Leet_003_PalindromeNumber {

    public static void main(String[] args) {

        System.out.println("-----------------");
        System.out.println(Leet_003_PalindromeNumber.isPalindrome(121212121));
        System.out.println("-----------------");
        System.out.println(Leet_003_PalindromeNumber.isPalindrome(995599));
        System.out.println("-----------------");
        System.out.println(Leet_003_PalindromeNumber.isPalindrome(10));
        System.out.println("-----------------");
        System.out.println(Leet_003_PalindromeNumber.isPalindrome(-121));
        System.out.println("-----------------");
        System.out.println(Leet_003_PalindromeNumber.isPalindrome(0));
    }
    public static  boolean isPalindrome(int x) {

        if (x < 0 ) return false;
        if(x == 0) return true;
        if(x != 0  && x % 10 == 0) return false;

        int reverse = 0;
        while(reverse < x){
            //get last digit
            int lastDigit = x % 10;
            //add to reverse   (12 then i have to multiply by 10 before adding)
            reverse = reverse * 10 + lastDigit;
            //remove last digit
            x = x / 10;
        }
        return
                (reverse == x)||
                //(12/10 == 1)
                        (reverse / 10 == x);
//        String sN = x + "";
//
//        String sNinverted = "";
//        for (int i = 0; i < sN.length(); i++) {
//            sNinverted = sN.charAt(i) + sNinverted;
//        }
//        try {
//            Integer y = Integer.valueOf(sNinverted);
//
//            if (y.intValue() == x)
//                return true;
//        } catch (Exception e) {
//            return false;
//        }
//
//        return false;
    }

}
