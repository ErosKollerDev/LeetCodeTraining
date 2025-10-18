package com.leetcode;

import com.util.PrintHelper;
//https://leetcode.com/problems/set-matrix-zeroes/
public class Leet_071_SetMatrixZeroes {
    public static void main(String[] args) {
        Leet_071_SetMatrixZeroes leet = new Leet_071_SetMatrixZeroes();
//        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
//        int[][] matrix = {{1, 1, 0}, {1, 1, 1}, {1, 1, 1}};
//        PrintHelper.printMatrix(matrix);
//        leet.setZeroes(matrix);
//        PrintHelper.printMatrix(matrix);
        int[][]  matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
//        PrintHelper.printMatrix(matrix);
        leet.setZeroes(matrix);
        PrintHelper.printMatrix(matrix);
    }
    //TODO master ths code before the interview  Set Matrix Zeroes
    public void setZeroes(int[][] matrix) {

        boolean hasFirstRow = false;
        boolean hasFirsCol = false;
        //First Step, just mark Row & Col to true if find Zero
        for (int r = 0; r < matrix[0].length; r++) {//First Row
            if (matrix[0][r] == 0) {
                hasFirstRow = true;
                break;
            }
        }
        for (int c = 0; c < matrix.length; c++) {//First Col
            if (matrix[c][0] == 0) {
                hasFirsCol = true;
                break;
            }
        }
    // ----------------------------------------------------
        //Second Step, preprocessing
        for (int r = 1; r < matrix.length; r++) {
            for (int c = 1; c < matrix[0].length; c++) { //loop throw first matrix
                if (matrix[r][c] == 0) {
                    matrix[r][0] = 0; //Set zero the row zero first item
                    matrix[0][c] = 0; //Set zero the first matrix position c representing the columns
                }
            }
        }
        //Third Step, nullify columns and rows

        //Loop throw first row to nullify Columns
        PrintHelper.printMatrix(matrix);
        for (int c = 1; c < matrix[0].length; c++) {
            if (matrix[0][c] == 0) {
                nullifyCol(matrix, c);
            }
        }
        PrintHelper.printMatrix(matrix);
        //Loop throw first column to nullify Rows
        for (int r = 1; r < matrix.length; r++) {
            if(matrix[r][0] == 0){
                nullifyRow(matrix, r);
            }
        }
        //Fourth step nullify first row and first column
        if(hasFirstRow) nullifyRow(matrix, 0);
        if(hasFirsCol) nullifyCol(matrix, 0);

    }


    private void nullifyRow(int[][] matrix, int indexRow) {
        for(int c = 0 ; c < matrix[0].length; c++){
            matrix[indexRow][c] = 0;
        }
    }

    private void nullifyCol(int[][] matrix, int indexColumn) {
        for(int r = 0; r < matrix.length; r++){
            matrix[r][indexColumn] = 0;
        }
    }
}// TC: O(2ROW) + O(2C) + O(R * C) + O(R * C)  |  SC: O(1)