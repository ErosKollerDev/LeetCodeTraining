package com.practicing01;

import java.util.Stack;

public class StackReverseString {
    public static void main(String[] args) {
        StackReverseString srs = new StackReverseString();
        System.out.println(srs.stringReversed("eros koller"));
    }

    private String stringReversed(String word){
        StringBuilder sb = new StringBuilder();
        Stack<Character> stackChars = new Stack<>() ;
        char[] chars = word.toCharArray();
        for(int i = 0; i < chars.length; i++){
            stackChars.push(chars[i]);
        }
        while (!stackChars.isEmpty()){
            sb.append(stackChars.pop());
        }

        return sb.toString();
    }

}
