package com.leetcode;

/**
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 * <p>
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 */
public class Leet_036_RotateArray {
    public static void main(String[] args) {
        Leet_036_RotateArray leet = new Leet_036_RotateArray();
        leet.rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }

    public void rotate(int[] nums, int k) {
        if (nums.length == 0) return;
        k = k > nums.length ? k % nums.length : k;
        int i = 0;
        while (i < k) {
            int right = nums[nums.length - 1];
            for (int y = nums.length - 1; y > 0; y--) {
                nums[y] = nums[y - 1];
            }
            nums[0] = right;
            i++;
        }
    }

}