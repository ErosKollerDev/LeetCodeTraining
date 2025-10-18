package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 *
 *
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 */
public class Leet_065_MajorityElement {
    public static void main(String[] args) {
        Leet_065_MajorityElement leet = new Leet_065_MajorityElement();
//        System.out.println(leet.majorityElement(new int[]{3,2,3}));
        System.out.println(leet.majorityElement(new int[]{2,2,1,1,1,2,2}));//2
        System.out.println(leet.majorityElement(new int[]{3,2,3}));//3
    }
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int index = 0; index < nums.length ; index ++){
            if(map.containsKey(nums[index])){
                int newValue = map.getOrDefault(nums[index], 0)+ 1;
                map.put(nums[index], newValue);
            }else{
                map.put(nums[index], 1);
            }
        }
        int majority =  (int)  Math.floor(nums.length / 2)  ;
        int key = 0;
        int lastBigger = 0;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){

            key =   entry.getValue() > lastBigger ? entry.getKey() : key;
            lastBigger = Math.max(lastBigger, entry.getValue());
        }
        return lastBigger >= majority ? key : 0;
    }
}