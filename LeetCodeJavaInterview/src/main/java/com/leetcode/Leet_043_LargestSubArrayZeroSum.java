package com.leetcode;

import java.util.HashMap;

public class Leet_043_LargestSubArrayZeroSum {
    public static void main(String[] args) {
        Leet_043_LargestSubArrayZeroSum leet = new Leet_043_LargestSubArrayZeroSum();
        System.out.println(leet.maxLenZeroSun(new int[]{15, -2, 2, -8, 1, 7, 10, 23}));
    }

    public int maxLenZeroSun(int[] nums) {
        int sum = 0, len = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i ++){
            sum += nums[i];
            if(sum == 0){
                len = i +1;
            }else  if(map.containsKey(sum)){
                len = Math.max(len , i - map.get(sum));
            }else{
                map.put(sum, i);
            }
        }
        return len;
    }

}