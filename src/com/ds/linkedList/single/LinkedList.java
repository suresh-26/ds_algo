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

import java.util.HashSet;
import java.util.Set;

/**
 * @author suresh.gupta
 *
 */
class LinkedList
{
    protected Node start;
    protected Node end;
    public int size;

    /* Constructor */
    public LinkedList()
    {
        start = null;
        end = null;
        size = 0;
    }

    /* Function to check if list is empty */
    public boolean isEmpty()
    {
        return start == null;
    }

    /* Function to get size of list */
    public int getSize()
    {
        return size;
    }

    /* Function to insert an element at begining */
    public void insertAtStart(int val)
    {
        Node nptr = new Node(val, null);
        size++;
        if (start == null)
        {
            start = nptr;
            end = start;
        }
        else
        {
            nptr.setLink(start);
            start = nptr;
        }
    }

    /* Function to insert an element at end */
    public void insertAtEnd(int val)
    {
        Node nptr = new Node(val, null);
        size++;
        if (start == null)
        {
            start = nptr;
            end = start;
        }
        else
        {
            end.setLink(nptr);
            end = nptr;
        }
    }

    /* Function to insert an element at position */
    public void insertAtPos(int val, int pos)
    {
        Node nptr = new Node(val, null);
        Node ptr = start;
        pos = pos - 1;
        for (int i = 1; i < size; i++)
        {
            if (i == pos)
            {
                Node tmp = ptr.getLink();
                ptr.setLink(nptr);
                nptr.setLink(tmp);
                break;
            }
            ptr = ptr.getLink();
        }
        size++;
    }

    /* Function to delete an element at position */
    public void deleteAtPos(int pos)
    {
        if (pos == 1)
        {
            start = start.getLink();
            size--;
            return;
        }
        if (pos == size)
        {
            Node s = start;
            Node t = start;
            while (s != end)
            {
                t = s;
                s = s.getLink();
            }
            end = t;
            end.setLink(null);
            size--;
            return;
        }
        Node ptr = start;
        pos = pos - 1;
        for (int i = 1; i < size - 1; i++)
        {
            if (i == pos)
            {
                Node tmp = ptr.getLink();
                tmp = tmp.getLink();
                ptr.setLink(tmp);
                break;
            }
            ptr = ptr.getLink();
        }
        size--;
    }

    public void sortedInsert(int i) {
        if (isEmpty()) {
            insertAtEnd(i);
            return;
        }
        if (start.getData() > i) {
            start = new Node(i, start);
            return;
        }
        Node prevNode = start;
        Node currentNode = start;
        Node sortedNode = null;
        while (currentNode != null) {
            if (currentNode.getData() > i) {
                break;
            }
            prevNode = currentNode;
            currentNode = currentNode.getLink();
        }
        sortedNode = new Node(i, currentNode);
        prevNode.setLink(sortedNode);
    }

    public LinkedList append(LinkedList linkListToAppend) {
        if (linkListToAppend.isEmpty()) {
            return this;
        }
        Node ptr = linkListToAppend.start;
        while (ptr != null) {
            this.insertAtEnd(ptr.getData());
            ptr = ptr.getLink();
        }
        return this;
    }

    public LinkedList reverseHeadToTail() {
        if (this.isEmpty()) {
            return this;
        }
        Node temp = this.start;
        this.start = start.getLink();
        end.setLink(temp);
        temp.setLink(null);
        return this;
    }

    public LinkedList removeDuplicates() {
        if (this.isEmpty()) {
            return this;
        }
        Node ptr = this.start;
        Set<Integer> uniqueElems = new HashSet<Integer>();
        Node prevPtr = this.start;
        while (ptr != null) {
            if (!uniqueElems.add(ptr.getData())) {
                prevPtr.setLink(ptr.getLink());
            } else {
                prevPtr = ptr;
            }
            ptr = ptr.getLink();
        }
        return this;
    }

    /* Function to display elements */
    public void display()
    {
        System.out.print("\nSingly Linked List = ");
        if (size == 0)
        {
            System.out.print("empty\n");
            return;
        }
        if (start.getLink() == null)
        {
            System.out.println(start.getData());
            return;
        }
        Node ptr = start;
        System.out.print(start.getData() + "->");
        ptr = start.getLink();
        while (ptr.getLink() != null)
        {
            System.out.print(ptr.getData() + "->");
            ptr = ptr.getLink();
        }
        System.out.print(ptr.getData() + "\n");
    }

    /**
     * 
     */
    public LinkedList reverseLinkedList() {
        if (this.isEmpty()) {
            return this;
        }
        Node prev = this.start;
        Node next = this.start.getLink();
        Node newStartNode = new Node(prev.getData(), prev);
        // newStartNode.setLink(prev);
        prev = newStartNode;
        while (next != null) {
            newStartNode = new Node(next.getData(), next);
            next = next.getLink();
            newStartNode.setLink(prev);
            prev = newStartNode;
        }
        this.end = this.start;
        this.start = newStartNode;
        this.end.setLink(null);
        return this;
    }
}
