package com.leetcode;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 * <p>
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * Example 2:
 * <p>
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * Example 3:
 * <p>
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 2 * 105
 * s consists only of printable ASCII characters.
 */
public class Leet_054_ValidPalindromo {
    public static void main(String[] args) {
        Leet_054_ValidPalindromo leet = new Leet_054_ValidPalindromo();
        System.out.println(leet.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(leet.isPalindrome("race a car"));
        System.out.println(leet.isPalindrome("ab_a"));

    }

    public boolean isPalindrome(String s) {
        int p1 = 0, p2 = s.length() - 1;
        while (p1 <= p2) {
            char c1 = s.charAt(p1);
            char c2 = s.charAt(p2);
            if (!Character.isLetterOrDigit(c1)) {
                p1++;
            } else if (!Character.isLetterOrDigit(c2)) {
                p2--;
            } else {
                if (Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
                    return false;
                }else{
                    p1++;
                    p2--;
                }
            }

        }
        return true;
    }

}