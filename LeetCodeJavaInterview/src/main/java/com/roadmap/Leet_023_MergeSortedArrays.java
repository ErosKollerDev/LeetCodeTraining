package com.roadmap;

import com.util.PrintHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet_023_MergeSortedArrays {
    public static void main(String[] args) {


        Leet_023_MergeSortedArrays leet = new Leet_023_MergeSortedArrays();
        List<Integer> merge = leet.merge(Arrays.asList(4, 7, 9), Arrays.asList(2, 5, 6));
//        merge.stream().forEach(System.out::println);

        merge = leet.merge(Arrays.asList(1, 1, 2, 4), Arrays.asList(2, 5, 6));
//        merge.stream().forEach(System.out::print);
        PrintHelper.printArray(merge);
    }


    public List<Integer> merge(List<Integer> nums1, List<Integer> nums2) {


        List<Integer> mergedList = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.size() && j < nums2.size()) {
            if (nums1.get(i) <= nums2.get(j)) {
                mergedList.add(nums1.get(i));
                i++;
            } else {
                mergedList.add(nums2.get(j));
                j++;
            }
        }
        while (i < nums1.size()) {
            mergedList.add(nums1.get(i));
            i++;
        }
        while (j < nums2.size()) {
            mergedList.add(nums2.get(j));
            j++;
        }

        return mergedList;


    }


}