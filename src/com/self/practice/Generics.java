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
 * Created on Dec 28, 2015
 * Updated on $Date$
 */
package com.self.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author suresh.gupta
 *
 */
public class Generics {

    public static void main(String[] args) {
        Generics generics = new Generics();
        generics.diffBwTypeAsObjectClassAndWithoutGenerics();
    }

    // diff between List<Object> and List ??
    void diffBwTypeAsObjectClassAndWithoutGenerics() {
        List<Object> objectTypelist;
        objectTypelist = new ArrayList<Object>();
        objectTypelist.add("sdsd");
        objectTypelist.add(1234);
        String val1 = (String) objectTypelist.get(0);
        int val2 = (Integer) objectTypelist.get(1);
        // int val3 = (Integer) objectTypelist.get(0); // runtime error, converting String into int
        System.out.println("val1: " + val1 + " val2: " + val2);

    }

    public static void printListObj(List<Object> list) {
        for (Object elem : list)
            System.out.println(elem + " ");
        System.out.println();
    }

    public static void printListUnbounded(List<?> list) {
        for (Object elem : list)
            System.out.print(elem + " ");
        System.out.println();
    }
}
