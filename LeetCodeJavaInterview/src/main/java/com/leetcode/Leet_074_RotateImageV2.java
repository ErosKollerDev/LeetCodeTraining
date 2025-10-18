package com.leetcode;

import com.util.PrintHelper;

public class Leet_074_RotateImageV2 {
    public static void main(String[] args) {
        Leet_074_RotateImageV2 leet = new Leet_074_RotateImageV2();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        PrintHelper.printMatrix(matrix);
        leet.rotate(matrix);
        PrintHelper.printMatrix(matrix);

    }
    //TODO master this Rotate Image Code
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int[] temp = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = temp;
        }
        for(int i = 0; i < n ; i ++){
            for(int j = i + 1; j < n ; j ++){
                int temp = matrix[i ][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

}