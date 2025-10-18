package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * <p>
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Can you solve it without sorting?
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * Example 2:
 * <p>
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= k <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
//https://www.youtube.com/watch?v=HNUwChtLkHo&ab_channel=TeddySmith
//https://leetcode.com/problems/kth-largest-element-in-an-array/description/
public class Leet_070_KthLargestElementInAnArray {
    public static void main(String[] args) {
        Leet_070_KthLargestElementInAnArray leet = new Leet_070_KthLargestElementInAnArray();
        Random r = new Random();
        int size = 300;
        int[] nums = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = r.nextInt(100);
//        }
        System.out.println(leet.findKthLargest(nums, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int n : nums) {
            list.add(n);
        }
        return quickSelect(list, k);
    }

    private int quickSelect(List<Integer> list, int k) {
        if (list.size() == 1) return list.get(0);
        int pivotIndex = new Random().nextInt(list.size() - 1);
        int pivot = list.get(pivotIndex);
        List<Integer> less = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        for (int n : list) {
            if (n < pivot) {
                less.add(n);
            } else if (n > pivot) {
                greater.add(n);
            } else {
                equal.add(n);
            }
        }
        if (k <= greater.size()) {
            return quickSelect(greater, k);
        }
        if (greater.size() + equal.size() < k) {
            return quickSelect(less, k - greater.size() - equal.size());
        }
        return pivot;
    }
}