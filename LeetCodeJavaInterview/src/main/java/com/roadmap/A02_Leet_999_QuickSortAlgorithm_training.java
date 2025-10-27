package com.roadmap;

import java.util.Random;

import static com.util.PrintHelper.printArray;

public class A02_Leet_999_QuickSortAlgorithm_training {
    public static void main(String[] args) {
        A02_Leet_999_QuickSortAlgorithm_training quickSort = new A02_Leet_999_QuickSortAlgorithm_training();
        Random r = new Random();
        int[] nums = new int[30];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = r.nextInt(100);
        }
        System.out.println("Before");
        printArray(nums);
        quickSort.quickSort(nums);
        System.out.println("After");
        printArray(nums);
    }

    //quickSort(arr)
    private void quickSort(int[] nums) {
        this.quickSort(nums, 0, nums.length - 1);
    }

    //quickSort(arr, int lowIndex, int highIndex ** int partition(arr,int lowIndex , int highIndex
    private void quickSort(int[] nums, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) return;
        int left = lowIndex, right = highIndex, pivot = nums[highIndex];
        while (left < right) {
            while (nums[left] <= pivot && left < right) left++;
            while (nums[right] >= pivot && left < right) right--;
            swap(nums, left, right);
        }
        swap(nums, left, highIndex);
        quickSort(nums, lowIndex, left - 1);
        quickSort(nums, left + 1, highIndex);
    }

    //swap(arr, int i, int j)
    private void swap(int[] arr, int i, int j) {
        var tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}