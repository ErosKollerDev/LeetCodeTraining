package com.roadmap;

import com.util.PrintHelper;

import java.util.*;

/**
 * Given an array of strings strs, group the
 * anagrams
 *  together. You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 *
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Explanation:
 *
 * There is no string in strs that can be rearranged to form "bat".
 * The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
 * The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
 * Example 2:
 *
 * Input: strs = [""]
 *
 * Output: [[""]]
 *
 * Example 3:
 *
 * Input: strs = ["a"]
 *
 * Output: [["a"]]
 *
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 */
public class A06_Leet_004_GroupAnagram_49_training {
    public static void main(String[] args) {
        A06_Leet_004_GroupAnagram_49_training leet = new A06_Leet_004_GroupAnagram_49_training();
        List<List<String>> lists = leet.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        lists.stream().forEach(l -> {
            System.out.println();
            PrintHelper.printArrayStr(l);
        } );
    }

    //List<List<String>> groupAnagrams(String[] strs)
    public List<List<String>> groupAnagrams(String[] words) {
        var map = new HashMap<String, List<String>>();
        for (String word : words) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);;
            var key = String.valueOf(charArray);
            if(map.containsKey(key)){
                map.get(key).add(word);
            }else{
                var l = new ArrayList<String>();
                l.add(word);
                map.put(key, l);
            }

        }
        return new ArrayList<>(map.values());
    }

}