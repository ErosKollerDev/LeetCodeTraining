package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1]
 * <p>
 * Output: true
 * <p>
 * Explanation:
 * <p>
 * The element 1 occurs at the indices 0 and 3.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1,2,3,4]
 * <p>
 * Output: false
 * <p>
 * Explanation:
 * <p>
 * All elements are distinct.
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * <p>
 * Output: true
 */
public class Leet_032_ContainsDuplicate {
    public static void main(String[] args) {
        Leet_032_ContainsDuplicate leet = new Leet_032_ContainsDuplicate();
//        System.out.println(leet.containsDuplicate(new int[]{1,2,3,1}));
//        System.out.println(leet.containsDuplicate(new int[]{1,2,3,4}));
//        System.out.println(leet.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
//        System.out.println(leet.containsDuplicate(new int[]{1000000000,1000000000,11}));
//        System.out.println(leet.containsDuplicate(new int[]{1000000000,100000000,11,9,1000000000}));
        System.out.println(leet.containsDuplicate(new int[]{1,5,-2,-4,0}));
    }

    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 1) return false;
        Set<Integer> setInt = new HashSet<>();
        int left = 0;
        int right = nums.length -1;


        while(left <= right) {
            int lToTest = nums[left];
            int rToTest = nums[right];
            if(setInt.contains(lToTest)){
                return  true;
            }else{
                setInt.add(lToTest);
            }
            if(left < right && setInt.contains(rToTest)){
                return  true;
            }else{
                setInt.add(rToTest);
            }
            left++;
            right--;
        }
        return false;
    }
}