package com.dsalgo.tree;

import com.dsalgo.tree.bst.BinarySearchTree;

public class BSTRunner {
    // Test program
    public static void main(String[] args) {
        BinarySearchTree b = new BinarySearchTree();
        b.insert(1);
        b.insert(3);
        b.insert(7);
        b.insert(8);
        b.insert(5);
        b.insert(0);
        b.insert(12);
        // b.insert(9);
        // b.insert(20);
        // b.insert(25);
        // b.insert(15);
        // b.insert(16);
        System.out.println("Original Tree : ");
        b.displayAsTree(b.root);
        System.out.println("does 13 exist in bst? A:" + b.findRecursively(b.root, 15));
        // System.out.println("");
        // System.out.println("Check whether Node with value 4 exists : " + b.find(4));
        // System.out.println("Delete Node with no children (2) : " + b.delete(2));
        // b.display(b.root);
        // System.out.println("\n Delete Node with one child (4) : " + b.delete(4));
        // b.display(b.root);
        // System.out.println("\n Delete Node with Two children (10) : " + b.delete(10));
        // b.display(b.root);
    }
}
