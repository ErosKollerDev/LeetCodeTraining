package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.util.PrintHelper.printArray;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 * <p>
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 * <p>
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */
public class Leet_027_TwoSum {

    public static void main(String[] args) {
        Leet_027_TwoSum leet = new Leet_027_TwoSum();
        int[] ints = leet.twoSum(new int[]{2, 7, 11, 15}, 9);


        ints = leet.twoSum(new int[]{3, 2, 4}, 6);
        printArray(ints);

//        int[] ints = leet.twoSum(new int[]{3, 2, 4}, 6);
//        int[] ints = leet.twoSum(new int[]{0,4,3,0}, 0);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                ans[0] = map.get(diff);
                ans[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return ans;
    }


} //TC: 0(n) (Time Complexity | SC: 0(n) (Space Complexity) )
