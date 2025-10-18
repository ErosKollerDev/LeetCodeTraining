package com.roadmap;

import java.util.Arrays;

/**
 * Given two strings s and t, return true if t is an
 * anagram
 * of s, and false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "anagram", t = "nagaram"
 * <p>
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: s = "rat", t = "car"
 * <p>
 * Output: false
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 * <p>
 * <p>
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 */
public class A07_Leet_002_ValidAnagram {

    public static void main(String[] args) {
        A07_Leet_002_ValidAnagram leet = new A07_Leet_002_ValidAnagram();

        System.out.println(leet.isAnagram("eros", "sore"));
        System.out.println(leet.isAnagram("eros", "sore"));
        System.out.println(leet.isAnagram("eros", "sore"));
        System.out.println(leet.isAnagram("eros", "sreo"));
        System.out.println(leet.isAnagram("eros", "sory"));
    }

    private boolean isAnagram(String wordOne, String wordTwo) {
        var charOne = wordOne.toCharArray();
        var charTwo = wordTwo.toCharArray();
        Arrays.sort(charOne);
        Arrays.sort(charTwo);
        var strOne = String.valueOf(charOne);
        var strTwo = String.valueOf(charTwo);
        return strOne.equalsIgnoreCase(strTwo);
    }


}//TC : O(strs.length * str.length())
//SC : O(1)