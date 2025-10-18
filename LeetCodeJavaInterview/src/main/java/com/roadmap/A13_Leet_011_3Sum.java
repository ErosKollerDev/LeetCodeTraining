package com.roadmap;

import com.util.PrintHelper;

import java.util.*;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * Example 2:
 * <p>
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * Example 3:
 * <p>
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
public class A13_Leet_011_3Sum {
    public static void main(String[] args) {
        A13_Leet_011_3Sum leet = new A13_Leet_011_3Sum();
        List<List<Integer>> lists = leet.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        Integer[][] matrix = lists.stream().map(l -> l.stream().toArray(Integer[]::new))
                .toArray(Integer[][]::new);

        PrintHelper.printMatrix(matrix);
    }

    public List<List<Integer>> threeSum(int[] arr) {
        if (arr == null || arr.length < 3) return new ArrayList<>();
        //Sort the array
        Arrays.sort(arr);
        //Build a ArrayList of List<Integer>
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == 0) {
                    result.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    left++;
                    right--;
                }
                //Because the sum is less than zero and the array is sorted, now I know I have to pick up a higher value on the left side;
                else if (sum < 0) {
                    left++;
                } else {
                    //Because i know to sum is bigger than zero, I have to pick up a value smaller on the right side;
                    right--;
                }
            }
        }
        return new ArrayList<>(result);
    }

}