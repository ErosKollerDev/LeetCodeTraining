package com.test;

public class TestAudebenev2 {

    public static void main(String[] args) {

        int[] nums = {0, 1, 0, 3, 12};
        int nonZeroIndex = 0;

        // Move all non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex] = nums[i];
                nonZeroIndex++;
            }
        }

        for (int i = 0; i < nums.length; i++) System.out.print(nums[i]);
        System.out.println();

        // Fill remaining positions with zeros
        while (nonZeroIndex < nums.length) {
            nums[nonZeroIndex] = 0;
            nonZeroIndex++;
        }

        for (int i = 0; i < nums.length; i++) System.out.print(nums[i]);


        System.out.println();
    }

}
