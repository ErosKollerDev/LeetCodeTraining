package com.leetcode;

import java.util.*;

/**
 * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 * Example 2:
 * <p>
 * Input: nums = [1,1]
 * Output: [2]
 */
public class Leet_039_FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        Leet_039_FindAllNumbersDisappearedInAnArray leet = new Leet_039_FindAllNumbersDisappearedInAnArray();
        leet.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
//        leet.findDisappearedNumbers(new int[]{1,1});
    }


    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> solution = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) -1;
            if(nums[index] > 0){
                nums[index] = nums[index] * -1;
            }
        }
        for(int j = 0;  j < nums.length; j ++){
            if(nums[j] > 0){
                solution.add(j+1);
            }
        }
        return solution;
    }//TC: O(n) SC: O(1)

    public List<Integer> findDisappearedNumbersNotGood(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> solution = new ArrayList<>();
        int min = 0;
        int max = 0;
        for (int i = 0; i <= nums.length - 1; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
            set.add(nums[i]);

        }
        for (int j = min + 1; j < max; j++) {
            if (!set.contains(j)) {
                solution.add(j);
            }
        }
        return solution;
    }
}