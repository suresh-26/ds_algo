package com.dsalgo.recursion.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = { 2, 5, 3, 7, 1, 9, 0, 9 };
        int[] sortedArr = mergeSort(arr);
        Arrays.stream(sortedArr).forEach(System.out::println);

        // int[] first = { 3, 4, 7, 9, 11 };
        // int[] second = { 5, 7, 12 };

        // int[] sortedArr2 = mergeSort(first, second, arr);
        // Arrays.stream(sortedArr2).forEach(System.out::println);
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        int midInd = (arr.length) / 2;
        int[] first = Arrays.copyOfRange(arr, 0, midInd);
        int[] second = Arrays.copyOfRange(arr, midInd, arr.length);
        mergeSort(first);
        mergeSort(second);
        return mergeSort(first, second, arr);
    }

    public static int[] mergeSort(int[] first, int[] last, int[] sortedArr) {
        int i = 0;
        int k = 0;
        int j = 0;
        while (i < first.length && k < last.length) {
            if (first[i] <= last[k]) {
                sortedArr[j] = first[i++];
                System.out.println("i: " + (i - 1) + " k: " + k + " sortedArr[" + (j - 1) + "] :" + sortedArr[j]);
            } else {
                sortedArr[j] = last[k++];
                System.out.println("i: " + i + " k: " + (k - 1) + " sortedArr[" + (j - 1) + "] :" + sortedArr[j]);
            }
            j++;
        }
        while (i < first.length) {
            System.out.println("i: " + i + " j: " + j + " sortedArr[" + j + "] :" + first[i]);
            sortedArr[j++] = first[i++];
        }
        while (k < last.length) {
            System.out.println("i: " + i + " j: " + j + " sortedArr[" + j + "] :" + last[k]);
            sortedArr[j++] = last[k++];
        }
        return sortedArr;
    }
}
