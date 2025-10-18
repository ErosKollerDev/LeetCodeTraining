package com.leetcode;

public class Leet_069_QuickSortAlgorithm {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 1, 3, 6, 5};
        Leet_069_QuickSortAlgorithm.quickSort(nums, 0, nums.length - 1);
        for (int n : nums) System.out.println(n);
    }
    //TODO quick sort, practice
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);//left partition (high)-> length -1 for the left partition
            quickSort(arr, pi + 1, high);//right partition (low)-> pi + 1 to skip the last position of the left partition
        }
    }

    static int partition(int[] arr, int low, int high) {
        int i = low - 1;
        int pivot = arr[high];
        for (int j = low; j < high; j++) {
            if (pivot > arr[j]) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}