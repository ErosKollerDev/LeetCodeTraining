package com.roadmap;

import com.algorythm.Node;

import java.util.Arrays;

/**
 * Example 1:
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 */
public class A22_Leet_300_LongestIncreasingSubsequenceDynamicPrograming_training {
    public static Node root;

    public static void main(String[] args) {
        var longIncSub = new A22_Leet_300_LongestIncreasingSubsequenceDynamicPrograming_training();
        System.out.println("4 -> "+longIncSub.longestIncreasingSubsequence(new int[]{0, 1, 0, 3, 2, 3})); //4
        System.out.println("4 -> "+longIncSub.longestIncreasingSubsequence(new int[]{10,9,2,5,3,7,101,18})); //4
        System.out.println("1 -> "+longIncSub.longestIncreasingSubsequence(new int[]{7,7,7,7,7,7,7})); //1
    }


    private int longestIncreasingSubsequence(int[] nums) {
        var n = nums.length;
        if(n == 0 )return  0;
        var maxLen = 1;
        var dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            var n1 = nums[i];
            for (int j = 0; j < i; j++) {
                var n2 = nums[j];
                if(n1 > n2){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }

            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }
}