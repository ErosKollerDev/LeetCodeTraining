package com.roadmap;

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
public class A09_Leet_009_ValidPalindromo {
    public static void main(String[] args) {
        A09_Leet_009_ValidPalindromo leet = new A09_Leet_009_ValidPalindromo();
        System.out.println(leet.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(leet.isPalindrome("race a car"));
        System.out.println(leet.isPalindrome("ab_a"));

    }

    public boolean isPalindrome(String frase) {
        int left = 0, right = frase.length() - 1;
        while (left <= right) {
            char cl = frase.charAt(left);
            char cr = frase.charAt(right);
            if (!Character.isLetterOrDigit(cl)) {
                left++;
            } else if (!Character.isLetterOrDigit(cr)) {
                right--;
            } else {
                if (Character.toLowerCase(cl) == Character.toLowerCase(cr)) {
                    left++;
                    right--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}