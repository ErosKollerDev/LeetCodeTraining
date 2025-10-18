package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leet_017_ValidAnagramOptimized1 {

    public static void main(String[] args) {
        Leet_017_ValidAnagramOptimized1 leet = new Leet_017_ValidAnagramOptimized1();

        System.out.println(leet.isAnagram("ero", "sore"));
    }


    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

}//TC : O(strs.length * str.length())
//SC : O(1)