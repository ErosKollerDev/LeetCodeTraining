package com.leetcode;

import java.util.HashSet;
import java.util.Set;


public class Leet_903_Letter_Tile_Possibilities_1079_eazy {
    public static void main(String[] args) {
        Leet_903_Letter_Tile_Possibilities_1079_eazy leet = new Leet_903_Letter_Tile_Possibilities_1079_eazy();
        System.out.println(leet.numTilePossibilities("AAB"));//8
    }

    public int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet<>();
        solve(tiles, set, 0);
        return set.size();
    }

    private void solve(String tiles, Set<String> set, int idx) {
        if (idx == tiles.length())
            return;

        Set<Character> temp = new HashSet<>();
        for (int i = idx; i < tiles.length(); i++) {
            if (!temp.contains(tiles.charAt(i))) {
                tiles = swap(tiles, i, idx);
                set.add(tiles.substring(0, idx + 1));
                temp.add(tiles.charAt(i));
                solve(tiles, set, idx + 1);
            }
        }
    }

    private String swap(String tiles, int i, int j) {
        char[] charArr = tiles.toCharArray();
        char temp = charArr[i];
        charArr[i] = charArr[j];
        charArr[j] = temp;
        return new String(charArr);
    }
}