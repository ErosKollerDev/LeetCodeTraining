package com.leetcode;

public class Leet_068_CountInvertions {
    public static void main(String[] args) {
        Leet_068_CountInvertions leet = new Leet_068_CountInvertions();

//        System.out.println(leet.countInversions(new int[]{5, 2, 3, 1}));
        System.out.println(leet.countInversions(new int[]{2, 4, 1, 3, 5}));
//        int[] hundred = new int[100];
//        for (int i = 0; i < 100; i++) {
//            hundred[i] = 100 - i;
//        }
//        System.out.println(leet.countInversions(hundred));
    }

    public long merge(int[] nums, int left, int mid, int right) {
        int aSize = mid - left + 1;
        int bSize = right - mid;
        int[] a = new int[aSize];
        int[] b = new int[bSize];
        for (int i = 0; i < aSize; i++) {
            a[i] = nums[left + i];
        }
        for (int y = 0; y < bSize; y++) {
            b[y] = nums[mid + 1 + y];
        }
        long count = 0;
        int i = 0, j = 0, k = left;
        while (i < aSize && j < bSize) {
            if (a[i] > b[j]) {
                count +=  aSize - i;  //mid - (left + i) + 1;
                nums[k] = b[j];
                j++;
                k++;
            } else {
                nums[k] = a[i];
                i++;
                k++;
            }
        }
        //Deal with leftovers from the while loop operations of i variable
        while (i < a.length) nums[k++] = a[i++];
        //Deal with leftovers from the while loop operations of j variable
        while (j < b.length) nums[k++] = b[j++];

        return count;
    }

    public long mergeSort(int[] nums, int left, int right) {
        long count = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;
            count += mergeSort(nums, left, mid);
            count += mergeSort(nums, mid + 1, right);
            count += merge(nums, left, mid, right);
        }
        return count;
    }


    public long countInversions(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        return mergeSort(nums, left, right);
    }//TC:  O(nlog(n)) SC: O(n)

}