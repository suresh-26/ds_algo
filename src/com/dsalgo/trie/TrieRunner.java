package com.dsalgo.trie;

public class TrieRunner {
    public static void main(String[] args)
    {
        TrieMap trie = new TrieMap();
        trie.insert("tea");
        trie.insert("tell");
        System.out.println(trie);
        System.out.println(trie.search("task"));
        System.out.println(trie.search("tell"));
        System.out.println(trie.search("tea"));
        System.out.println(trie.search("tend"));

    }
}
