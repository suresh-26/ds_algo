package com.dsalgo.binarysearch;

import java.util.Arrays;
import java.util.List;

public class BinarySearch {

	public static void main(String[] args) {
		List<Integer> arrList = Arrays.asList(1, 2, 4, 6, 8, 9, 10);
		Integer[] arr = arrList.toArray(new Integer[7]);
		System.out.println(binarySearch(arr, 11));
	}

	public static boolean binarySearch(Integer[] arr, int i) {
		return getNumber(arr, 0, arr.length - 1, i);
	}

	public static boolean getNumber(Integer arr[], int start, int end, int no) {
		int midIndex = (start + end) / 2;
		if (start < end) {

			if (no < arr[midIndex]) {
				return getNumber(arr, start, midIndex, no);
			} else if (no > arr[midIndex]) {
				return getNumber(arr, midIndex + 1, end, no);
			} else {
				return true;
			}

		}
		return false;
	}

}
