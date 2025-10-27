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
public class A09_Leet_009_ValidPalindromo_training {
    public static void main(String[] args) {
        A09_Leet_009_ValidPalindromo_training leet = new A09_Leet_009_ValidPalindromo_training();
        System.out.println(leet.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(leet.isPalindrome("race a car"));
        System.out.println(leet.isPalindrome("ab_a"));

    }

    public boolean isPalindrome(String frase) {
        char[] charArray = frase.toCharArray();
        int left = 0, right = charArray.length - 1;
        while (left <= right) {
            var cl = charArray[left];
            var cr = charArray[right];
            if (!Character.isLetterOrDigit(cl)) left++;
            else if (!Character.isLetterOrDigit(cr)) right--;
            else {
                if (!String.valueOf(cl).equalsIgnoreCase(String.valueOf(cr))) {
                    return false;
                }
                left++;
                right--;
            }


        }
        return true;
    }

}