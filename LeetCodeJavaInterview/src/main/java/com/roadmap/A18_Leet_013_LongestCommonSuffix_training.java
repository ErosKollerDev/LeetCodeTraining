package com.roadmap;

public class A18_Leet_013_LongestCommonSuffix_training {

    public static void main(String[] args) {
        A18_Leet_013_LongestCommonSuffix_training leet = new A18_Leet_013_LongestCommonSuffix_training();
        System.out.println(leet.longestCommonSuffix(new String[]{"abcdx", "abx", "abdkx", "abx", "abdfdfdfx"}));
        System.out.println(leet.longestCommonSuffix(new String[]{"flabcd", "flab", "flabdk", "flab", "flabdfdfdf"}));
        System.out.println(leet.longestCommonSuffix(new String[]{"xpto", "xp", "xqto", "xpto", "xdto"}));
        System.out.println(leet.longestCommonSuffix(new String[]{"abwnn", "abxnn", "abcnn"}));

    }


    public String longestCommonSuffix(String[] words) {
        if (words.length == 0) return "";
        if (words.length == 1) return words[0];
        var suffix = words[0];

        for (int i = 1; i < words.length; i++) {
            var w = words[i];
            while(w.indexOf(suffix) < 0){
                suffix = suffix.substring(1);
            }
        }

        return suffix;

    }

}//TC : O(strs.length * str.length())
//SC : O(1)