package com.leetcode;

import java.util.Random;

public class Leet_069_QuickSortAlgorithmV3 {
    public static void main(String[] args) {
        Random r = new Random();
        int[] nums = new int[1000000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = r.nextInt(10000);
        }
        System.out.println("Before");
//        printArray(nums);
        quickSort(nums);
        System.out.println("After");
//        printArray(nums);
    }

    //TODO quick sort, practice
    static void quickSort(int[] arr){
        quickSort(arr, 0, arr.length-1);
    }
    static void quickSort(int[] arr, int lowIndex, int highIndex) {
        if(lowIndex >= highIndex)return;
        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, highIndex);
        int leftPointer = partition(arr, lowIndex, highIndex, pivot);
        //left side of the array  leftPointer at this stage, meet the pivot
        int lastIndexRecursive = leftPointer-1;
        quickSort(arr, lowIndex, lastIndexRecursive);
        // Now, jump one to the right to skip the pivot
        int firstIndexForTheRightArray = leftPointer + 1;
        quickSort(arr, firstIndexForTheRightArray, highIndex);
    }

    private static int partition(int[] arr, int lowIndex, int highIndex, int pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex;
        while (leftPointer < rightPointer) {
            while (arr[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (arr[rightPointer] >= pivot && rightPointer > leftPointer) {
                rightPointer--;
            }
            swap(arr, leftPointer, rightPointer);
        }
        swap(arr, leftPointer, highIndex);
        return leftPointer;
    }

    private static void swap(int[] arr, int indexL, int indexR) {
        int tmp = arr[indexL];
        arr[indexL] = arr[indexR];
        arr[indexR] = tmp;
    }


    static int partition(int[] arr, int low, int high) {

        return 0;
    }

    private static void printArray(int[] arr) {
        for (int n : arr) System.out.print(n+" ");
        System.out.println();
    }

}