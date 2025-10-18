package com.practicing02;

public class Leet_012_ReverseString_eros {

    public static void main(String[] args) {
        Leet_012_ReverseString_eros leet = new Leet_012_ReverseString_eros();
        System.out.println(leet.reverseString("abcdefghijlnmopqrstuvxz"));
        System.out.println(leet.reverseString("eros glauco koller"));
        System.out.println(leet.reverseString(""));
        System.out.println(leet.reverseString("g"));
    }


    public String reverseString(String str) {
       char[] charArray = str.toCharArray();
       if(charArray.length == 0) return "";
       if(charArray.length == 1) return new String(charArray);

       int left = 0;
       int right = charArray.length-1;
       while(left < right){
           char tmp = charArray[left];
           charArray[left] = charArray[right];
           charArray[right] = tmp;
           left++;
           right--;
       }

        return new String(charArray);
    }

}
