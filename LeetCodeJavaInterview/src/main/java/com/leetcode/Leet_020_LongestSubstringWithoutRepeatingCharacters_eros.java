package com.leetcode;

import java.util.HashMap;

public class Leet_020_LongestSubstringWithoutRepeatingCharacters_eros {
    public static void main(String[] args) {
        Leet_020_LongestSubstringWithoutRepeatingCharacters_eros leet = new Leet_020_LongestSubstringWithoutRepeatingCharacters_eros();
        System.out.println(leet.lengthOfLongestSubstring("abcdee")); //4
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) return 1;
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        char[] charsArray = s.toCharArray();
        for (int right = 0; right < charsArray.length; right++) {
            char ch = charsArray[right];
            if (!map.containsKey(ch)) {
                map.put(ch, right);
            } else {
                left = Math.max(left, map.get(ch) + 1);
                map.put(ch, right);
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

}