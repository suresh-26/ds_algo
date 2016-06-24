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
package com.dsalgo.linkedList.single;

import java.util.Scanner;

/**
 * @author suresh.gupta
 *
 */
public class SinglyLinkedList
{
    public static void main(String[] args)
    {
        // insertIntoSortedList();
        // testAppend();
        //reverseHeadToTail();
        
        reverseList();
    }

    public static void reverseList() {
        LinkedList oldLinkedList = new LinkedList();
        oldLinkedList.insertAtEnd(2);
        oldLinkedList.insertAtEnd(3);
        oldLinkedList.insertAtEnd(4);
        oldLinkedList.insertAtEnd(7);
        oldLinkedList.insertAtEnd(9);
        oldLinkedList.display();
        oldLinkedList.reverseLinkedList();
        oldLinkedList.display();
    }

    public static void testAppend() {
        LinkedList oldLinkedList = new LinkedList();

        oldLinkedList.insertAtEnd(2);
        oldLinkedList.insertAtEnd(3);
        oldLinkedList.insertAtEnd(4);
        oldLinkedList.insertAtEnd(7);
        oldLinkedList.display();

        LinkedList linkListToAppend = new LinkedList();
        linkListToAppend.insertAtEnd(5);
        linkListToAppend.insertAtEnd(8);
        linkListToAppend.insertAtEnd(10);

        oldLinkedList.append(linkListToAppend);

        oldLinkedList.display();
    }

    public static void removeDuplicates() {
        LinkedList oldLinkedList = new LinkedList();

        oldLinkedList.insertAtEnd(2);
        oldLinkedList.insertAtEnd(3);
        oldLinkedList.insertAtEnd(2);
        oldLinkedList.insertAtEnd(4);
        oldLinkedList.insertAtEnd(7);
        oldLinkedList.insertAtEnd(4);
        oldLinkedList.display();
        oldLinkedList.removeDuplicates();
        oldLinkedList.display();

    }

    public static void reverseHeadToTail() {
        LinkedList oldLinkedList = new LinkedList();

        oldLinkedList.insertAtEnd(2);
        oldLinkedList.insertAtEnd(3);
        oldLinkedList.insertAtEnd(2);
        oldLinkedList.insertAtEnd(4);
        oldLinkedList.insertAtEnd(7);
        oldLinkedList.insertAtEnd(4);
        oldLinkedList.display();
        oldLinkedList.reverseHeadToTail();
        oldLinkedList.display();
    }

    public static void insertIntoSortedList() {
        LinkedList sortedLinkedList = new LinkedList();

        sortedLinkedList.insertAtEnd(2);
        sortedLinkedList.insertAtEnd(3);
        sortedLinkedList.insertAtEnd(4);
        sortedLinkedList.insertAtEnd(7);
        sortedLinkedList.insertAtEnd(9);

        sortedLinkedList.display();
        sortedLinkedList.sortedInsert(1);
        sortedLinkedList.sortedInsert(5);
        sortedLinkedList.display();
    }

    public static void sortExisting(LinkedList unsortedList, int[] dataToInsert) {

    }

    public static LinkedList sortedInsert(LinkedList sortedList, int i) {

        return sortedList;
    }

    public static void linkedListFromUserInput() {
        Scanner scan = new Scanner(System.in);
        /* Creating object of class linkedList */
        LinkedList list = new LinkedList();
        System.out.println("Singly Linked List Test\n");
        char ch;
        /* Perform list operations */
        do
        {
            System.out.println("\nSingly Linked List Operations\n");
            System.out.println("1. insert at begining");
            System.out.println("2. insert at end");
            System.out.println("3. insert at position");
            System.out.println("4. delete at position");
            System.out.println("5. check empty");
            System.out.println("6. get size");
            int choice = scan.nextInt();
            switch (choice)
            {
            case 1:
                System.out.println("Enter integer element to insert");
                list.insertAtStart(scan.nextInt());
                break;
            case 2:
                System.out.println("Enter integer element to insert");
                list.insertAtEnd(scan.nextInt());
                break;
            case 3:
                System.out.println("Enter integer element to insert");
                int num = scan.nextInt();
                System.out.println("Enter position");
                int pos = scan.nextInt();
                if (pos <= 1 || pos > list.getSize())
                    System.out.println("Invalid position\n");
                else
                    list.insertAtPos(num, pos);
                break;
            case 4:
                System.out.println("Enter position");
                int p = scan.nextInt();
                if (p < 1 || p > list.getSize())
                    System.out.println("Invalid position\n");
                else
                    list.deleteAtPos(p);
                break;
            case 5:
                System.out.println("Empty status = " + list.isEmpty());
                break;
            case 6:
                System.out.println("Size = " + list.getSize() + " \n");
                break;
            default:
                System.out.println("Wrong Entry \n ");
                break;
            }
            /* Display List */
            list.display();
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');
    }
}
