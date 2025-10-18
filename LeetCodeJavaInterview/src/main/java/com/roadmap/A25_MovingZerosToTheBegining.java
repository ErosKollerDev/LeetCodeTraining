package com.roadmap;

import com.util.PrintHelper;

public class A25_MovingZerosToTheBegining {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
//        int[] position = new int[nums.length];
        //[1, 3, 12, 0, 0]
        int position = nums.length -1;

        for (int i = nums.length -1 ; i >  0; i--) {
            var n = nums[i];
            if (n != 0) {
                swap(nums, position, i);
                position--;
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