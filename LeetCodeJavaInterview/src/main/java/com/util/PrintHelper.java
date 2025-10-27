package com.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintHelper {


    public static void printMatrix(Integer[][] matrix) {
        int[][] array = Arrays.stream(matrix).map(a -> Arrays.stream(a).mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
        Arrays.stream(matrix).map(ary -> Arrays.stream(ary).mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
        printMatrix(array);
        System.gc();



    }

    public static void printMatrix(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
//                System.out.print(matrix[r][c] + (c >= matrix.length - 1 ? "\n" : " | "));
                System.out.print(matrix[r][c] + " | ");
            }
            System.out.println();
        }
        for (int r = 0; r < matrix.length; r++) {
            System.out.print("---");
        }
        System.out.println();
    }

    public static void printArray(int[] array) {
        for (int n : array) {
            System.out.print(n + " | ");
        }
        System.out.println();
    }

    public static void printArray(long[] array) {
        for (long n : array) {
            System.out.print(n + " | ");
        }
        System.out.println();
    }

    public static void printArray(Integer[] array) {
        printArray(Arrays.asList(array).stream().mapToInt(i -> i).toArray());
    }

    public static void printArray(List<Integer> list) {
        printArray(list.stream().mapToInt(i -> i).toArray());
    }
    public static void printArrayStr(List<String> list) {
        list.stream().forEach(s -> System.out.print(s+" | "));
    }

}
