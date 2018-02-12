package com.dsalgo.sort.mergesort;

import java.util.Arrays;

public class MergeSort {
    int[] sortedArr = new int[4];
    public static void main(String[] args) {
        int[] arr = { 5, 2, 3, 7, 1 };
        int[] sortedArr = new MergeSort().mergeSort(arr, 0, arr.length -1 );
        //int[] sortedArr = mergeSort(arr);
        System.out.println("length: "+arr.length);
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
        return merge(first, second, arr);
    }

    public static int[] merge(int[] first, int[] last, int[] sortedArr) {
        int i = 0;
        int k = 0;
        int j = 0;
        while (i < first.length && k < last.length) {
            if (first[i] <= last[k]) {
                sortedArr[j] = first[i++];
                System.out.println("i: " + (i - 1) + " k: " + k + " sortedArr[" + j + "] :" + sortedArr[j]);
            } else {
                sortedArr[j] = last[k++];
                System.out.println("i: " + i + " k: " + (k - 1) + " sortedArr[" + j  + "] :" + sortedArr[j]);
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

    public int[] mergeSort(int[] arr, int start, int end) {
        int length = (end - start);
        if (length < 1) {
            int[] arr2 = {arr[start]};
            return arr2;
        }

        int midInd = (end + start) / 2;
        mergeSort(arr, start, midInd);
        mergeSort(arr, midInd+1, end);
       return merge(arr, start, midInd, end);
    }

    private int[] merge(int[] arr, int start, int midIndex, int end){
        int i = 0;
        int j = start;
        int k = midIndex + 1;
        int[] sortedArr = new int[(end-start)+1];
        while(j <= midIndex && k <= end){
            if(arr[j] <= arr[k]){
                sortedArr[i++] = arr[j++];
            }else{
                sortedArr[i++] = arr[k++];
            }
        }
        while (j <= midIndex){
            sortedArr[i++] = arr[j++];
        }
        while(k <= end){
            sortedArr[i++] = arr[k++];
        }
        int l = start;
        int m = 0;
        while(m < i) {
            arr[l] = sortedArr[m++];
            l++;
        }
        return sortedArr;
    }
}
