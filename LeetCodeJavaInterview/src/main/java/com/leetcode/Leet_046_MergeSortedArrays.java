package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet_046_MergeSortedArrays {
    public static void main(String[] args) {


        Leet_046_MergeSortedArrays leet = new Leet_046_MergeSortedArrays();
        leet.merge(new int[] {1,2,3,0,0,0} ,  3, new int[] {2,5,6},  3);
//        List<Integer> merge = leet.merge(Arrays.asList(4, 7, 9), Arrays.asList(2, 5, 6));
//        merge.stream().forEach(System.out::println);

//        merge = leet.merge(Arrays.asList(1, 1, 2, 4), Arrays.asList(2, 5, 6));
//        merge.stream().forEach(System.out::print);
    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] mergedList = new int[m + n];
        int i = 0, j = 0, x = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                mergedList[x] = nums1[i];
                i++;
            } else {
                mergedList[x] = nums2[j];
                j++;
            }
            x++;
        }
        while (i < m) {
            mergedList[x] = nums1[i];
            i++;
            x++;
        }
        while (j < n) {
            mergedList[x] = nums2[j];
            j++;
            x++;
        }
        for(int y = 0; y < mergedList.length; y++){
            nums1[y] = mergedList[y];
        }

    }


}