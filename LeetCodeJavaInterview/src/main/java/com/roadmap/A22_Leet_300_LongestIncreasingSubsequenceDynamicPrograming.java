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
public class A22_Leet_300_LongestIncreasingSubsequenceDynamicPrograming {
    public static Node root;

    public static void main(String[] args) {
        var longIncSub = new A22_Leet_300_LongestIncreasingSubsequenceDynamicPrograming();
        System.out.println(longIncSub.longestIncreasingSubsequence(new int[]{0, 1, 0, 3, 2, 3})); //4
//        System.out.println(longIncSub.longestIncreasingSubsequence(new int[]{10,9,2,5,3,7,101,18})); //4
//        System.out.println(longIncSub.longestIncreasingSubsequence(new int[]{7,7,7,7,7,7,7})); //1
    }


    private int longestIncreasingSubsequence(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        //Array Dp size nums.length
        int[] dp = new int[n];
        //Fill with One {1,1,1,1 .....}
        Arrays.fill(dp, 1);
        //maxLen equal to One bare minimum
        int maxLen = 1;
        //Loop starting to index 1
        for (int i = 1; i < nums.length; i++) {
            int n1 = nums[i];
            //Loop starting to index 0
            for (int j = 0; j < i ; j++) {
                int n2 = nums[j];
                //Test if n1 > n2
                if (n1 > n2) {
                    //if so, than Math.max dp[i] = Math.max(dp[j] + 1, dp[i]);
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            //update maxLen Math.max(maxLen, dp[i]);
            maxLen = Math.max(maxLen, dp[i]);
        }
        //return maxLen
        return maxLen;
    }
}