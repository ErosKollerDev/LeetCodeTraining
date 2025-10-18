package com.interview;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Interview_001_BigO {

    private void printItems(int n) {
        for (int i = 0; i < n; i++) {
            for (int y = 0; y < n; y++) {
                System.out.println(i + " " + y);
            }
        }

        for (int y = 0; y < n; y++) {
            System.out.println(y);
        }
    } //TC: O(n^2 + n), SC: O(n)

    private void printItemsV2(int a, int b) {
        for (int y = 0; y < a; y++) {
            System.out.println(a);
        }
        for (int y = 0; y < b; y++) {
            System.out.println(y);
        }
    }//TC: O(n + n)


    private int findTargetO_Of_N(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) return nums[middle];
            if (target > nums[middle]) left = middle + 1;
            if (target < nums[middle]) right = middle - 1;
        }
        return -1;
    }//TC: O(log n) : Obs -> Divide and Conquer


    private void addingToList(int a) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
        list.add(a);
        //O(1) Obs: Just one operation, no re-indexes needed, just add item to the end
        list.remove(list.size() - 1);
        //O(1) Obs: Just one operation, no re-indexes needed, just remove the last item from the end
        list.add(0, a);
        //O(n) Obs: N Numbers of operations depends on the size of the list, in this case, all items, must be re-indexes once we append the new item at the beginning
        list.remove(0);
        //O(n) Obs: N Numbers of operations depends on the size of the list, in this case, all items, must be re-indexes once we append the new item at the beginning
        int index = 0;
        list.get(index);
        // O(1) Obs: Just one operation was needed to get the item at the index.
        List<Integer> list1 = list.stream().filter(i -> i == a).toList();
        //O(n) Obs: N Numbers of operations depends on the size of the list, in this case, all items, must be evaluated in order to find the item

    }//O(n + n)


    private int findTarget(int[] nums, int target) {
        if (nums.length == 0) return -1;
        for (int left = 0, rigth = nums.length - 1; left <= rigth; ) {
            int middle = left + (rigth - left) / 2;
            if (nums[middle] == target) return nums[middle];
            if (target < nums[middle]) rigth = middle - 1;
            if (target > nums[middle]) left = middle + 1;
        }
        return -1;
    }


    public static void main(String[] args) {
        Interview_001_BigO inter = new Interview_001_BigO();
//        inter.printItems(5);
        int[] array = new int[101];
        for (int i = 0; i < array.length; i++) array[i] = i;

        System.out.println(inter.findTarget(array, 2));

    }

}
//TC: O(n^2 + n) or O(n^2 + n) (Time Complexity
// SC: 0(n) (Space Complexity) )