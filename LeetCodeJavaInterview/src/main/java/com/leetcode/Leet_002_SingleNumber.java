package com.leetcode;
/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,2,1]
 *
 * Output: 1
 *
 * Example 2:
 *
 * Input: nums = [4,1,2,1,2]
 *
 * Output: 4
 *
 * Example 3:
 *
 * Input: nums = [1]
 *
 * Output: 1
 */
public class Leet_002_SingleNumber {

    public static void main(String[] args) {

//        int i = Leet_902_SingleNumber.singleNumber(new int[]{2, 2, 1});
        int i = Leet_002_SingleNumber.singleNumber(new int[]{4,1,2,1,3,2,4,9,9});
        System.out.println(i);
        System.out.println("-----------------");
    }

    public static int singleNumber(int[] nums) {

        if (nums.length == 1) return nums[0];

        int singleNumbrer = 0;
        for (int num : nums) {
            //TODO: master XOR operator
            singleNumbrer = singleNumbrer ^ num;
        }
        return singleNumbrer;

//        Set<Integer> mySet = new HashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (mySet.contains(nums[i])) {
//                int toRemove = nums[i];
//                mySet.remove(nums[i]);
//            } else {
//                int toAdd = nums[i];
//                mySet.add(nums[i]);
//            }
//        }
//        int toSentBack = mySet.iterator().next();
//        return toSentBack;
    }

} //TC: 0(n) (Time Complexity | SC: 0(n) (Space Complexity) )
