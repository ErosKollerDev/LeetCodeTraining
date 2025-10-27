package com.roadmap;

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * <p>
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,2,1]
 * <p>
 * Output: 1
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [4,1,2,1,2]
 * <p>
 * Output: 4
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [1]
 * <p>
 * Output: 1
 */
public class A19_Leet_002_SingleNumber_training {

    public static void main(String[] args) {

//        int i = Leet_902_SingleNumber.singleNumber(new int[]{2, 2, 1});

//b = 3 ^ 5
//
//#b   8 4 2 1
//#5   0 1 0 1
//#3   0 0 1 1
//#6   0 1 1 0

        int i = A19_Leet_002_SingleNumber_training.singleNumber(new int[]{4, 1, 2, 1, 3, 2, 4, 9, 9});
        System.out.println(i);
        System.out.println("-----------------");
        i = A19_Leet_002_SingleNumber_training.singleNumber(new int[]{4, 1, 2, 1, 7, 2, 7, 9, 9});
        System.out.println(i);
        System.out.println("-----------------");
    }

    public static int singleNumber(int[] nums) {
        if(nums.length == 1)return nums[0];
        var sn = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sn = sn ^ nums[i];
        }
        return sn;
    }

} //TC: 0(n) (Time Complexity | SC: 0(n) (Space Complexity) )
