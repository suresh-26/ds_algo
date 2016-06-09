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
 * Created on Apr 5, 2016
 * Updated on $Date$
 */
package com.self.practice;

/**
 * @author suresh.gupta
 *
 */
public class sonarTest {
    public String str1() {
        return "adas";
    }

    public String str2() {
        return "adas";
    }

    public String str3() {
        return "adas";
    }

    public String all() {
        String status = null;
        if (checkForNull(str1())) {
            return status;
        }
        if (checkForNull(str2())) {
            return status;
        }
        if (checkForNull(str3())) {
            return status;
        }
        return "adfas";
    }

    boolean checkForNull(String status) {
        if (status != null) {
            return true;
        }
        return false;
    }
}
