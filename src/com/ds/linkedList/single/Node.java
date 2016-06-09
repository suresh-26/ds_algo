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
 * Created on Jan 16, 2016
 * Updated on $Date$
 */
package com.ds.linkedList.single;

/**
 * @author suresh.gupta
 *
 */

/* Class Node */
class Node
{
    protected int data;
    protected Node link;

    /* Constructor */
    public Node()
    {
        link = null;
        data = 0;
    }

    /* Constructor */
    public Node(int d, Node n)
    {
        data = d;
        link = n;
    }

    /* Function to set link to next Node */
    public void setLink(Node n)
    {
        link = n;
    }

    /* Function to set data to current Node */
    public void setData(int d)
    {
        data = d;
    }

    /* Function to get link to next node */
    public Node getLink()
    {
        return link;
    }

    /* Function to get data from current Node */
    public int getData()
    {
        return data;
    }
}
