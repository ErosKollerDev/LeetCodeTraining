package com.roadmap;

import com.util.PrintHelper;

public class A25_Leet_283_MovingZerosToEnd {
    public static void main(String[] args) {
        A25_Leet_283_MovingZerosToEnd leet = new A25_Leet_283_MovingZerosToEnd();
        int[] nums = {0, 1, 0, 3, 12};
//        int[] position = new int[nums.length];
        //[1, 3, 12, 0, 0]
        int position = 0;

        for (int i = 0; i < nums.length; i++) {
            var n = nums[i];
            if (n != 0) {
                swap(nums, i, position);
                position++;
            }
        }
        PrintHelper.printArray(nums);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}