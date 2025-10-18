package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears at most twice, return an array of all the integers that appears twice.
 * <p>
 * You must write an algorithm that runs in O(n) time and uses only constant auxiliary space, excluding the space needed to store the output
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [2,3]
 * Example 2:
 * <p>
 * Input: nums = [1,1,2]
 * Output: [1]
 * Example 3:
 * <p>
 * Input: nums = [1]
 * Output: []
 */
public class Leet_040_FindAllDuplicatesInAnArray {
    public static void main(String[] args) {
        Leet_040_FindAllDuplicatesInAnArray leet = new Leet_040_FindAllDuplicatesInAnArray();
//        leet.findDuplicates(new int[]{4,3,2,7,8,2,3,1});
        leet.findDuplicates(new int[]{10, 2, 5, 10, 9, 1, 1, 4, 3, 7});
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> sol = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                sol.add(Math.abs(nums[i]));
            } else {
                nums[index] = nums[index] * -1;
            }
            int t = 0;
        }
        return sol;
    }
}