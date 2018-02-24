package com.dsalgo.algo.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationalSum {

    public static void main(String [] args){

        int [] arr = {8,2,2,4,4,6};
        new CombinationalSum().getPairs(arr, 8);
    }

    public List<List<Integer>> getPairs(int []arr, int sum){

        Arrays.sort(arr);
        arr = removeDuplicates(arr);
        for(int i: arr){
            System.out.println(i);
        }

        List<List<Integer>> result = new ArrayList<>();
        pairs(arr, sum, result, new ArrayList<>(), 0);
        return result;

    }

    public int[] removeDuplicates(int[] arr){
        int i = 0;
        for(int j = i+1; j < arr.length; j++){
            if(arr[j] == arr[i]){
                arr = removeElement(arr, j);
                j--;
            }else {
                i++;
            }
        }
        return arr;
    }

    public int[] removeElement(int[] arr, int removedIdx) {

        int[] result = new int[arr.length - 1];

        int j = 0;
        for(int i = 0; i < result.length; i++){
            if(i == removedIdx){
                result[i] = arr[++j];
            }else{
                result[i] = arr[j];
            }
            j++;
        }

        return result;

        //System.arraycopy(arr, removedIdx + 1, arr, removedIdx, arr.length - 1 - removedIdx);
    }

    public void pairs(int []arr, int sum, List<List<Integer>> result, List<Integer> accumulator, int index){
        if(sum == 0){
            result.add(accumulator);
            return;
        }
        while(index < arr.length && sum - arr[index] >=0){
            // Till every element in the array starting
            // from i which can contribute to the sum
            accumulator.add(arr[index]); // add them to list

            // recur for next numbers
            pairs(arr, sum - arr[index], result,  accumulator, index);
            index++;

            // remove number from list (backtracking)
            accumulator.remove(accumulator.size()-1);
        }
    }


}
