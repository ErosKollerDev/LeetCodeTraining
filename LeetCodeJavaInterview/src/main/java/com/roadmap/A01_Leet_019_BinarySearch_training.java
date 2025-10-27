package com.roadmap;

import java.util.Arrays;

public class A01_Leet_019_BinarySearch_training {

    public static void main(String[] args) {
        A01_Leet_019_BinarySearch_training bs = new A01_Leet_019_BinarySearch_training();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(bs.search(nums, 3));
        System.out.println(Arrays.binarySearch(nums, 3));
    }


    private int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            var middle = left + (right - left) / 2;
            if (nums[middle] == target) return middle;
            if (target > nums[middle]) left = middle + 1;
            else right = middle - 1;
        }
        return -1;
    }
}
