package com.practicing02;

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
public class Leet_017_ValidAnagramOptmized_eros {

    public static void main(String[] args) {
        Leet_017_ValidAnagramOptmized_eros leet = new Leet_017_ValidAnagramOptmized_eros();

        System.out.println(leet.isAnagram("eros", "sore"));
        System.out.println(leet.isAnagram("eross", "sorse"));
        System.out.println(leet.isAnagram("eros", "sorex"));
        System.out.println(leet.isAnagram("erdos", "sore"));
    }


    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] alphabet = new int[26];
        for(int i = 0; i < s.length(); i ++){
            alphabet[s.charAt(i) - 'a']++;
            alphabet[t.charAt(i) - 'a']--;
        }
        for(int count : alphabet){
            if(count != 0){
                return false;
            }
        }
        return true;
    }

}//TC : O(strs.length * str.length())
//SC : O(1)