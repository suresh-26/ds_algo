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
 * Created on Oct 19, 2015
 * Updated on $Date$
 */
package com.self.practice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author suresh.gupta
 *
 */
public class TestClass {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // testForEach();
        // checkTokenizer("abc" + "," + "def");
        Queue<String> queue = new LinkedList<>();
        queue.add("one");
        queue.add("two");
        queue.add("three");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    static void testForEach() {
        Map<String, Object> formFields = new HashMap<String, Object>();
        FormField formField1 = new FormField();
        formField1.setName("form1");
        formFields.put("aa", formField1);
        FormField formField2 = new FormField();
        formField2.setName("form2");
        formFields.put("bb", formField2);
        formFields.forEach((key, value) -> {
            System.out.println(value);
        });
    }

    static void checkTokenizer(String uaHash) {
        StringTokenizer st2 = new StringTokenizer(uaHash, ",");
        uaHash = (String) st2.nextElement();
        String clientMemberId = (String) st2.nextElement();
        System.out.println(uaHash + ".........");
        System.out.println(clientMemberId);
    }

}
