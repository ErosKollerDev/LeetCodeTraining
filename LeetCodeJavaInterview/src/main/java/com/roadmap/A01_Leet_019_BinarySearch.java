package com.roadmap;

import java.util.Arrays;

public class A01_Leet_019_BinarySearch {

    public static void main(String[] args) {
        A01_Leet_019_BinarySearch bs = new A01_Leet_019_BinarySearch();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(bs.search(nums, 3));
        System.out.println(Arrays.binarySearch(nums, 3));
    }


    private int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) return middle;
            if (target < nums[middle]) right = middle - 1;
            else left = middle + 1;
        }
        return -1;
    }
}
