package com.roadmap;

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
public class A10_Leet_003_PalindromeNumber {

    public static void main(String[] args) {

        System.out.println("-----------------");
        System.out.println(A10_Leet_003_PalindromeNumber.isPalindrome(1234321));
        System.out.println("-----------------");
        System.out.println(A10_Leet_003_PalindromeNumber.isPalindrome(995599));
        System.out.println("-----------------");
        System.out.println(A10_Leet_003_PalindromeNumber.isPalindrome(10));
        System.out.println("-----------------");
        System.out.println(A10_Leet_003_PalindromeNumber.isPalindrome(-121));
        System.out.println("-----------------");
        System.out.println(A10_Leet_003_PalindromeNumber.isPalindrome(0));
        System.out.println("-----------------");
        System.out.println(A10_Leet_003_PalindromeNumber.isPalindrome(9));
    }
    public static  boolean isPalindrome(int x) {
//        if(x == 0) return true;
        if(x < 0) return false;
        if(x >= 0 && x <= 9) return true;
        if(x % 10 == 0)return false;

        int reverse = 0;
        while(reverse < x){
            int lastD = x % 10;
            reverse = reverse * 10 + lastD;
            x = x / 10;
        }


        return x == reverse || reverse / 10 == x ? true : false;
    }

}
