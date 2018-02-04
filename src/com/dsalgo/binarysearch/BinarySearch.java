package com.dsalgo.binarysearch;

import java.util.Arrays;
import java.util.List;

public class BinarySearch {

	public static void main(String[] args) {
		List<Integer> arrList = Arrays.asList(0, 1, 2, 4, 6, 8, 9, 10);
		Integer[] arr = arrList.toArray(new Integer[8]);
		Integer[] newArr = Arrays.copyOfRange(arr, 4, 8);

		//System.out.println(binarySearch(arr, 11));
//        System.out.println(binary(arr, 1));
//        System.out.println(binary(arr, 2));
//        System.out.println(binary(arr, 4));
//        System.out.println(binary(arr, 6));
//        System.out.println(binary(arr, 8));
//        System.out.println(binary(arr, 9));
//        System.out.println(binary(arr, 10));
//        System.out.println(binary(arr, 0));

	}

	public static boolean binary(Integer[] nos, int no) {
        //System.out.println("array: "+nos);
        if(nos.length ==1) {
            if(no == nos[0]){
                return true;
            }else{
                return false;
            }
        }else {
        int mid = (nos.length-1) /2;
            if (no < nos[mid]) {
                return binary(Arrays.copyOfRange(nos, 0, mid), no);
            } else if (no > nos[mid]) {
                return binary(Arrays.copyOfRange(nos, mid + 1, nos.length), no);
            } else {
                return true;
            }
        }
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
