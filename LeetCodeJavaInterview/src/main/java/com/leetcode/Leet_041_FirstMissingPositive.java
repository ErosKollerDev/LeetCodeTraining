package com.leetcode;

/**
 * Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
 * <p>
 * You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,0]
 * Output: 3
 * Explanation: The numbers in the range [1,2] are all in the array.
 * Example 2:
 * <p>
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * Explanation: 1 is in the array but 2 is missing.
 * Example 3:
 * <p>
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 * Explanation: The smallest positive integer 1 is missing.
 */
public class Leet_041_FirstMissingPositive {
    public static void main(String[] args) {
        Leet_041_FirstMissingPositive leet = new Leet_041_FirstMissingPositive();

        System.out.println(leet.firstMissingPositive(new int[]{1, 2, 0}));//3
        System.out.println(leet.firstMissingPositive(new int[]{3,4,-1,1}));//2
        System.out.println(leet.firstMissingPositive(new int[]{7,8,9,11,12}));
    }
//TODO get back to this code for review
    public int firstMissingPositive(int[] nums) {
        //pre-processing the array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = nums.length + 1;
            }
        }
        // marking indexes
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (index < nums.length &&  nums[index] > 0) {
                nums[index] = nums[index] * -1;
            }
        }
        //scan the array to find missing positives
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0){
                return i + 1;
            }
        }
        return nums.length + 1;
    }

}