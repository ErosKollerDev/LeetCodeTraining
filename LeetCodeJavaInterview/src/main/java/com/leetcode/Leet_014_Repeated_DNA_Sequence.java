package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
 *
 * For example, "ACGAATTCCG" is a DNA sequence.
 * When studying DNA, it is useful to identify repeated sequences within the DNA.
 *
 * Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * Output: ["AAAAACCCCC","CCCCCAAAAA"]
 * Example 2:
 *
 * Input: s = "AAAAAAAAAAAAA"
 * Output: ["AAAAAAAAAA"]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s[i] is either 'A', 'C', 'G', or 'T'.
 */
public class Leet_014_Repeated_DNA_Sequence {

    public static void main(String[] args) {
        Leet_014_Repeated_DNA_Sequence leet = new Leet_014_Repeated_DNA_Sequence();
        System.out.println(leet.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));

    }


    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>(s.length()/2);
        for (int i = 0; i < s.length() - 10; i++) {
            String subsDNA = s.substring(i, i + 10);
            map.put(subsDNA, map.getOrDefault(subsDNA, 0) + 1);
        }
        List<String> listDNA = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                listDNA.add(entry.getKey());
            }
        }

        return listDNA;
    }

}//TC : O(strs.length * str.length())
//SC : O(1)