package com.roadmap;

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
 * <p>
 * <p>
 * Intuition
 * If you know how to play Sudoku, you might already have a rough idea on how to solve this problem and which data structure to use(spoiler: its the one we use to check for duplicates). In Sudoku, a number cannot appear more than once in:
 * <p>
 * The same row.
 * The same column.
 * The same 3×3 box.
 * To efficiently track these constraints, we can use a HashSet, which provides O(1) lookup time for checking duplicates.
 * <p>
 * Approach
 * We need to create a HashSet to store our scanned elements from the two dimensional (9x9) board array and we need to use the same HashSet to check for duplicates.
 * <p>
 * Then, We need to iterate through each element in the 2d array(9x9 board) if we want to add them to our HashSet and we will achieve this using two for loops that will check through each row and column in this format (i,j) where i is the row index and j is the column index.
 * <p>
 * Ex: 5 in (0,0), 3 in (0,1)....
 * 6 in (1,0), . in (1,1)......
 * <p>
 * Each Character encountered in an iteration will be stored in num.
 * Ex: num = 5
 * <p>
 * If the character encountered is a '.' it will be skipped as there is nothing to validate and the next iteration will begin.
 * <p>
 * Now for each Character encountered, we will store its location in the form of a string. That means its location in three places: its row, column and the box it resides in will be stored in these variables that we will validate in the next step.
 * Ex: rowKey = 5 in row 0
 * colKey = 5 in col 0
 * boxKey = 5 in box 0-0
 * If you are confused as to why we are representing 5 in box 0-0, take note that, we will represent each box using box indices: ie.row and column of a 9x9 grid.
 * Example: 0-0 (Top-left),0-1 (Top-center),0-2 (Top-right).....
 * <p>
 * At first the program will check if the HashSet already contains the following element in the same row, column or box ie.it is a duplicate. If it does it will return false indicating the invalidity of the element in the sudoku.
 * <p>
 * If the element does not exist, the program will add it to the HashSet for tracking its occurences.
 * <p>
 * If the for loops end without returning a false, this means that there are no duplicates and the sudoku is valid. As a result, the program will return true indicating as such.
 * <p>
 * Complexity
 * Time complexity:
 * O(81) = O(1) (fixed 9×9 board, each cell checked once)
 * <p>
 * Space complexity:
 * O(81) = O(1) (worst case: storing all non-empty cells in the HashSet).
 */
public class A15_Leet_006_Valid_Sudoku_faster {
    public static void main(String[] args) {
        A15_Leet_006_Valid_Sudoku_faster leet = new A15_Leet_006_Valid_Sudoku_faster();
        char[][] suduko = new char[][]
                        { {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
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
        for (int z = 1; z < 9; z += 3) {
            for (int x = 1; x < 9; x += 3)
                if (!isValidLine(generateBox(board, z, x)))
                    return false;
        }
        //column and row
        char[] col = new char[9];
        for (int j = 0; j < 9; ++j) {
            for (int i = 0; i < 9; ++i) {
                col[i] = board[i][j];
            }
            if (!isValidLine(board[j]))
                return false;
            if (!isValidLine(col))
                return false;
        }

        return true;
    }

    private boolean isValidLine(char[] line) {
        int[] positions = new int[9];
        for (int i = 0; i < 9; ++i) {
            if (line[i] == '.')
                continue;
            else if (positions[line[i] - '1'] == 1)
                return false;
            else
                positions[line[i] - '1']++;
        }
        return true;
    }

    private char[] generateBox(char[][] board, int x, int y) {
        char[] box = new char[]
                {
                        board[x - 1][y - 1], board[x - 1][y], board[x - 1][y + 1],
                        board[x][y - 1], board[x][y], board[x][y + 1],
                        board[x + 1][y - 1], board[x + 1][y], board[x + 1][y + 1]};
        return box;
    }
}