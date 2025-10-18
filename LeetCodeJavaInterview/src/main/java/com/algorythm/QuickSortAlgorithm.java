package com.algorythm;

import static com.util.PrintHelper.printArray;
//https://www.youtube.com/watch?v=h8eyY7dIiN4&t=931s&ab_channel=CodingwithJohn
public class QuickSortAlgorithm {
    public static void main(String[] args) {
        QuickSortAlgorithm quickSort = new QuickSortAlgorithm();
        int[] nums = new int[]{2, 4, 1, 3, 6, 5};
        quickSort.quickSort(nums);
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
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (pivot > arr[j]) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}