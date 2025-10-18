package com.leetcode;

/**
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 * <p>
 * Each letter in magazine can only be used once in ransomNote.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 * <p>
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 * <p>
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 */
public class Leet_031_RansomNote {
    public static void main(String[] args) {
        Leet_031_RansomNote leet = new Leet_031_RansomNote();
//        System.out.println(leet.canConstruct("aa", "ab"));
//        System.out.println(leet.canConstruct("aa", "aabc"));
        System.out.println(leet.canConstruct("fihjjjjei", "zhjibagacbhadfaefdjaeaebgi"));//false
    }


    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() == 0) return false;
        int[] counter = new int[26];
        boolean result = false;
        for (int i = 0; i < magazine.length(); i++) {
            counter[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (counter[ransomNote.charAt(i) - 'a'] > 0) {
                counter[ransomNote.charAt(i) - 'a']--;
                result = true;
            } else {
                result = false;
                break;
            }
        }

        return result;
    }
}