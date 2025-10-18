package com.leetcode;

public class Leet_011_ReverseString {

    public static void main(String[] args) {
        Leet_011_ReverseString leet = new Leet_011_ReverseString();
        leet.reverseString(new char[]{'a', 'b', 'c', 'd','e','f','g','h'});

    }


    public void reverseString(char[] charArray) {
        //abcd
        if (charArray.length == 0) System.out.println("");
        if (charArray.length == 1) System.out.println(charArray[0]);

        int lastPointer = charArray.length - 1;
        for (int firstPointer = 0; firstPointer < charArray.length / 2; firstPointer++) {
            char charFirstPointer = charArray[firstPointer];
            charArray[firstPointer] = charArray[lastPointer];
            charArray[lastPointer] = charFirstPointer;
            lastPointer--;
        }

        System.out.println(charArray);
//        System.out.println(result);
    }

}
