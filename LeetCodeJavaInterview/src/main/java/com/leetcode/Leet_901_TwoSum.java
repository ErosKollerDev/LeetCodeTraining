package com.leetcode;

import com.util.PrintHelper.*;

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
public class Leet_901_TwoSum {

    public static void main(String[] args) {
        Leet_901_TwoSum leet = new Leet_901_TwoSum();
        int[] ints = leet.twoSum(new int[]{2, 7, 11, 15}, 9);
//        int[] ints = leet.twoSum(new int[]{3, 2, 4}, 6);
//        int[] ints = leet.twoSum(new int[]{0,4,3,0}, 0);
//        int[] ints = leet.twoSum(new int[]{0, 3, -3, 4, -1}, -1);
        printArray(ints);
    }

    //TODO  TwoSum should be optimized
    public int[] twoSum(int[] nums, int target) {

        int x = 0;
        int y = 0;
        boolean keepRunning = true;
        while (keepRunning) {
            int sum = -1;

            for (int i = (x + 1); i < nums.length && target != sum; i++) {
                y = i;
                sum = nums[x] + nums[y];
            }
            if (sum == target) {
                keepRunning = false;
            } else {
                x++;
            }
        }

        return new int[]{x, y};
    }


} //TC: 0(n) (Time Complexity | SC: 0(n) (Space Complexity) )
