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
public class Leet_029_MoveZeroes {
    public static void main(String[] args) {
        Leet_029_MoveZeroes leet = new Leet_029_MoveZeroes();

    }


    public void moveZeroes(int[] nums) {
        if (nums.length == 1) return;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if(nums[right] != 0){
                nums[left] = nums[right];
                left++;
            }
        }
        for(int i = left; i < nums.length; i ++){
            nums[i] = 0;
        }
    }
}