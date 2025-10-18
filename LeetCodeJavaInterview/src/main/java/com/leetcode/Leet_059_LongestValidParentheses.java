package com.leetcode;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses
 * substring
 * .
 *
 *
 *
 * Example 1:
 *
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 * Example 2:
 *
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 * Example 3:
 *
 * Input: s = ""
 * Output: 0
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 3 * 104
 * s[i] is '(', or ')'.
 */
public class Leet_059_LongestValidParentheses {
    public static void main(String[] args) {
        Leet_059_LongestValidParentheses leet = new Leet_059_LongestValidParentheses();
        System.out.println(leet.longestValidParentheses("(()"));//2
        System.out.println(leet.longestValidParentheses(")()())"));//4
        System.out.println(leet.longestValidParentheses(""));//0
    }

    public int longestValidParentheses(String s) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>(); // index>
        stack.push(-1);
        for(int i = 0; i < s.length(); i ++){
            char current = s.charAt(i);
            if(current == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.size() == 0){
                    stack.push(i);
                }else{
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }
        return ans;
    }
}