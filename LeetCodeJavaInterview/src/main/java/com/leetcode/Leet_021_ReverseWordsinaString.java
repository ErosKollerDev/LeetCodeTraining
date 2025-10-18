package com.leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Leet_021_ReverseWordsinaString {
    public static void main(String[] args) {
        Leet_021_ReverseWordsinaString leet = new Leet_021_ReverseWordsinaString();
        System.out.println(leet.reverseWords("the sky is blue"));
    }


    public String reverseWords(String s) {
        String[] split = s.split(" ");
        List<String> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(String ss : split){
            if(!ss.trim().isEmpty()){
                list.add(ss.trim());
            }
        }
        Collections.reverse(list);
        for(int i = 0; i < list.size(); i ++){
            sb.append(list.get(i));
            sb.append(" ");
        }
        return sb.toString().trim();
    }

}