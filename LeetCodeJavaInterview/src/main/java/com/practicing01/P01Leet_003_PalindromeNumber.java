package com.practicing01;

/**
 * Given an integer x, return true if x is a
 * palindrome
 * , and false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * Example 2:
 * <p>
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * <p>
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * <p>
 * Constraints:
 * <p>
 * -231 <= x <= 231 - 1
 * <p>
 * <p>
 * Follow up: Could you solve it without converting the integer to a string?
 */
public class P01Leet_003_PalindromeNumber {

    public static void main(String[] args) {

        System.out.println("-----------------");
//        System.out.println(PLeet_003_PalindromeNumber.isPalindrome(121212121));
//        System.out.println("-----------------");
//        System.out.println(Leet_003_PalindromeNumber.isPalindrome(10));
//        System.out.println("-----------------");
//        System.out.println(Leet_003_PalindromeNumber.isPalindrome(-121));
//        System.out.println(PLeet_003_PalindromeNumber.isPalindrome(1221));
//        System.out.println(PLeet_003_PalindromeNumber.isPalindrome(121));
        System.out.println(P01Leet_003_PalindromeNumber.isPalindrome(9));
        System.out.println(P01Leet_003_PalindromeNumber.isPalindrome(0));
//        System.out.println("-----------------");
//        System.out.println(Leet_003_PalindromeNumber.isPalindrome(0));
    }

    public static boolean isPalindrome(int x) {
        if (x == 0) return true;
        if (x < 0) return false;
        if (x < 10) return true;
        if (x % 10 == 0) return false;
        int reverse = 0;
        //123321
        //reverse(0) | x (123321)
        //reverse(1) | x (12332)
        //reverse(2) | x (1233)
        while (reverse < x) {
            // 123321 % 10 + 1 = 1
            // 12332 % 10 + 1 = 2
            // 1233 % 10 + 1 = 3
            int lastDigit = x % 10;

            // 1 * 10 + 1 = 1
            // 2 * 10 + 2 = 12
            // 3 * 10 + 3 = 123
            reverse = reverse * 10 + lastDigit;
            //123321 / 10 = 123321 = 12332;
            //12332 / 10 = 1233 = 1233;
            //1233 / 10 = 1233 = 123;
            x = x / 10;
        }
        System.out.println(x);
        System.out.println(reverse);
        System.out.println(reverse / 10);
        return reverse == x || x == (reverse / 10);
    }

}
