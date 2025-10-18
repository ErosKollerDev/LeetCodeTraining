package com.leetcode;

public class Leet_012_ReverseString {

    public static void main(String[] args) {
        Leet_012_ReverseString leet = new Leet_012_ReverseString();
        leet.reverseString(new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'});

    }


    public void reverseString(char[] charArray) {
        //abcd
        if (charArray.length == 0) System.out.println("");
        if (charArray.length == 1) System.out.println(charArray[0]);


        int firsPointer = 0;
        int lastPointer = charArray.length - 1;
        while (firsPointer < lastPointer) {
            char tmp = charArray[firsPointer];
            charArray[firsPointer] = charArray[lastPointer];
            charArray[lastPointer] = tmp;
            firsPointer++;
            lastPointer--;
        }
        System.out.println(charArray);
    }

}
