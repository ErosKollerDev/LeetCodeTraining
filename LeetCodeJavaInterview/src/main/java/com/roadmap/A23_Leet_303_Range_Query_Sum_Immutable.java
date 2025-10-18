package com.roadmap;

/**
 * 303. Range Sum Query - Immutable
 * Easy
 * Topics
 * premium lock icon
 * Companies
 * Given an integer array nums, handle multiple queries of the following type:
 * <p>
 * Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
 * Implement the NumArray class:
 * <p>
 * NumArray(int[] nums) Initializes the object with the integer array nums.
 * int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * Output
 * [null, 1, -1, -3]
 * <p>
 * Explanation
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
 * numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
 * numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 * 0 <= left <= right < nums.length
 * At most 104 calls will be made to sumRange.
 */
public class A23_Leet_303_Range_Query_Sum_Immutable {
    private int[] ints;

    public static void main(String... args) {
        A23_Leet_303_Range_Query_Sum_Immutable leet = new A23_Leet_303_Range_Query_Sum_Immutable(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(leet.sumRange(1, 4));//14
        System.out.println(leet.sumRange(0, 4));//15
        System.out.println(leet.sumRange(3, 8));//39
        System.out.println("-----");
        leet = new A23_Leet_303_Range_Query_Sum_Immutable(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(leet.sumRange(0, 2));//1
        System.out.println(leet.sumRange(2, 5));//-1
        System.out.println(leet.sumRange(0, 5));//-3
    }


    public A23_Leet_303_Range_Query_Sum_Immutable(int[] ints) {
        this.ints = ints;
    }

    public int sumRange(int left, int right) {
        int[] prefixValues = new int[this.ints.length];
        //[1, 2, 3, 4, 5, 6, 7, 8, 9]
        //[1, 3, 6, 10, 15, 21, 28, 36, 45]
        prefixValues[0] = ints[0];
        for (int i = 1; i < ints.length; i++) {
            prefixValues[i] = ints[i] + prefixValues[i - 1];
        }
        return left == 0 ? prefixValues[right] : prefixValues[right] - prefixValues[left - 1];
    }


}