package com.leetcode;

/**
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 * <p>
 * A word is a maximal
 * substring
 * consisting of non-space characters only.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 * Example 2:
 * <p>
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * Explanation: The last word is "moon" with length 4.
 * Example 3:
 * <p>
 * Input: s = "luffy is still joyboy"
 * Output: 6
 * Explanation: The last word is "joyboy" with length 6.
 */
public class Leet_034_LenthOfLastWord {
    public static void main(String[] args) {
        Leet_034_LenthOfLastWord leet = new Leet_034_LenthOfLastWord();
        System.out.println(leet.lengthOfLastWord("Hello World"));
        System.out.println(leet.lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(leet.lengthOfLastWord("luffy is still joyboy"));
    }

    public int lengthOfLastWord(String s) {
        if (s.length() == 0) return 0;
        var right = s.length() - 1;
        while (right >= 0 && s.charAt(right) == ' ') {
            right--;
        }
        int left = right;
        while(left >= 0 && s.charAt(left) != ' '){
            left--;
        }
        return right - left;
    }

}