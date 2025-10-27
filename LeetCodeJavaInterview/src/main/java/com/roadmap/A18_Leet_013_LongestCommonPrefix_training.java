package com.roadmap;

public class A18_Leet_013_LongestCommonPrefix_training {

    public static void main(String[] args) {
        A18_Leet_013_LongestCommonPrefix_training leet = new A18_Leet_013_LongestCommonPrefix_training();
//        System.out.println(leet.longestCommonPrefix(new String[]{"abcd", "ab", "abdk", "ab", "abdfdfdf"}));
//        System.out.println(leet.longestCommonPrefix(new String[]{"flabcd", "flab", "flabdk", "flab", "flabdfdfdf"}));
//        System.out.println(leet.longestCommonPrefix(new String[]{"xpto", "xp", "xqto", "xpto", "xdto"}));
        System.out.println(leet.longestCommonPrefix(new String[]{"abw", "abx", "abc"}));

    }


    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0 )return "";
        if(strs.length ==1 )return strs[0];


        var prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            var w = strs[i];
            while(w.indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length() -1);
            }
        }

        return prefix;
    }

}//TC : O(strs.length * str.length())
//SC : O(1)