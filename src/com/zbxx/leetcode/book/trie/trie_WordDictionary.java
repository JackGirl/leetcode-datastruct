package com.zbxx.leetcode.book.trie;


import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * leetcode book trie 添加与搜索单词  .表示任意单词
 */
public class trie_WordDictionary {


    TrieNode root = new TrieNode();

    static class TrieNode {

        boolean isWord;

        Map<Character, TrieNode> nodes;

        TrieNode() {

        }

    }

    public void addWord(String word) {
        TrieNode n = root;
        char[] sr = word.toCharArray();
        for (char c : sr) {
            if (n.nodes == null) {
                n.nodes = new HashMap<>();
            }
            TrieNode child = n.nodes.getOrDefault(c, new TrieNode());
            n.nodes.put(c, child);
            n = child;
        }
        n.isWord = true;
    }


    /**
     * 用的字典树加bfs    在题解看到另外一种 直接根据单词长度放进map<Integer,List> 然后循环匹配
     *
     * @param word
     * @return
     */
    public boolean search(String word) {
        char[] sr = word.toCharArray();
        TrieNode node = root;
        Deque<TrieNode> deque = new LinkedList<>();
        deque.addLast(root);
        deque.addLast(null);
        for (int i = 0; i < sr.length - 1; i++) {
            while (deque.peek() != null) {
                TrieNode n = deque.pollFirst();
                if (sr[i] == '.') {
                    if (n.nodes != null) {
                        for (TrieNode value : n.nodes.values()) {
                            deque.addLast(value);
                        }
                    }
                } else {
                    if (n.nodes != null) {
                        TrieNode t = n.nodes.get(sr[i]);
                        if (t != null) {
                            deque.addLast(t);
                        }
                    }
                }
            }
            if (deque.peek() == null && !deque.isEmpty()) {
                deque.pollFirst();
                deque.addLast(null);
            }
        }
        if (!deque.isEmpty()) {
            while (deque.peek() != null) {
                TrieNode n = deque.pollFirst();
                if (sr[sr.length - 1] == '.') {
                    if (n.nodes != null) {
                        for (TrieNode value : n.nodes.values()) {
                            if (value.isWord) {
                                return true;
                            }
                        }
                    }
                } else {
                    if (n.nodes != null) {
                        TrieNode t = n.nodes.get(sr[sr.length - 1]);
                        if (t != null && t.isWord) {
                            return true;
                        }
                    }
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        trie_WordDictionary wordDictionary = new trie_WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("bae");
        System.out.println(wordDictionary.search("b.."));
    }


}
