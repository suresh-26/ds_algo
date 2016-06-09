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
 * Created on Jan 11, 2016
 * Updated on $Date$
 */
package com.self.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author suresh.gupta
 *
 */
public class Hello {
    @FunctionalInterface
    public interface Consumer {
        void accept();
    }

    static void performRollback(String rollBackErrMsg, Consumer c) {
        try {
            c.accept();
        } catch (Exception e) {
            System.out.println(rollBackErrMsg);
        }
    }

    private enum RollBackType {
        MEMBER, MEMBER_EMAIL, MEMBER_PROFILE, MEMBER_ADDRESS, MEMBER_CARD, MEMBER_SERVICE, CUSTOM_PROFILE
    }

    private enum RollbackCreateForWeb {
        RollBackType, MEMBER_ADDRESS_LIST, MEMBER_CARD_LIST
    }

    // ()->System.out.println("roll back member");
    static int method(int element) {
        return element + 1;
    }

    public static void main(String[] args) {
        int x = 5 / 0;
        rollBack(RollBackType.MEMBER_EMAIL, RollBackType.MEMBER_CARD);
        // Create ArrayList and add four String elements.
        ArrayList<String> list = new ArrayList<>();
        list.add("cat");
        list.add("dog");
        list.add("cheetah");
        list.add("deer");

        // Remove elements that start with c.
        // list.removeIf(element -> element.startsWith("c"));
        // System.out.println(list.toString());
    }

    private List<String> nullCheck() {
        List<String> testList = new ArrayList<String>();
        testList.add("one");
        testList.add("two");
        testList.add(null);
        testList.add(null);
        return testList;
    }

    private static void rollBack(RollBackType... rollBackTypes) {

        for (RollBackType rollBackType : rollBackTypes) {
            switch (rollBackType) {
            case MEMBER:
                performRollback("member", () -> System.out.println("roll back member"));
                break;
            case MEMBER_EMAIL:
                performRollback("member", () -> System.out.println("roll back member EMAIL"));
                break;
            case MEMBER_PROFILE:
                performRollback("member", () -> System.out.println("roll back member PROFILE"));
                break;
            case CUSTOM_PROFILE:
                performRollback("member", () -> System.out.println("roll back member CUSTOM PROFILE"));
                break;
            case MEMBER_SERVICE:
                performRollback("member", () -> System.out.println("roll back member MEMBER SERVICE"));
                break;
            case MEMBER_ADDRESS:
                performRollback("member", () -> System.out.println("roll back member MEMBER ADDRESS"));
                break;
            case MEMBER_CARD:
                performRollback("member", () -> System.out.println("roll back member MEMBER CARD"));
                break;

            }
        }

    }

    public static void createMember(){
        abstract void doxyz();
        
    }
}
