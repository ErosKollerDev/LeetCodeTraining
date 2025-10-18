package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Note that you must do this in-place without making a copy of the array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 * <p>
 * Input: nums = [0]
 * Output: [0]
 */
public class Leet_028_MoveZeroes {
    public static void main(String[] args) {
        Leet_028_MoveZeroes leet = new Leet_028_MoveZeroes();

    }


    public void moveZeroes(int[] nums) {
        if (nums.length == 1) return;

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                q.add(nums[i]);
        }
        int index = 0;
        while (q.size() != 0) {
            nums[index] = q.poll();
            index++;
        }
        for(int i = index; i < nums.length; i ++){
            nums[i] = 0;
        }
    }
}