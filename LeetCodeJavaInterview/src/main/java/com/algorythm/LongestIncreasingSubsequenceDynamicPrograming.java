package com.algorythm;

import java.util.Arrays;

//TODO Longest Increasing subsequence
public class LongestIncreasingSubsequenceDynamicPrograming {
    public static Node root;

    public static void main(String[] args) {
        var longIncSub = new LongestIncreasingSubsequenceDynamicPrograming();
        System.out.println(longIncSub.longestIncreasingSubsequence(new int[]{0, 1, 0, 3, 2, 3})); //4
//        System.out.println(longIncSub.longestIncreasingSubsequence(new int[]{10,9,2,5,3,7,101,18})); //4
//        System.out.println(longIncSub.longestIncreasingSubsequence(new int[]{7,7,7,7,7,7,7})); //1
    }


    private int longestIncreasingSubsequence(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLen = 1;

        for (int i = 1; i <= nums.length - 1; i++) {
            int n1 = nums[i];
            for (int j = 0; j <= i - 1; j++) {
                int n2 = nums[j];
                if (n1 > n2) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}