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
public class A10_Leet_003_PalindromeNumber_training {

    public static void main(String[] args) {

        System.out.println("-----------------");
        System.out.println(A10_Leet_003_PalindromeNumber_training.isPalindrome(1234321));
        System.out.println("-----------------");
        System.out.println(A10_Leet_003_PalindromeNumber_training.isPalindrome(995599));
        System.out.println("-----------------");
        System.out.println(A10_Leet_003_PalindromeNumber_training.isPalindrome(10));
        System.out.println("-----------------");
        System.out.println(A10_Leet_003_PalindromeNumber_training.isPalindrome(-121));
        System.out.println("-----------------");
        System.out.println(A10_Leet_003_PalindromeNumber_training.isPalindrome(0));
        System.out.println("-----------------");
        System.out.println(A10_Leet_003_PalindromeNumber_training.isPalindrome(9));
    }
    public static  boolean isPalindrome(int number) {
        if(number < 0) return false;
        if(number < 10) return true;
        if(number % 10 == 0) return false;
        var reverse = 0;
        while(reverse < number){
            var lastD = number / 10;
            reverse = reverse * 10 + lastD;
            number /= 10;
        }
        return number == reverse || reverse / 10 == number;
    }

}
