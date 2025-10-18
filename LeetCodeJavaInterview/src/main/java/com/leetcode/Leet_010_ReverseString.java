package com.leetcode;

public class Leet_010_ReverseString {

    public static void main(String[] args) {
        Leet_010_ReverseString leet = new Leet_010_ReverseString();

        System.out.println(leet.reverseString("abcd"));

    }



   public String reverseString(String s) {
        if(s.isEmpty() || s.length() == 1) return s;
        String inverted = "";
        for(int i = 0; i < s.length(); i ++){
            inverted = s.charAt(i) + inverted;
        }
        return inverted;
   }

}
