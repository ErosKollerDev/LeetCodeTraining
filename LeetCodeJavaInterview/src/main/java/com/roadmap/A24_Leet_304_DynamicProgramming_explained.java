package com.roadmap;

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
//https://www.youtube.com/watch?v=KE8MQuwE2yA
//TODO Dynamic Programming (DP)
public class A24_Leet_304_DynamicProgramming_explained {
    public static void main(String[] args) {
        int[][] matrix = new int[][]
                {
                        {3, 0, 1, 4, 2},
                        {5, 6, 3, 2, 1},
                        {1, 2, 0, 1, 5},
                        {4, 1, 0, 1, 7},
                        {1, 0, 3, 0, 5}};
        int[][] matrix2 = new int[][]
                {
                        {1, 1, 1},
                        {2, 2, 2},
                        {3, 3, 3}
                };
//        PrintHelper.printMatrix(matrix);
        A24_Leet_304_DynamicProgramming_explained leet = new A24_Leet_304_DynamicProgramming_explained(matrix2);
//        PrintHelper.printMatrix(matrix);
        System.out.println("Value: "+leet.sumRegion(1, 1, 2, 2));//10
//        leet = new A24_Leet_304_DynamicProgramming_training(matrix);
//        System.out.println(leet.sumRegion(2, 1, 4, 3));//8
//        System.out.println(leet.sumRegion(2, 1, 4, 3));//8
//        System.out.println(leet.sumRegion(2, 1, 4, 3));//8
    }

    //Dynamic Programming
    int[][] dpPrev;

    public A24_Leet_304_DynamicProgramming_explained(int[][] matrix) {
        // counting rows and columns
        int rows = matrix.length, cols = matrix[0].length;
        //creating a matrix with One extra space, to simplify calculation.
        dpPrev = new int[rows + 1][cols + 1];

        // Build cumulative sum matrix using dynamic programming
        // Starting from 1 to handle the extra padding row and column
        for (int i = 1; i < dpPrev.length; i++) {
            for (int j = 1; j < dpPrev[i].length; j++) {
                // Get current value from input matrix (adjusted for padding offset)
                int currentValue = matrix[i - 1][j - 1];
                // Get cumulative sums from adjacent cells
                int above = dpPrev[i - 1][j];      // Value from cell above
                int left = dpPrev[i][j - 1];      // Value from cell to the left
                int leftAndAbove = dpPrev[i - 1][j - 1];  // Value from diagonal cell
                // Calculate cumulative sum: current + above + left - diagonal
                // (subtract diagonal to avoid double counting)
                dpPrev[i][j] = currentValue + above + left - leftAndAbove;
            }
        }
        PrintHelper.printMatrix(matrix);
        System.out.println("-----------");
        PrintHelper.printMatrix(dpPrev);
    }

    //                      2, 1, 4, 3
    public int sumRegion(int row1, int col1, int row2, int col2) {

        // Total sum from (0,0) to (row2,col2)
        int downRight = dpPrev[row2 + 1][col2 + 1];
        // Sum of region (0,0) to (row1-1,col2)
        int upAbove = dpPrev[row1][col2 + 1];
        // Sum of region (0,0) to (row2,col1-1)
        int farLeft = dpPrev[row2 + 1][col1];
        // Sum of region (0,0) to (row1-1,col1-1)
        int farLeftAndAbove = dpPrev[row1][col1];
        System.out.printf("row1: %d, col1: %d, row2: %d, col2: %d%n", row1, col1, row2, col2);
        System.out.printf("dowRight : %d - upaAbove: %d - farLeft: %d + farLeftAndAbove: %d%n", downRight, upAbove, farLeft, farLeftAndAbove);
        // Calculate region sum using inclusion-exclusion principle:
        // Total - top region - left region + overlap (to avoid double subtraction)
        return   downRight - upAbove - farLeft + farLeftAndAbove;
    }//TC
}
