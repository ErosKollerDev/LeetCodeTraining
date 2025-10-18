package com.leetcode;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * <p>
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 * <p>
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 */
public class Leet_038_ProductArrayExceptSelf {
    public static void main(String[] args) {

        Leet_038_ProductArrayExceptSelf leet = new Leet_038_ProductArrayExceptSelf();
        System.out.println(leet.productExceptSelf(new int[]{1, 2, 3, 4}));

    }


    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 0) return nums;
        int[] prefix = new int[nums.length];
        prefix[0] = 1;
        for(int i = 1; i < nums.length; i ++){
            prefix[i] = prefix[i-1] * nums[i-1];
        }
        int suffixHolder = 1;
//        int[] suffix = new int[nums.length];
//        suffix[suffix.length-1] =1;
//        for(int y = nums.length-2; y >= 0; y --){
//            suffix[y] = suffix[y+1] * nums[y+1];
//        }
        int[] result = new int[nums.length];
        for(int j = nums.length -1; j >= 0 ;  j--){
            result[j] = prefix[j] * suffixHolder;
            suffixHolder = suffixHolder * nums[j];
        }
        return result;
    }//TC O(n)  SC(n)
    public int[] productExceptSelfGoodEnough(int[] nums) {
        if (nums.length == 0) return nums;
        int[] prefix = new int[nums.length];
        prefix[0] = 1;
        for(int i = 1; i < nums.length; i ++)prefix[i] = prefix[i-1] * nums[i-1];
        int[] suffix = new int[nums.length];
        suffix[suffix.length-1] =1;
        for(int y = nums.length-2; y >= 0; y --){
            suffix[y] = suffix[y+1] * nums[y+1];
        }
        int[] result = new int[nums.length];
        for(int j = 0; j < nums.length;  j++){
            result[j] = prefix[j] * suffix[j];
        }
        return result;
    }//TC O(n)  SC(3)
    public int[] productExceptSelfNotGood(int[] nums) {
        if (nums.length == 0) return nums;
        int first = nums[0];
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                for (int j = 1; j < nums.length; j++) first = nums[j] * first;
                result[0] = first;
            } else {
                result[i] = first / nums[i];
            }
        }
        return result;
    }//TC O(n^2)

}