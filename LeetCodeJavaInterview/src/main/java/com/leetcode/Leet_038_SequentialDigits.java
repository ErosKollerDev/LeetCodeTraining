package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
 * <p>
 * Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: low = 100, high = 300
 * Output: [123,234]
 * Example 2:
 * <p>
 * Input: low = 1000, high = 13000
 * Output: [1234,2345,3456,4567,5678,6789,12345]
 */
public class Leet_038_SequentialDigits {
    public static void main(String[] args) {
        Leet_038_SequentialDigits leet = new Leet_038_SequentialDigits();
        leet.sequentialDigits(10, 30);
    }

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        String strMax = "123456789";
        for (int i = 1; i <= 9; i++) {
            for (int j = 0; i + j <= 9; j++) {
                String tmp = strMax.substring(j, i + j);
                int val = Integer.valueOf(tmp);
                if (val >= low && val <= high) {
                    ans.add(val);
                }else if(val > high){
                    return ans;
                }
            }
        }
        return ans;
    }//TC O(1)

}