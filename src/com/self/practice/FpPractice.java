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
 * Created on Apr 7, 2016
 * Updated on $Date$
 */
package com.self.practice;

import java.util.function.UnaryOperator;

/**
 * @author suresh.gupta
 *
 */
public class FpPractice {
    public static void main(String[] args) {
        FpPractice fpPractice = new FpPractice();
        fpPractice.checkLambdaScope();

        String a = null;
        String b = null;
        System.out.println(a.equals(b));
    }

    public void checkLambdaScope() {
        int diff = 10;
        EmployeePojo employeePojo = new EmployeePojo(diff);
        UnaryOperator<Integer> operator = diff2 -> {
            employeePojo.setId(25);
            System.out.println("inLambda:" + employeePojo.getId());
            return (diff2 + employeePojo.getId()) * 100;
        };
        System.out.println(operator.apply(15));
        System.out.println(employeePojo.getId());
    }

}
