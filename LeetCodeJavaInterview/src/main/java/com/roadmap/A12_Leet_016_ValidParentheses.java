package com.roadmap;

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
public class A12_Leet_016_ValidParentheses {
    public static void main(String[] args) {
        A12_Leet_016_ValidParentheses leet = new A12_Leet_016_ValidParentheses();
        System.out.println(leet.isValid("({[]})"));//true
//        System.out.println(leet.isValid("()"));//true
//        System.out.println(leet.isValid("()[]{}"));//true
//        System.out.println(leet.isValid("([])"));//true
//        System.out.println(leet.isValid("()[]{}"));//true
//        System.out.println(leet.isValid("(]"));//false
//        System.out.println(leet.isValid("({[]})[]{}"));//true
    }

    private boolean isValid(String str) {
        var closingSymbolMap = new HashMap<Character, Character>();
        closingSymbolMap.put(')', '(');
        closingSymbolMap.put('}','{');
        closingSymbolMap.put(']','[');
        var openingSymbolStack = new Stack<Character>(   );
        var chars = str.toCharArray()   ;
        for(Character current : chars){
            //There is a closing symbol like this ?
            if(closingSymbolMap.containsKey(current)){
                //Pop the opening symbol
                char popChar = !openingSymbolStack.isEmpty()? openingSymbolStack.pop() : '$';
                //popChar should be equals to the value of key closing from map
                if(popChar != closingSymbolMap.get(current)){
                    return false;
                }
            }else{
                //Insert the opening symbol
                openingSymbolStack.push(current);
            }
        }
        return openingSymbolStack.isEmpty()  ;
    }


}