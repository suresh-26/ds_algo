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
        System.out.println(getSubSetSize(intList));

    }

    private static int getSubSetSize(List<Integer> intList) {
        int largestSize = 0;
        List<Integer> validSet = new ArrayList<>();
        for (int i = 0; i < intList.size(); i++) {
            int size = 1;
            validSet = new ArrayList<>();
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
        }
        return largestSize;
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
