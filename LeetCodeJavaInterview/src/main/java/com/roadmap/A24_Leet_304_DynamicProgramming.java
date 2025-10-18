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
public class A24_Leet_304_DynamicProgramming {
    public static void main(String[] args) {
        int[][] matrix = new int[][]
                {
                        {3, 0, 1, 4, 2},
                        {5, 6, 3, 2, 1},
                        {1, 2, 0, 1, 5},
                        {4, 1, 0, 1, 7},
                        {1, 0, 3, 0, 5}};

        matrix = new int[][]
                {
                        {1, 1, 1},
                        {2, 2, 2},
                        {3, 3, 3}
                };
        PrintHelper.printMatrix(matrix);
        A24_Leet_304_DynamicProgramming leet = new A24_Leet_304_DynamicProgramming(matrix);
//        PrintHelper.printMatrix(matrix);
        System.out.println(leet.sumRegion(1, 1, 2, 2));//8
    }

    //Dynamic Programming
    int[][] dpPrev;

    public A24_Leet_304_DynamicProgramming(int[][] matrix) {
        dpPrev = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int aboveValue = dpPrev[i][j + 1];//0
                int leftValue = dpPrev[i + 1][j];//5
                int aboveAndLeftValueToSub = dpPrev[i][j];//3
                int matrixValue = matrix[i][j];
                dpPrev[i + 1][j + 1] = aboveValue + leftValue - aboveAndLeftValueToSub + matrixValue;
            }
        }
        PrintHelper.printMatrix(dpPrev);
    }

    //                      2, 1, 4, 3
    public int sumRegion(int row1, int col1, int row2, int col2) {
        //[5][4] -  [2][4] - [5][2] + [2][1]
        //38 - 24 - 23 + 8
        return dpPrev[row2 + 1][col2 + 1] - dpPrev[row1][col2 + 1] - dpPrev[row2 + 1][col1] + dpPrev[row1][col1];
    }//TC
}
