package com.leetcode;

public class Leet_046_MergeSortedArrays_Opt {
    public static void main(String[] args) {


        Leet_046_MergeSortedArrays_Opt leet = new Leet_046_MergeSortedArrays_Opt();
        leet.merge(new int[] {1,2,3,0,0,0} ,  3, new int[] {2,5,6},  3);
//        List<Integer> merge = leet.merge(Arrays.asList(4, 7, 9), Arrays.asList(2, 5, 6));
//        merge.stream().forEach(System.out::println);

//        merge = leet.merge(Arrays.asList(1, 1, 2, 4), Arrays.asList(2, 5, 6));
//        merge.stream().forEach(System.out::print);
    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m -1;
        int p2 = n -1;

        for(int i = nums1.length -1; i >= 0; i --){
            int vP1 = p1 >= 0 ? nums1[p1] : -9999;
            int vP2 = p2 >= 0 ? nums2[p2] : Integer.MIN_VALUE;
            if(vP1 > vP2){
                nums1[i] = vP1;
                p1--;
            }else{
                nums1[i] = vP2;
                p2--;
            }
        }

    }


}