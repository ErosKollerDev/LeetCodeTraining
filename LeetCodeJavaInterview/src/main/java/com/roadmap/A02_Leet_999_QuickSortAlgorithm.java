package com.roadmap;

import java.util.Random;

import static com.util.PrintHelper.printArray;

public class A02_Leet_999_QuickSortAlgorithm {
    public static void main(String[] args) {
        A02_Leet_999_QuickSortAlgorithm quickSort = new A02_Leet_999_QuickSortAlgorithm();
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
    private void quickSort(int[] arr) {
        this.quickSort(arr, 0, arr.length - 1);
    }

    //quickSort(arr, int lowIndex, int highIndex ** int partition(arr,int lowIndex , int highIndex
    private void quickSort(int[] arr, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) return;
        int leftPointer = lowIndex, rightPointer = highIndex, pivot = arr[highIndex];

        while (leftPointer < rightPointer) {

            while (arr[leftPointer] <= pivot && leftPointer < rightPointer) leftPointer++;
            while (arr[rightPointer] >= pivot && leftPointer < rightPointer) rightPointer--;
            this.swap(arr, leftPointer, rightPointer);

        }

        swap(arr, leftPointer, highIndex);
        quickSort(arr, lowIndex, leftPointer - 1);
        quickSort(arr, leftPointer + 1, highIndex);

    }

    //swap(arr, int i, int j)
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}