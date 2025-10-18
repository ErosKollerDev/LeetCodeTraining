package com.algorythm;

public class TwoPointers {

    public static void main(String[] args) {
        TwoPointers twoPointers = new TwoPointers();
        System.out.println(twoPointers.isValidPalindrome("abcdcba"));
        System.out.println(twoPointers.isValidPalindrome("abccba"));
        System.out.println(twoPointers.isValidPalindrome("abcdebca"));
    }


    public boolean isValidPalindrome(String str) {
        int start = 0, end = str.length() - 1;
        char[] chars = str.toCharArray();
        while (start < end) {
            if (chars[start] != chars[end]) return false;
            start++;
            end--;
        }
        return true;
    }
}



