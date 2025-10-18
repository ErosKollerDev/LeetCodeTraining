package com.algorythm;

public class TwoPointersMaxWater {

    public static void main(String[] args) {
        TwoPointersMaxWater twoPointers = new TwoPointersMaxWater();
        System.out.println(twoPointers.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }


    private int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
           int currentArea  = Math.min(height[left], height[right]) * (right - left);
           maxArea = Math.max(maxArea, currentArea);
           if(height[left] < height[right]){
               left++;
           }else{
               right--;
           }

        }
        return maxArea;
    }

}



