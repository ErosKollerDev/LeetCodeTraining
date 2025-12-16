package com.roadmap;

import java.util.Arrays;

public class A18_Leet_013_LongestCommonPrefix {

    public static void main(String[] args) {
        A18_Leet_013_LongestCommonPrefix leet = new A18_Leet_013_LongestCommonPrefix();
//        System.out.println(leet.longestCommonPrefix(new String[]{"abcd", "ab", "abdk", "ab", "abdfdfdf"}));
//        System.out.println(leet.longestCommonPrefix(new String[]{"flabcd", "flab", "flabdk", "flab", "flabdfdfdf"}));
//        System.out.println(leet.longestCommonPrefix(new String[]{"xpto", "xp", "xqto", "xpto", "xdto"}));
        System.out.println(leet.longestCommonPrefix(new String[]{"abw", "abx", "abc"}));

    }


    public String longestCommonPrefix(String[] words) {
        if (words.length == 0) return "";
        if (words.length == 1) return words[0];
        var prefix = words[0];

        for (int i = 1; i < words.length; i++) {
            while (words[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

}//TC : O(strs.length * str.length())
//SC : O(1)