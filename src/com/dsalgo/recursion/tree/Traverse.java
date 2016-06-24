package com.dsalgo.recursion.tree;

import com.dsalgo.tree.bst.BinarySearchTree;
import com.dsalgo.tree.bst.BinaryNode;

public class Traverse {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public static boolean isBst(BinarySearchTree binarySearchTree) {
        BinaryNode left = binarySearchTree.root.getRight();
        BinaryNode right = binarySearchTree.root.getLeft();
        BinaryNode root = binarySearchTree.root;
        while (left != null) {
            if (!(left.getData() < root.getData())) {
                return false;
            }
            root = left;
            left = left.getLeft();
        }
        root = binarySearchTree.root;
        while (left != null) {
            if (!(left.getData() < root.getData())) {
                return false;
            }
            root = left;
            left = left.getLeft();
        }
        return true;
    }

}
