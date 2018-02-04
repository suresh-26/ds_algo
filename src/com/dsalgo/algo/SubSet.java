package com.dsalgo.algo;

import java.util.ArrayList;
import java.util.List;

public class SubSet {

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(6);
        intList.add(3);
        intList.add(15);
        intList.add(18);
        intList.add(5);

        List<List<Integer>> sets = getSubSetSize(intList);
        for(List<Integer> set: sets){
            System.out.println("=====New Set===========");
            for(int i: set){
                System.out.print(" "+i);
            }
            System.out.println();
        }

        //System.out.println(getSubSetSize(intList));

    }

    private static List<List<Integer>> getSubSetSize(List<Integer> intList) {
        int largestSize = 0;
        List<List<Integer>> validSets = new ArrayList<>();
        for (int i = 0; i < intList.size(); i++) {
            int size = 1;
            List<Integer> validSet = new ArrayList<>();
            validSet.add(i);
            for (int j = 0; j < intList.size(); j++) {
                if (i != j) {
                    if (verifyRule(validSet, intList.get(j))) {
                        validSet.add(j);
                        size++;
                    }
                }
            }
            if (largestSize < size) {
                largestSize = size;
            }
            validSets.add(validSet);
        }
        System.out.println(largestSize);
        return validSets;
    }

    private static boolean verifyRule(List<Integer> subSet, int nextInt) {
        boolean state = false;
        for (int i : subSet) {
            if ((i % nextInt == 0) || (nextInt % i == 0)) {
                state = true;
            } else {
                state = false;
                break;
            }
        }
        return state;
    }

}
