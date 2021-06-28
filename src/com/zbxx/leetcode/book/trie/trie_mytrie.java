package com.zbxx.leetcode.book.trie;

import java.util.HashMap;
import java.util.Map;

public class trie_mytrie {

    TrieNode root;

    static class TrieNode {

        boolean isWord;

        Map<Character, TrieNode> nodes;

        TrieNode(boolean isWord) {
            this.isWord = isWord;
        }

    }

    /**
     * Initialize your data structure here.
     */
    public trie_mytrie() {
        root = new TrieNode(false);
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        char[] sr = word.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < sr.length; i++) {
            node = insert(node, sr[i]);
        }
        node.isWord = true;
    }

    private TrieNode insert(TrieNode node, char c) {
        if (node.nodes == null) {
            node.nodes = new HashMap<>();
        }
        TrieNode n = node.nodes.get(c);
        if (n == null) {
            n = new TrieNode(false);
            n.nodes.put(c, n);
        }
        return n;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        char[] sr = word.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < sr.length; i++) {
            node = search(node, sr[i]);
            if (node == null) {
                return false;
            }
        }
        return node.isWord;
    }

    private TrieNode search(TrieNode node, char c) {
        if (node.nodes == null) {
            return null;
        }
        return node.nodes.get(c);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        char[] sr = prefix.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < sr.length; i++) {
            node = search(node, sr[i]);
            if (node == null) {
                return false;
            }
        }
        return true;
    }

}
