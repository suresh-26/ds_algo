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
public class LinkedListRunner
{
    public static void main(String[] args)
    {
        // insertIntoSortedList();
        // testAppend();
        //reverseHeadToTail();
        
        //reverseList();
        //SinLinkedListWithEndPointer list = new SinLinkedListWithEndPointer();
        SingleLinkedList list = new SingleLinkedList();
        linkedListFromUserInput(list);
    }

    public static void reverseList() {
        SinLinkedListWithEndPointer oldSinLinkedListWithEndPointer = new SinLinkedListWithEndPointer();
        oldSinLinkedListWithEndPointer.insertAtEnd(2);
        oldSinLinkedListWithEndPointer.insertAtEnd(3);
        oldSinLinkedListWithEndPointer.insertAtEnd(4);
        oldSinLinkedListWithEndPointer.insertAtEnd(7);
        oldSinLinkedListWithEndPointer.insertAtEnd(9);
        oldSinLinkedListWithEndPointer.display();
        oldSinLinkedListWithEndPointer.reverseLinkedList();
        oldSinLinkedListWithEndPointer.display();
    }

    public static void testAppend() {
        SinLinkedListWithEndPointer oldSinLinkedListWithEndPointer = new SinLinkedListWithEndPointer();

        oldSinLinkedListWithEndPointer.insertAtEnd(2);
        oldSinLinkedListWithEndPointer.insertAtEnd(3);
        oldSinLinkedListWithEndPointer.insertAtEnd(4);
        oldSinLinkedListWithEndPointer.insertAtEnd(7);
        oldSinLinkedListWithEndPointer.display();

        SinLinkedListWithEndPointer linkListToAppend = new SinLinkedListWithEndPointer();
        linkListToAppend.insertAtEnd(5);
        linkListToAppend.insertAtEnd(8);
        linkListToAppend.insertAtEnd(10);

        oldSinLinkedListWithEndPointer.append(linkListToAppend);

        oldSinLinkedListWithEndPointer.display();
    }

    public static void removeDuplicates() {
        SinLinkedListWithEndPointer oldSinLinkedListWithEndPointer = new SinLinkedListWithEndPointer();

        oldSinLinkedListWithEndPointer.insertAtEnd(2);
        oldSinLinkedListWithEndPointer.insertAtEnd(3);
        oldSinLinkedListWithEndPointer.insertAtEnd(2);
        oldSinLinkedListWithEndPointer.insertAtEnd(4);
        oldSinLinkedListWithEndPointer.insertAtEnd(7);
        oldSinLinkedListWithEndPointer.insertAtEnd(4);
        oldSinLinkedListWithEndPointer.display();
        oldSinLinkedListWithEndPointer.removeDuplicates();
        oldSinLinkedListWithEndPointer.display();

    }

    public static void reverseHeadToTail() {
        SinLinkedListWithEndPointer oldSinLinkedListWithEndPointer = new SinLinkedListWithEndPointer();

        oldSinLinkedListWithEndPointer.insertAtEnd(2);
        oldSinLinkedListWithEndPointer.insertAtEnd(3);
        oldSinLinkedListWithEndPointer.insertAtEnd(2);
        oldSinLinkedListWithEndPointer.insertAtEnd(4);
        oldSinLinkedListWithEndPointer.insertAtEnd(7);
        oldSinLinkedListWithEndPointer.insertAtEnd(4);
        oldSinLinkedListWithEndPointer.display();
        oldSinLinkedListWithEndPointer.reverseHeadToTail();
        oldSinLinkedListWithEndPointer.display();
    }

    public static void insertIntoSortedList() {
        SinLinkedListWithEndPointer sortedSinLinkedListWithEndPointer = new SinLinkedListWithEndPointer();

        sortedSinLinkedListWithEndPointer.insertAtEnd(2);
        sortedSinLinkedListWithEndPointer.insertAtEnd(3);
        sortedSinLinkedListWithEndPointer.insertAtEnd(4);
        sortedSinLinkedListWithEndPointer.insertAtEnd(7);
        sortedSinLinkedListWithEndPointer.insertAtEnd(9);

        sortedSinLinkedListWithEndPointer.display();
        sortedSinLinkedListWithEndPointer.sortedInsert(1);
        sortedSinLinkedListWithEndPointer.sortedInsert(5);
        sortedSinLinkedListWithEndPointer.display();
    }

    public static void sortExisting(SinLinkedListWithEndPointer unsortedList, int[] dataToInsert) {

    }

    public static SinLinkedListWithEndPointer sortedInsert(SinLinkedListWithEndPointer sortedList, int i) {

        return sortedList;
    }

    public static void linkedListFromUserInput(LinkedList list) {
        Scanner scan = new Scanner(System.in);
        /* Creating object of class linkedList */
        //SinLinkedListWithEndPointer list = new SinLinkedListWithEndPointer();
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
