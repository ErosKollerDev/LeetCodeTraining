package com.leetcode;

public class Leet_048_TwoSumIIInputArrayIsSorted {
    public static void main(String[] args) {
        Leet_048_TwoSumIIInputArrayIsSorted leet = new Leet_048_TwoSumIIInputArrayIsSorted();
        leet.twoSum(new int[]{2,7,11,15}, 9); //[1,2]
        leet.twoSum(new int[]{2,3,4}, 6); //[1,3]
        leet.twoSum(new int[]{-1,0}, -1); //[1,2]



    }

    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                break;
            }
            if(sum > target){
                right--;
            }
            if(sum < target){
               left++;
            }
        }
        int [] ix = new int[]{left+1, right+1};
        return ix;
    }
}