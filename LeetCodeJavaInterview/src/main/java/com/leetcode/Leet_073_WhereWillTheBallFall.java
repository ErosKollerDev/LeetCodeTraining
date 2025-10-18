package com.leetcode;

import com.util.PrintHelper;

import java.util.Arrays;

public class Leet_073_WhereWillTheBallFall {
    public static void main(String[] args) {
//        int[]  [] matrix = new int[][]{{1,1,1,-1,-1},{1,1,1,-1,-1},{-1,-1,-1,1,1},{1,1,1,1,-1},{-1,-1,-1,-1,-1}};
        int[]  [] matrix = new int[][]{{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1},{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1}};
        Leet_073_WhereWillTheBallFall leet = new Leet_073_WhereWillTheBallFall();
        PrintHelper.printMatrix(matrix);
        PrintHelper.printArray(leet.findBall(matrix));
    }

    public int[] findBall(int[][] grid) {
        int[] result = new int[grid[0].length];
        Arrays.fill(result, -1);
        for (int col = 0; col < grid[0].length; col++) {
            int currCol = col;
            for (int currentRow = 0; currentRow < grid.length; currentRow++) {
                int nextCol = currCol + grid[currentRow][currCol];
                if (nextCol < 0 || nextCol > grid[0].length - 1) break;
                if (grid[currentRow][currCol] != grid[currentRow][nextCol]) break;

                if (currentRow == grid.length - 1) {
                    result[col] = nextCol;
                }
                currCol = nextCol;
            }
        }
        return result;
    }

}