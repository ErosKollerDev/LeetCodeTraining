package com.algorythm;

import java.util.Random;

import static com.util.PrintHelper.printArray;

public class QuickSortAlgorithmVanila {
    public static void main(String[] args) {
        QuickSortAlgorithmVanila quickSort = new QuickSortAlgorithmVanila();
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
    //quickSort(arr, int low, int high
    //int partition(arr,int low , int high
    //swap(arr, int i, int j)

    private void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int pivot = arr[high];
        int leftPointer = low;
        int righPointer = high;
        while (leftPointer < righPointer) {
            while (arr[leftPointer] <= pivot && leftPointer < righPointer) {
                leftPointer++;
            }
            while (arr[righPointer] >= pivot && leftPointer < righPointer) {
                righPointer--;
            }
            swap(arr, leftPointer, righPointer);
        }
        swap(arr, leftPointer, high);
        quickSort(arr, low, leftPointer - 1);
        quickSort(arr, leftPointer + 1, high);
    }


    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}