package com.dsalgo.trie;

import java.util.HashMap;

public class Node {
    private char content;
    private HashMap<Character, Node> children = new HashMap<>();
    private boolean isWord;

    public Node(char content, HashMap<Character, Node> children, boolean isWord){
        this.setContent(content);
        this.children = children;
        this.setWord(isWord);
    }

    public char getContent() {
        return content;
    }

    public void setContent(char content) {
        this.content = content;
    }

    public HashMap<Character, Node> getChildren() {
        return children;
    }

    public void setChildren(char c, Node node) {
            this.children.put(c, node);
    }

    public boolean isWord() {
        return isWord;
    }

    public void setWord(boolean word) {
        isWord = word;
    }
}
