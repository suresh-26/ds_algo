package com.dsalgo.trie;

import java.util.HashMap;

public class TrieMap {

    Node root;

    public TrieMap(){
        root = null;
    }

    public void insert(String word) {
        char[] characters = word.toCharArray();
        if (root == null) {
            root = new Node(' ', new HashMap<>(), false);
        }
        Node ptr = root;
        for (int i = 0; i < characters.length; i++) {
            Node existingNode = null;
            if (ptr.getChildren() != null && !ptr.getChildren().isEmpty()) {
                existingNode = ptr.getChildren().get(characters[i]);
            }

            if (existingNode == null) {
                existingNode = new Node(characters[i], new HashMap<>(), false);
                ptr.setChildren(characters[i], existingNode);
            }
            ptr = existingNode;
        }
    }

    public boolean search(String word) {
        char[] chars = word.toCharArray();
        boolean result = false;
        if (root == null || word.isEmpty()) {
            return result;
        }
        Node ptr = root;
        for (int i = 0; i < chars.length; i++) {
            if (!ptr.getChildren().isEmpty() && ptr.getChildren().get(chars[i]) != null) {
                ptr = ptr.getChildren().get(chars[i]);
                result = true;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }

    public void display(){

    }

}
