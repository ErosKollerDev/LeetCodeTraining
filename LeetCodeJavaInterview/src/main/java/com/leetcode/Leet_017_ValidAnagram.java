package com.leetcode;

import java.util.*;

/**
 * Given two strings s and t, return true if t is an
 * anagram
 *  of s, and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 *
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 *
 * Output: false
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 *
 *
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 */
public class Leet_017_ValidAnagram {

    public static void main(String[] args) {
        Leet_017_ValidAnagram leet = new Leet_017_ValidAnagram();

        System.out.println(leet.isAnagram("ero", "sore"));
    }


    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        if (s.equals(t)) return true;
        Map<String, Integer> sMap = new HashMap<>(s.length());
        Map<String, Integer> tMap = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            String ss = s.charAt(i) + "";
            String tt = t.charAt(i) + "";
            if (sMap.containsKey(ss)) {
                sMap.put(ss, sMap.getOrDefault(ss, 0) + 1);
            } else {
                sMap.put(ss, 1);
            }
            if (tMap.containsKey(tt)) {
                tMap.put(tt, tMap.getOrDefault(tt, 0) + 1);
            } else {
                tMap.put(tt, 1);
            }
        }

        for (String _s : sMap.keySet()) {
            if (!sMap.get(_s).equals(tMap.get(_s))) {
                return false;
            }
        }
        return true;
    }

}//TC : O(strs.length * str.length())
//SC : O(1)