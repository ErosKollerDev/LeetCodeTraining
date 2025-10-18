package com.leetcode;

import java.util.Random;

public class Leet_069_QuickSortAlgorithmV2 {
    public static void main(String[] args) {
        Random r = new Random();
        int size = 300000;
        int[] nums = new int[size];//{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        for (int i = 0; i < nums.length; i++) {
            nums[i] = r.nextInt(100000);
        }
        System.out.println("Before");
//        printArray(nums);
        quickSort(nums);
        System.out.println("After");
        printArray(nums);
    }

    static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    //https://www.youtube.com/watch?v=h8eyY7dIiN4&t=1214s&ab_channel=CodingwithJohn
    static void quickSort(int[] nums, int lowIndex, int highIndex) {
        //Nothing to do
        if (lowIndex >= highIndex) return;
        //Choose a pivot element from array
        int pivot = nums[highIndex];
        //Create leftPointer
        int leftPointer = lowIndex;
        //Create rightPointer
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) {
            //Loop forward until find pivot or hit rightPointer
            while (nums[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            //Loop backwards until find pivot or hit leftPointer
            while (nums[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(nums, leftPointer, rightPointer);
        }
        swap(nums, leftPointer, highIndex);

        quickSort(nums, lowIndex, leftPointer - 1);

        quickSort(nums, leftPointer + 1, highIndex);
    }

    private static void swap(int[] nums, int leftPointer, int rightPointer) {
        int tmp = nums[leftPointer]; //6
        nums[leftPointer] = nums[rightPointer];//2
        nums[rightPointer] = tmp;//6
    }


    private static void printArray(int[] arr) {
        for (int n : arr) System.out.print(n + " ");
        System.out.println();
    }

}