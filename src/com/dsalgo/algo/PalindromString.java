/*
 * Copyright (c) Rakuten, Inc. All Rights Reserved.
 * 
 * This program is the information assets which are handled
 * as "Strictly Confidential".
 * Permission of Use is only admitted in Rakuten Inc.
 * Development Department.
 * If you don't have permission , MUST not be published,
 * broadcast, rewritten for broadcast or publication
 * or redistributed directly or indirectly in any medium.
 * 
 * $Id$
 * Created on Jan 9, 2016
 * Updated on $Date$
 */
package com.dsalgo.algo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author suresh.gupta
 *
 */
public class PalindromString {

    private static String palStr = "gadsbcfmamkldklopolkdlk";
    // private static String palStr = "asmamjhrajar";

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(getLongestPalindrome(palStr));
        Queue<String> queue = new LinkedList<String>();
        queue.add(palStr);
        computeLargestSubString(queue);
    }

    private static String getLongestPalindrome(String str) {
        char[] currentPalindrome = new char[str.length()];
        char[] longestPalindrome = new char[str.length()];
        int currentPalLenght = 0;
        int largestPalLength = 0;
        boolean seqStarted = false;
        char[] strArr = str.toCharArray();
        for (int i = 0; i < strArr.length; i++) {
            int l = i;
            for (int j = strArr.length - 1; j >= i; j--) {
                if (strArr[l] == strArr[j]) {
                    currentPalindrome[currentPalLenght++] = strArr[l++];
                    seqStarted = true;
                } else {
                    if (currentPalLenght > largestPalLength) {
                        largestPalLength = currentPalLenght;
                        longestPalindrome = currentPalindrome;
                        currentPalLenght = 0;
                        currentPalindrome = new char[str.length()];
                        seqStarted = true;
                        break;
                    }
                    if (seqStarted) {
                        seqStarted = true;
                        break;
                    }
                }
            }

        }
        return String.valueOf(longestPalindrome);
    }

    public static void computeLargestSubString(final Queue<String> queue) {
        String stringToprocess = queue.poll();
        if (checkPalindrome(stringToprocess)) {
            System.out.println(stringToprocess);
        } else {
            queue.add(stringToprocess.substring(1));
            queue.add(stringToprocess.substring(0, stringToprocess.length() - 1));
            computeLargestSubString(queue);
        }
    }

    private static boolean checkPalindrome(String s) {
        boolean result = false;
        if (s.length() <= 1)
            return true;
        if (s.charAt(0) == s.charAt(s.length() - 1))
            result = checkPalindrome(s.substring(1, s.length() - 1));
        else
            return false;
        return result;
    }
}
