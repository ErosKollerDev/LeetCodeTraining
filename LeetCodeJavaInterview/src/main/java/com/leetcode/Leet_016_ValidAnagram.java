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
public class Leet_016_ValidAnagram {

    public static void main(String[] args) {
        Leet_016_ValidAnagram leet = new Leet_016_ValidAnagram();

        System.out.println(leet.isAnagram("eros","sore"));
        System.out.println(leet.isAnagram("eros","soree"));
        System.out.println(leet.isAnagram("eros","sorer"));
    }


    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        if(s.equals(t)) return false;
        List<String> sLetter = new ArrayList<>();
        List<String> tLetter = new ArrayList<>();

        for(int i = 0;i < s.length();  i ++){
            sLetter.add(s.charAt(i)+"");
            tLetter.add(t.charAt(i)+"");
        }
        Collections.sort(sLetter);
        Collections.sort(tLetter);
        String ss = "";
        String tt = "";
        for(int i = 0; i < sLetter.size(); i ++){
            ss += sLetter.get(i);
            tt += tLetter.get(i);
        }

        System.out.println(sLetter);
        System.out.println(tLetter);
        return ss.equals(tt);
    }

}//TC : O(strs.length * str.length())
//SC : O(1)