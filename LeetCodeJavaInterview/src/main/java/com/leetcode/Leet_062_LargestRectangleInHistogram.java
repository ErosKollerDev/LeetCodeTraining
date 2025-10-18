package com.leetcode;

import java.util.Stack;

/**
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
 * return the area of the largest rectangle in the histogram.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: heights = [2,1,5,6,2,3]
 * Output: 10
 * Explanation: The above is a histogram where width of each bar is 1.
 * The largest rectangle is shown in the red area, which has an area = 10 units.
 * Example 2:
 * <p>
 * <p>
 * Input: heights = [2,4]
 * Output: 4
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= heights.length <= 105
 * 0 <= heights[i] <= 104
 */
public class Leet_062_LargestRectangleInHistogram {
    public static void main(String[] args) {
        Leet_062_LargestRectangleInHistogram leet = new Leet_062_LargestRectangleInHistogram();

        System.out.println(leet.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));//10
        System.out.println(leet.largestRectangleArea(new int[]{2, 4}));//4
    }
//TODO Take a closer look to this algorithm
    public int largestRectangleArea(int[] heights) {
        //2,1,5,6,2,3  -> 10
        int maxArea = 0;
        Stack<Integer> indexStack = new Stack();
        indexStack.push(0);
        for (int index = 1; index <= heights.length; index++) {
            int currentHeight = (index == heights.length) ? -1 : heights[index];
            while (!indexStack.isEmpty()
                    && currentHeight <= heights[indexStack.peek()]) {
                int lastHeight = heights[indexStack.pop()];
                int widthBaseOnRange = indexStack.isEmpty() ? index : index - indexStack.peek() - 1;
                int currentArea = lastHeight * widthBaseOnRange;
                maxArea = Math.max(maxArea, currentArea);
            }
            indexStack.push(index);
        }
        return maxArea;
    }//TC: O(n), SC: O(n)
}