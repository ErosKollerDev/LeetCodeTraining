package com.roadmap;

import javax.xml.stream.events.Characters;
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
public class A12_Leet_016_ValidParentheses_training {
    public static void main(String[] args) {
        A12_Leet_016_ValidParentheses_training leet = new A12_Leet_016_ValidParentheses_training();
        System.out.println(leet.isValid("({[]})"));//true
        System.out.println(leet.isValid("()"));//true
        System.out.println(leet.isValid("()[]{}"));//true
        System.out.println(leet.isValid("([])"));//true
        System.out.println(leet.isValid("()[]{}"));//true
        System.out.println(leet.isValid("(]"));//false
        System.out.println(leet.isValid("({[]})[]{}"));//true
    }

    private boolean isValid(String parentheses) {
        var openingFIFO = new Stack<Character>();
        var map = new HashMap<Character, Character>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');

        char[] charArray = parentheses.toCharArray();
        for (Character c : charArray) {

            if (map.containsKey(c)) {
                var popOut = openingFIFO.isEmpty() ? '%' : openingFIFO.pop();
                if(!map.get(c).equals(popOut)){
                    return false;
                }
            } else {
                openingFIFO.push(c);
            }
        }

        return openingFIFO.isEmpty();
    }


}