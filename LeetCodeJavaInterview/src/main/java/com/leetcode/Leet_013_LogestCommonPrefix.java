package com.leetcode;

import javax.xml.crypto.dsig.spec.HMACParameterSpec;

public class Leet_013_LogestCommonPrefix {

    public static void main(String[] args) {
        Leet_013_LogestCommonPrefix leet = new Leet_013_LogestCommonPrefix();
        System.out.println(leet.longestCommonPrefix(new String[]{"abcd", "ab", "abdk", "ab", "abdfdfdf"}));
        System.out.println(leet.longestCommonPrefix(new String[]{"flabcd", "flab", "flabdk", "flab", "flabdfdfdf"}));
        System.out.println(leet.longestCommonPrefix(new String[]{"xpto", "xp", "xqto", "xpto", "xdto"}));
        System.out.println(leet.longestCommonPrefix(new String[]{"a"}));

    }


    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if( strs.length == 1) return strs[0];
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

}//TC : O(strs.length * str.length())
//SC : O(1)