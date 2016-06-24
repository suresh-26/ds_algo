package com.dsalgo.tree.bst;

public class BinarySearchTree {

    public BinaryNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public boolean find(int id) {
        BinaryNode current = root;
        while (current != null) {
            if (current.data == id) {
                return true;
            } else if (current.data > id) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    public boolean findRecursively(BinaryNode current, int id) {
        if (current.data == id) {
            return true;
        }
        if (id < current.data && current.left != null) {
            return findRecursively(current.left, id);
        } else if (id > current.data && current.right != null) {
            return findRecursively(current.right, id);
        }
        return false;

    }

    public boolean delete(int id) {
        BinaryNode parent = root;
        BinaryNode current = root;
        boolean isLeftChild = false;
        while (current.data != id) {
            parent = current;
            if (current.data > id) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
            if (current == null) {
                return false;
            }
        }
        // if i am here that means we have found the node
        // Case 1: if node to be deleted has no children
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            }
            if (isLeftChild == true) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        // Case 2 : if node to be deleted has only one child
        else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else if (current.left != null && current.right != null) {

            // now we have found the minimum element in the right sub tree
            BinaryNode successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    public BinaryNode getSuccessor(BinaryNode deleleNode) {
        BinaryNode successsor = null;
        BinaryNode successsorParent = null;
        BinaryNode current = deleleNode.right;
        while (current != null) {
            successsorParent = successsor;
            successsor = current;
            current = current.left;
        }
        // check if successor has the right child, it cannot have left child for
        // sure
        // if it does have the right child, add it to the left of
        // successorParent.
        // successsorParent
        if (successsor != deleleNode.right) {
            successsorParent.left = successsor.right;
            successsor.right = deleleNode.right;
        }
        return successsor;
    }

    public void insert(int id) {
        BinaryNode newNode = new BinaryNode(id);
        if (root == null) {
            root = newNode;
            return;
        }
        BinaryNode current = root;
        BinaryNode parent = null;
        while (true) {
            parent = current;
            if (id < current.data) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    return;
                }
            }
        }
    }

    public void display(BinaryNode root) {
        if (root != null) {
            display(root.left);
            System.out.print(" " + root.data);
            display(root.right);
        }
    }

    public void displayAsTree(BinaryNode root) {
        if (root != null) {
            printTree(root);
            displayAsTree(root.left);
            printTree(root);
            displayAsTree(root.right);
        }
    }

    public void printTree(BinaryNode root) {
        if (!root.isVisited) {
            System.out.println("root: " + root.data);
            if (root.left != null) {
                System.out.print("left: " + root.left.data);
            } else {
                System.out.print("left: null");
            }
            if (root.right != null) {
                System.out.print(" right: " + root.right.data);
            } else {
                System.out.print(" right: null");
            }
            System.out.println();
        }
        root.isVisited = true;
    }
}
