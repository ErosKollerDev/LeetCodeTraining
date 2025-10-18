package com.leetcode;

/**
 * Intuition
 * The problem requires generating all possible non-empty sequences of tiles, considering duplicate letters. Unlike a simple permutation problem, where all characters are distinct, we must avoid counting duplicate sequences multiple times.
 *
 * To achieve this:
 *
 * Backtracking is used to explore all possible sequences.
 * A frequency array (count[26]) helps manage duplicate letters efficiently.
 * By decrementing and restoring counts, we ensure all unique sequences are considered.
 * Approach
 * Count letter frequencies:
 * • Store the frequency of each character in an array count[26] (since tiles contain only uppercase English letters).
 * Backtracking to generate sequences:
 * • Iterate through count[], choosing a character if available.
 * • Reduce its count and recursively generate further sequences.
 * • Restore its count after recursion (backtrack).
 * • Each recursive call adds one valid sequence.
 * Base Case:
 * • If no letters are left to pick, return.
 * By doing this, we generate all valid sequences without redundant calculations, handling duplicates efficiently.
 *
 * Complexity
 * Time complexity:
 * • In the worst case (tiles.length = 7), every letter is distinct, leading to 7! (5040) unique permutations.
 * • Since each tile can be used multiple times in different orders, the upper bound is exponential:
 * O(k!), where k is the number of distinct letters.
 *
 * However, due to frequency-based pruning, it runs significantly faster than brute-force permutations.
 *
 * Space complexity:
 * • O(26) = O(1) for the count[26] array.
 * • O(k) for recursive call stack (k is the number of distinct letters).
 * • O(1) auxiliary space (no additional data structures apart from count[]).
 *
 * Thus, the worst-case space complexity is O(k) (at most 7 recursive calls due to tiles.length ≤ 7).
 *
 * Code
 */
public class Leet_903_Letter_Tile_Possibilities_1079 {
    public static void main(String[] args) {
        Leet_903_Letter_Tile_Possibilities_1079 leet = new Leet_903_Letter_Tile_Possibilities_1079();
        System.out.println(leet.numTilePossibilities("AAB"));//8
    }

    public int numTilePossibilities(String tiles) {
        int[] count = new int[26];
        for (char c : tiles.toCharArray()) {
            count[c - 'A']++;
        }
        return backtrack(count);
    }

    private int backtrack(int[] count) {
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                sum++;
                count[i]--;
                sum += backtrack(count);
                count[i]++;
            }
        }
        return sum;
    }


}