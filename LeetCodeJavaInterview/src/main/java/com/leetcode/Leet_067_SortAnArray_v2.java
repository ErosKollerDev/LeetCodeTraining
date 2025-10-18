package com.leetcode;

/**
 * Given an array of integers nums, sort the array in ascending order and return it.
 * <p>
 * You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [5,2,3,1]
 * Output: [1,2,3,5]
 * Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).
 * Example 2:
 * <p>
 * Input: nums = [5,1,1,2,0,0]
 * Output: [0,0,1,1,2,5]
 * Explanation: Note that the values of nums are not necessairly unique.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 5 * 104
 * -5 * 104 <= nums[i] <= 5 * 104
 */
public class Leet_067_SortAnArray_v2 {
    public static void main(String[] args) {
        Leet_067_SortAnArray_v2 leet = new Leet_067_SortAnArray_v2();
        int[] sorted = leet.sortArray(new int[]{5, 2, 3, 1,7, 9, 4});

    }

    private void merge(int[] nums, int left, int mid, int right) {
        int leftSize = mid - left + 1;
        int rightSize = right - mid;
        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];
        for (int i = 0; i < leftSize; i++) {
            leftArray[i] = nums[left + i];
        }
        for (int y = 0; y < rightSize; y++) {
            rightArray[y] = nums[mid + y + 1];
        }

        int i = 0, j = 0, k = left;
        //Sort until one of the conditions becane false
        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) {
                nums[k] = leftArray[i];
                i++;
                k++;
            } else {
                nums[k] = rightArray[j];
                j++;
                k++;
            }
        }
        while (i < leftSize) nums[k++] = leftArray[i++];
        while (j < rightSize) nums[k++] = rightArray[j++];

    }

    //Divide by two pointer, call itself two times and then merge
    private void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }


    private int[] sortArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        mergeSort(nums, left, right);
        return nums;
    }


}