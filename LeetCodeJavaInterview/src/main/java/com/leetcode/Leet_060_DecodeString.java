package com.leetcode;

import java.util.Stack;

/**
 * Given an encoded string, return its decoded string.
 * <p>
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * <p>
 * You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
 * <p>
 * The test cases are generated so that the length of the output will never exceed 105.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 * <p>
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 * <p>
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 30
 * s consists of lowercase English letters, digits, and square brackets '[]'.
 * s is guaranteed to be a valid input.
 * All the integers in s are in the range [1, 300].
 */
public class Leet_060_DecodeString {
    public static void main(String[] args) {
        Leet_060_DecodeString leet = new Leet_060_DecodeString();
        System.out.println(leet.decodeString("3[a]2[bc]"));//aaabcbc
        System.out.println(leet.decodeString("3[a2[c]]"));//accaccacc
        System.out.println(leet.decodeString("2[abc]3[cd]ef"));//abcabccdcdcdef
    }
//TODO review Decode String algorithm
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack();
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char current = s.charAt(i);
            if (Character.isDigit(current)) {
                int num = current - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                numStack.push(num);
            } else if (current == '[') {
                strStack.push(sb.toString());
                sb = new StringBuilder();

            } else if (current == ']') {
                int k = numStack.pop();
                StringBuilder tmp = new StringBuilder(strStack.pop());
                for (int j = 0; j < k; j++) {
                    tmp.append(sb);
                }
                sb = tmp;
            } else {
                sb.append(current);
            }
        }
        return sb.toString();
    }
}//TC: O(n * k), SC: O(n)