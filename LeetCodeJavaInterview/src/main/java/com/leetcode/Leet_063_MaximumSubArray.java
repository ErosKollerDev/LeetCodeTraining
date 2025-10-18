package com.leetcode;

/**
 * Given an integer array nums, find the
 * subarray
 * with the largest sum, and return its sum.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 * Example 2:
 * <p>
 * Input: nums = [1]
 * Output: 1
 * Explanation: The subarray [1] has the largest sum 1.
 * Example 3:
 * <p>
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * <p>
 * <p>
 * Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class Leet_063_MaximumSubArray {
    public static void main(String[] args) {
        Leet_063_MaximumSubArray leet = new Leet_063_MaximumSubArray();
        System.out.println(leet.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));//6
    }

    public int maxSubArray(int[] nums) {
        int current = nums[0];
        int maxSubArray = 0;
        //[-2,1,-3,4,-1,2,1,-5,4]
        for (int index = 1; index < nums.length; index++) {
            int loopCurrent = nums[index];
            current = Math.max(loopCurrent, loopCurrent + current);
            maxSubArray = Math.max(current, maxSubArray);
        }
        return maxSubArray;
    }

}