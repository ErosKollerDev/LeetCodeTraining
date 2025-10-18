package com.practicing02;

public class Leet_019_LongestPalindromicSubstring_eros {
    public static void main(String[] args) {
        Leet_019_LongestPalindromicSubstring_eros leet = new Leet_019_LongestPalindromicSubstring_eros();
//        System.out.println(leet.longestPalindrome("racecar"));
//        System.out.println(leet.longestPalindrome("racecard"));
//        System.out.println(leet.longestPalindrome("cagac"));
//        System.out.println(leet.longestPalindrome("cbbd"));
        System.out.println(leet.longestPalindrome("cxybaabjzd"));
        //c a a c

    }

    private int start = 0;
    private int end = 0;

    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        helper(s.toCharArray(), 0);
        return s.substring(start, end + 1);
    }

    //TODO master this code
    public void helper(char[] arr, int i) {
        if (i >= arr.length - 1) return;
        int left = i;
        int right = i;
        while (right < arr.length - 1 && arr[right] == arr[right + 1]) {
            right++;
        }
        i = right;
        while(left > 0 && right < arr.length-1 && arr[left-1] == arr[right+1]){
            left--;
            right++;
        }
        if(end - start < right - left){
            start = left;
            end = right;
        }
        helper(arr,++i);
    }
}