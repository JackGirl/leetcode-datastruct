package com.zbxx.leetcode.book.trie;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode book trie 单词替换
 */
public class trie_replaceWords {


    TrieNode root = new TrieNode();

    static class TrieNode {

        boolean isWord;

        Map<Character, TrieNode> nodes;

        TrieNode() {
        }
    }


    public String replaceWords(List<String> dictionary, String sentence) {
        for (String word : dictionary) {
            insert(word);
        }
        StringBuilder builder = new StringBuilder();
        String[] words = sentence.split("\\s");
        for (int i = 0; i < words.length; i++) {
            builder.append(search(words[i]));
            if (i < words.length - 1) {
                builder.append(" ");
            }
        }

        return builder.substring(0, builder.length());
    }

    public String search(String word) {
        char[] sr = word.toCharArray();
        TrieNode node = root;
        StringBuilder s = new StringBuilder();
        for (char c : sr) {
            if (node.nodes == null) {
                return "";
            }
            node = node.nodes.get(c);
            if (node == null) {
                return word;
            }
            s.append(c);
            if (node.isWord) {
                return s.toString();
            }
        }
        return word;
    }

    public void insert(String word) {
        char[] sr = word.toCharArray();
        TrieNode node = root;
        for (char c : sr) {
            if (node.nodes == null) {
                node.nodes = new HashMap<>();
            }
            TrieNode child = node.nodes.get(c);
            if (child == null) {
                child = new TrieNode();
                node.nodes.put(c, child);
            }
            node = child;
        }
        node.isWord = true;
    }


}
