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
public class Leet_061_LargestRectangleInHistogram {
    public static void main(String[] args) {
        Leet_061_LargestRectangleInHistogram leet = new Leet_061_LargestRectangleInHistogram();

        System.out.println(leet.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));//10
    }

    public int largestRectangleArea(int[] heights) {
        //2,1,5,6,2,3  -> 10
        Stack<Integer> stackIx = new Stack<>();
        int maxArea = 0;
        stackIx.push(0);//Pushing the first index into the stack Obs: so, we have a first height to work with
        for (int index = 1; index <= heights.length; index++) {
            int currentHeight = (index == heights.length) ? -1 : heights[index];
            while (!stackIx.isEmpty()
                    //testing if it's decreasing
                    && currentHeight <= heights[stackIx.peek()]) {
                //Removing the last height on stack
                int poppingLastHeight = heights[stackIx.pop()];
                //Finding the width of the area    (Poping the index from the stack, remember the width is always "1")
                int widthCurrentOrRange = stackIx.isEmpty() ? index : index - stackIx.peek() - 1;
                //Finding the current area
                int currentArea = poppingLastHeight * widthCurrentOrRange;
                maxArea = Math.max(maxArea, currentArea);
            }
            stackIx.push(index);
        }
        return maxArea;
    }//TC: O(n), SC: O(n)
}