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
package com.self.practice;

/**
 * @author suresh.gupta
 *
 */
public class PalindromString {

    private static String palStr = "asdbadabxytatjhmanamooo";

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str = "afsjfhak\\rad";
        System.out.println(str);
        String pattern = "\\\\r";
        String updated = str.replaceAll(pattern, "");
        System.out.println(updated);

    }
    /*
     * static Map<String, Integer> findPalindrome(String palindromStr) {
     * char[] chArrForward = palindromStr.toCharArray();
     * char[] charArrBackWard = palindromStr.toCharArray();
     * int j = 0;
     * int l = charArrBackWard.length - 1;
     * int count = 0;
     * String palStrFound = null;
     * for (int i = 0; i < charArrBackWard.length; i++) {
     * if (charArrBackWard[l--] == chArrForward[j++]) {
     * count++;
     * }
     * }
     * }
     */

}
