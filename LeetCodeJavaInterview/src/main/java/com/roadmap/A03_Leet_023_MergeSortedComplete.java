package com.roadmap;

import com.util.PrintHelper;

import java.util.Random;

public class A03_Leet_023_MergeSortedComplete {
    public static void main(String[] args) {


        A03_Leet_023_MergeSortedComplete leet = new A03_Leet_023_MergeSortedComplete();
        Random random = new Random();
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(array.length);
        }
        System.out.println("Before");
        PrintHelper.printArray(array);
        System.out.println("After");
        leet.mergeSort(array);
        PrintHelper.printArray(array);

    }

    //Divide mergeSort
    public void mergeSort(int[] inputArray) {
        if (inputArray.length < 2) return;
        int inputLength = inputArray.length;
        int midIndex = inputLength / 2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[inputLength - midIndex];
        for (int i = 0; i < leftHalf.length; i++) {
            leftHalf[i] = inputArray[i];
        }
        for (int j = 0; j < rightHalf.length; j++) {
            rightHalf[j] = inputArray[midIndex + j];
        }
        mergeSort(leftHalf);
        mergeSort(rightHalf);
        //Merge arrays
        this.merge(inputArray, leftHalf, rightHalf);
    }

    //merge
    private void merge(int[] inputArray, int[] leftHalf, int[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;
        int i = 0, j = 0, k = 0;
        while(i < leftSize && j < rightSize){
            if(leftHalf[i] < rightHalf[j]){
                inputArray[k] = leftHalf[i];
                i ++;
            }else{
                inputArray[k] = rightHalf[j];
                j++;
            }
            k++;
        }
        while(i < leftSize){
            inputArray[k] = leftHalf[i];
            i ++;
            k++;
        }
        while(j < rightSize){
            inputArray[k] = rightHalf[j];
            j ++;
            k++;
        }
    }
}