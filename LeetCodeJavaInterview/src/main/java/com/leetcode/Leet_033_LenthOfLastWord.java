package com.leetcode;

/**
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 *
 * A word is a maximal
 * substring
 *  consisting of non-space characters only.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 * Example 2:
 *
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * Explanation: The last word is "moon" with length 4.
 * Example 3:
 *
 * Input: s = "luffy is still joyboy"
 * Output: 6
 * Explanation: The last word is "joyboy" with length 6.
 */
public class Leet_033_LenthOfLastWord {
    public static void main(String[] args) {
        Leet_033_LenthOfLastWord leet = new Leet_033_LenthOfLastWord();
        System.out.println(leet.lengthOfLastWord("Hello World"));
        System.out.println(leet.lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(leet.lengthOfLastWord("luffy is still joyboy"));
    }

    public int lengthOfLastWord(String s) {
        if(s.length() == 0)return 0;
        var splits = s.trim().split(" ");
        for(int i = splits.length -1 ; i >= splits.length -1; i--){
            if(!splits[i].equals(" ") ){
                return  splits[i].length();
            }
        }
        return 0;
    }

}