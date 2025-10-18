package com.leetcode;

import java.util.*;

/**
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 * <p>
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
 * Example 2:
 * <p>
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * Output: 0
 * Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= beginWord.length <= 10
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 5000
 * wordList[i].length == beginWord.length
 * beginWord, endWord, and wordList[i] consist of lowercase English letters.
 * beginWord != endWord
 * All the words in wordList are unique.
 * <p>
 * https://leetcode.com/problems/word-ladder/
 */
public class Leet_902_WordLadder_127_v2 {
    public static void main(String[] args) {
        Leet_902_WordLadder_127_v2 leet = new Leet_902_WordLadder_127_v2();
//        int stepsToTransform = leet.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        int stepsToTransform = leet.ladderLength("ymain", "oecij", Arrays.asList("ymann", "yycrj", "oecij", "ymcnj", "yzcrj", "yycij", "xecij", "yecij", "ymanj", "yzcnj", "ymain"));
        System.out.println("Steps to tranform : " + stepsToTransform);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //Transform List into a Set, so i can test if contains or not a "newWord" during the loop.
        Set<String> set = new HashSet<>(wordList );
        //If doesn't has the endWord, there is no point in do anything, return 0.
        if(!set.contains(endWord)) return 0;
        //Build a queue to store valid new words
        Queue<String> q = new LinkedList<>();
        //Add the first word which is the begin word.
        q.offer(beginWord);
        //Set the level of transformation to 1
        int level = 1;
        //Queue must not be empty, so we transform the most recent word added to try to guess the next step
        while(!q.isEmpty()){
            int size = q.size();
            //Loop throw the words into the queue until find the next step or empty the queue.
            for(int i = 0; i < size; i ++){
                //Previous word found by transformation.
                String currentWord = q.poll();
                for(int j = 0; j < currentWord.length(); j++){
                    char[] wordChars = currentWord.toCharArray();
                    //Grabbing the original char
                    char originalCh = wordChars[j];
                    //Looping throw the alphabet.
                    for(char c = 'a'; c <= 'z'; c++  ){
                        //If next char is equals to the original, just skip to the next interaction.
                        if(c == originalCh)continue;
                        //Replacing if a new char.
                        wordChars[j] =c;
                        //Building a new word.
                        String newWord = new String(wordChars  );
                        //If is equals to the end word, just return and count this last transformation.
                        if(newWord.equals(endWord)) return level +1;
                        //If is not the end word but is one of the words os the list, we just probably found the next step.
                        if(set.contains(newWord)){
                            //Adding to the queue
                            q.offer(newWord);
                            //Removing from the Set, so we don't interact with that anymore.
                            set.remove(newWord);
                        }
                    }
                }
            }
            //Counting one more transformation.
            level ++;
        }
        return 0;  // No valid transformation sequence found
    }//TC: O(n)

}

