package com.leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Leet_022_ReverseWordsinaString {
    public static void main(String[] args) {
        Leet_022_ReverseWordsinaString leet = new Leet_022_ReverseWordsinaString();
        System.out.println(leet.reverseWords("the sky is blue"));
//        System.out.println(leet.reverseWords("the"));
    }


    public String reverseWords(String s) {
        char[] strArray = s.toCharArray();
        //step 1: reverse the entire array
        reverse(strArray, 0, strArray.length - 1);
        //step 2: reverse the words into the array
        reverseWords(strArray);
        //step 3: clean spaces
        return  cleanSpaces(strArray);
    }

    private String cleanSpaces(char[] myArray){
        int left = 0;
        int right = 0;
        while(right < myArray.length){
            while(right < myArray.length && myArray[right] == ' ')right++;

            while(right < myArray.length && myArray[right] != ' '){
                myArray[left] = myArray[right];
                left++;
                right++;
            }

            while(right < myArray.length && myArray[right] == ' ')right++;
            if(right < myArray.length){
                myArray[left] = ' ';
                left++;
            }
        }
        return new String(myArray).substring(0, left);
    }
    private void reverseWords(char[] myArray) {
        int left = 0;
        int right = 0;
        while (left < myArray.length) {
            while(left < myArray.length && myArray[left] == ' ' ) left++;
            right = left;
            while(right < myArray.length && myArray[right] != ' ')right++;
            reverse(myArray, left, right-1);
            left = right;
        }
    }

    private void reverse(char[] myArray, int start, int end) {
        while (start < end) {
            char tmp = myArray[start];
            myArray[start] = myArray[end];
            myArray[end] = tmp;
            start++;
            end--;
        }
    }


}