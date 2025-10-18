package com.leetcode;

/**
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * <p>
 * A subsequence of a string is a new string that is formed from the original string by deleting some
 * (can be none) of the characters without disturbing the relative positions of the remaining characters.
 * (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= s.length <= 100
 * 0 <= t.length <= 104
 * s and t consist only of lowercase English letters.
 * <p>
 * <p>
 * Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109,
 * and you want to check one by one to see if t has its subsequence.
 * In this scenario, how would you change your code?
 */
public class Leet_049_IsSubSequence {
    public static void main(String[] args) {
        Leet_049_IsSubSequence leet = new Leet_049_IsSubSequence();
        System.out.println(leet.isSubsequence("abc","ahbgdc"));//true
        System.out.println(leet.isSubsequence("axc","ahbgdc"));//false
        System.out.println(leet.isSubsequence("xpto","abcxfgpfddfdtodfter"));//true
    }

    public boolean isSubsequence(String s, String t) {
        int s1 = 0;
        int s2 = 0;
            while(s1 < s.length() && s2 < t.length()){
                if(s.charAt(s1)  == t.charAt(s2)){
                    s1++;
                    s2++;
                }else{
                    s2++;
                }
            }
        return s1 == s.length();
    }
}