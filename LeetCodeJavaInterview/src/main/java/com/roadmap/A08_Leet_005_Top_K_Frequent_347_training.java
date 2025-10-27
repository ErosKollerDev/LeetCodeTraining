package com.roadmap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import static com.util.PrintHelper.printArray;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 * <p>
 * Input: nums = [1], k = 1
 * Output: [1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 * <p>
 * <p>
 * Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class A08_Leet_005_Top_K_Frequent_347_training {
    public static void main(String[] args) {
        A08_Leet_005_Top_K_Frequent_347_training leet = new A08_Leet_005_Top_K_Frequent_347_training();
        int[] ints = null;
        ints = leet.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        printArray(ints);
        ints = leet.topKFrequent(new int[]{1, 1, 1, 2, 2, 3, 9, 9, 9, 9, 9, 9}, 3);
        printArray(ints);
        ints = leet.topKFrequent(new int[]{1, 5, 5, 5, 4, 5, 1, 1, 2, 2, 3}, 2);
        printArray(ints);
        ints = leet.topKFrequent(new int[]{1, 10, 10, 2, 2, 3}, 2);
        printArray(ints);
    }

    private int[] topKFrequent(int[] nums, int topK) {
        var ans = new int[topK];
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            var n = nums[i];
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        var pq = new PriorityQueue<Map.Entry<Integer, Integer>>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            pq.offer(entry);

        for (int i = 0; i < ans.length; i++) {
            ans[i] = pq.poll().getKey();
        }
        return ans;
    }


}