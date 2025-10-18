package com.algorythm;

import com.util.PrintHelper;

/**
 * Given a 2D matrix matrix, handle multiple queries of the following type:
 * <p>
 * Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 * Implement the NumMatrix class:
 * <p>
 * NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
 * int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 * You must design an algorithm where sumRegion works on O(1) time complexity.
 */
//https://leetcode.com/problems/range-sum-query-2d-immutable/description/
//TODO Dynamic Programming (DP)
public class DynamicProgramming_eros {
    public static void main(String[] args) {
        int[][] matrix = new int[][]
                {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        PrintHelper.printMatrix(matrix);
        DynamicProgramming_eros leet = new DynamicProgramming_eros(matrix);
        System.out.println(leet.sumRegion(2, 1, 4, 3));//8
    }

    //Dynamic Programming
    int[][] dp;

    public DynamicProgramming_eros(int[][] matrix) {
        dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {

                int aboveValue = dp[r][c + 1];
                int leftValue = dp[r + 1][c];
                int aboveAndLeftValueToSub = dp[r][c];
                int matrixValue = matrix[r][c];
                dp[r + 1][c + 1] = aboveValue + leftValue - aboveAndLeftValueToSub + matrixValue;
            }
        }
        PrintHelper.printMatrix(dp);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
    }//TC
}
