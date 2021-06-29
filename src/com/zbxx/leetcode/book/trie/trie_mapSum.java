package com.zbxx.leetcode.book.trie;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * leetcode book trie 键值映射
 */
public class trie_mapSum {


    TrieNode root;

    static class TrieNode {

        int val;

        Map<Character, TrieNode> nodes;

        TrieNode() {

        }

    }

    public trie_mapSum() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        char[] sr = key.toCharArray();
        TrieNode n = root;
        for (char t : sr) {
            if (n.nodes == null) {
                n.nodes = new HashMap<>();
            }
            TrieNode child = n.nodes.getOrDefault(t, new TrieNode());
            n.nodes.put(t, child);
            n = child;
        }
        n.val = val;
    }

    public int sum(String prefix) {
        int[] vals = {0};
        char[] sr = prefix.toCharArray();
        TrieNode n = root;
        for (int i = 0; i < sr.length; i++) {
            if (n.nodes == null) {
                return 0;
            }
            n = n.nodes.get(sr[i]);
            if (n == null) {
                return 0;
            }
        }
        dfs(n, vals);
        return vals[0];
    }

    public void dfs(TrieNode node, int[] vals) {
        if (node == null) {
            return;
        }
        vals[0] += node.val;
        if (node.nodes != null) {
            Collection<TrieNode> s = node.nodes.values();
            for (TrieNode trieNode : s) {
                dfs(trieNode, vals);
            }
        }
    }


    public static void main(String[] args) {
        trie_mapSum mapSum = new trie_mapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("app"));
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("app"));
    }


}
