package com.roadmap;

import java.util.HashSet;

/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * <p>
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 * <p>
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 *
 *
 * Intuition
 * If you know how to play Sudoku, you might already have a rough idea on how to solve this problem and which data structure to use(spoiler: its the one we use to check for duplicates). In Sudoku, a number cannot appear more than once in:
 *
 * The same row.
 * The same column.
 * The same 3×3 box.
 * To efficiently track these constraints, we can use a HashSet, which provides O(1) lookup time for checking duplicates.
 *
 * Approach
 * We need to create a HashSet to store our scanned elements from the two dimensional (9x9) board array and we need to use the same HashSet to check for duplicates.
 *
 * Then, We need to iterate through each element in the 2d array(9x9 board) if we want to add them to our HashSet and we will achieve this using two for loops that will check through each row and column in this format (i,j) where i is the row index and j is the column index.
 *
 * Ex: 5 in (0,0), 3 in (0,1)....
 * 6 in (1,0), . in (1,1)......
 *
 * Each Character encountered in an iteration will be stored in num.
 * Ex: num = 5
 *
 * If the character encountered is a '.' it will be skipped as there is nothing to validate and the next iteration will begin.
 *
 * Now for each Character encountered, we will store its location in the form of a string. That means its location in three places: its row, column and the box it resides in will be stored in these variables that we will validate in the next step.
 * Ex: rowKey = 5 in row 0
 * colKey = 5 in col 0
 * boxKey = 5 in box 0-0
 * If you are confused as to why we are representing 5 in box 0-0, take note that, we will represent each box using box indices: ie.row and column of a 9x9 grid.
 * Example: 0-0 (Top-left),0-1 (Top-center),0-2 (Top-right).....
 *
 * At first the program will check if the HashSet already contains the following element in the same row, column or box ie.it is a duplicate. If it does it will return false indicating the invalidity of the element in the sudoku.
 *
 * If the element does not exist, the program will add it to the HashSet for tracking its occurences.
 *
 * If the for loops end without returning a false, this means that there are no duplicates and the sudoku is valid. As a result, the program will return true indicating as such.
 *
 * Complexity
 * Time complexity:
 * O(81) = O(1) (fixed 9×9 board, each cell checked once)
 *
 * Space complexity:
 * O(81) = O(1) (worst case: storing all non-empty cells in the HashSet).
 *
 */
public class Leet_006_Valid_Suduku_easier {
    public static void main(String[] args) {
        Leet_006_Valid_Suduku_easier leet = new Leet_006_Valid_Suduku_easier();
        char[][] suduko = new char[][]
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        boolean validSudoku = leet.isValidSudoku(suduko);
        System.out.println("Is Suduko valid: " + validSudoku);
    }

    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num == '.') continue;
                String rowKey = num + " - in row - " + i;
                String colKey = num + " - in col - " + j;
                String boxKey = num + " - in box - " + (i / 3) + "-" + (j / 3);

                if (seen.contains(rowKey) || seen.contains(colKey) || seen.contains(boxKey)) {
                    return false;
                }
                seen.add(rowKey);
                seen.add(colKey);
                seen.add(boxKey);

            }
        }
        return true;
    }
}