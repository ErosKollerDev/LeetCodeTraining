package com.leetcode;

/**
 * Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [10,5,2,6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are:
 * [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 * Example 2:
 * <p>
 * Input: nums = [1,2,3], k = 0
 * Output: 0
 */
public class Leet_044_SubArrayProductLessThanK {
    public static void main(String[] args) {
        Leet_044_SubArrayProductLessThanK leet = new Leet_044_SubArrayProductLessThanK();
        System.out.println(leet.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
//        System.out.println(leet.numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0));
    }
//1 , 2 , 3 | 10
    //TODO check this out ...
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int prod = 1, count = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (left <= right && prod >= k) {
                prod /= nums[left];
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }//TC: O(n) SC: O(1)

}