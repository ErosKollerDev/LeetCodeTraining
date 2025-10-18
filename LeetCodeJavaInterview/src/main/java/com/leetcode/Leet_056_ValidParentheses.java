package com.leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * <p>
 * <p>
 * Example 1:
 * Input: s = "()"
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: s = "()[]{}"
 * <p>
 * Output: true
 * <p>
 * Example 3:
 * <p>
 * Input: s = "(]"
 * <p>
 * Output: false
 * <p>
 * Example 4:
 * <p>
 * Input: s = "([])"
 * <p>
 * Output: true
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */
public class Leet_056_ValidParentheses {
    public static void main(String[] args) {
        Leet_056_ValidParentheses leet = new Leet_056_ValidParentheses();
//        System.out.println(leet.isValid("()"));//true
//        System.out.println(leet.isValid("()[]{}"));//true
//        System.out.println(leet.isValid("([])"));//true
//        System.out.println(leet.isValid("()[]{}"));//true
        System.out.println(leet.isValid("(]"));//false
    }

    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (map.containsKey(c)) {
                char pop = stack.size() != 0 ? stack.pop() : '%';
                if (pop != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.size() == 0 ? true : false;
    }
}