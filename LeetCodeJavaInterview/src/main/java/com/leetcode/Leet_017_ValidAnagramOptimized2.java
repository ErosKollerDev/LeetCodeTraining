package com.leetcode;

public class Leet_017_ValidAnagramOptimized2 {

    public static void main(String[] args) {
        Leet_017_ValidAnagramOptimized2 leet = new Leet_017_ValidAnagramOptimized2();

        System.out.println(leet.isAnagram("ero", "sore"));
        System.out.println(leet.isAnagram("eros", "eros"));
    }


    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

}//TC : O(strs.length * str.length())
//SC : O(1)