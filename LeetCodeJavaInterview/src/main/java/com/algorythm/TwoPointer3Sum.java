package com.algorythm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPointer3Sum {
    public static void main(String[] args) {
        TwoPointer3Sum leet = new TwoPointer3Sum();
        System.out.println(leet.threeSum(new int[]{-1,0,1,2,-1,-4}, 0));

    }


    private List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) return result;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            //Skip duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //Skip duplicates for left
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    //Skip duplicates for right
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left ++;
                    right --;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}