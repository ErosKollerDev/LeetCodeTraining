package com.practicing02;

public class Leet_013_LogestCommonPrefix_eros {

    public static void main(String[] args) {
        Leet_013_LogestCommonPrefix_eros leet = new Leet_013_LogestCommonPrefix_eros();
        System.out.println(leet.longestCommonPrefix(new String[]{"abcd", "ab", "abdk", "ab", "abdfdfdf"}));
        System.out.println(leet.longestCommonPrefix(new String[]{"flabcd", "flab", "flabdk", "flab", "flaxdfdfdf"}));
        System.out.println(leet.longestCommonPrefix(new String[]{"xpto", "xp", "xqto", "xpto", "xdto"}));
        System.out.println(leet.longestCommonPrefix(new String[]{"a"}));

    }


    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if( strs.length == 1) return strs[0];
       String prefix = strs[0];

       for(int i =1; i < strs.length; i ++){
           while(strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length()-1);
                if(prefix == ""){
                    return "";
                }
           }
       }

       return prefix;
    }

}//TC : O(strs.length * str.length())
//SC : O(1)