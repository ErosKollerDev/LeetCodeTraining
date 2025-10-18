package com.algorythm;

public class ModifiedBinatySearch {


    public static void main(String[] args) {
        ModifiedBinatySearch modified = new ModifiedBinatySearch();
        System.out.println(modified.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 7));
    }

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if(target == nums[middle]) return middle;
            if(nums[left] <= nums[middle]){
                if(nums[left] <= target && target < nums[middle]){
                    right = middle -1;
                }else{
                    left = middle + 1;
                }
            }else{
                if(nums[middle] < target && target <= nums[right]){
                    left = middle + 1;
                }else{
                    right = middle -1;
                }
            }
        }
        return -1;
    }


}
