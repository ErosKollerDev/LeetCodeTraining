package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array nums of size n, return the majority element.
 * <p>
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 * <p>
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 * <p>
 * <p>
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 */
public class Leet_066_MajorityElement {
    public static void main(String[] args) {
        Leet_066_MajorityElement leet = new Leet_066_MajorityElement();
//        System.out.println(leet.majorityElement(new int[]{3,2,3}));
//        System.out.println(leet.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));//2
//        System.out.println(leet.majorityElement(new int[]{3, 2, 3}));//3
//        System.out.println(leet.majorityElement(new int[]{7,7,5,7,5,1,5,7,5,5,7,7,5,5,5,5,5}));//5
        System.out.println(leet.majorityElement(new int[]{1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6}));//-1
    }

    public int majorityElement(int[] nums) {
        int key = nums[0], count = 1;

        for(int index = 1; index < nums.length; index++){
            if(key == nums[index]){
                count++;
            }else if(key != nums[index] && count > 0){
                count--;
            }else{
                key = nums[index];
                count = 1;
            }
        }

        return  count == 0 ? -1 : key ;
    }
}