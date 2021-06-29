package com.zbxx.leetcode.book.trie;


import java.util.*;

/**
 * leetcode book trie  findWords
 */
public class trie_findwords {

    TrieNode root = new TrieNode();

    static class TrieNode {
        boolean                  isWord;
        Map<Character, TrieNode> chars;

        public TrieNode insert(String s) {
            char[] sr = s.toCharArray();
            TrieNode node = this;
            for (char c : sr) {
                if (node.chars == null) {
                    node.chars = new HashMap<>();
                }
                TrieNode cNode = node.chars.get(c);
                if (cNode == null) {
                    cNode = new TrieNode();
                }
                node.chars.put(c, cNode);
                node = cNode;
            }
            node.isWord = true;
            return node;
        }

    }

    /**
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        for (String s : words) {
            root.insert(s);
        }

        List<String> result = new ArrayList<>();
        Set<String> word = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                recursion(i, j, board, new HashSet<>(), root, word, new StringBuilder());
            }
        }
        for (String s : words) {
            if (word.contains(s)) {
                result.add(s);
            }
        }
        return result;
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private boolean recursion(int i, int j, char[][] board, Set<Integer> visited, TrieNode node, Set<String> word, StringBuilder builder) {
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1) {
            return false;
        }
        if (visited.contains(i * board.length + j)) {
            return false;
        }
        if (node.chars == null || node.chars.get(board[i][j]) == null) {
            return false;
        }
        builder.append(board[i][j]);
        TrieNode child = node.chars.get(board[i][j]);
        visited.add(i * board.length + j);
        if (child.isWord) {
            word.add(builder.toString());
        }
        for (int i1 = 0; i1 < dirs.length; i1++) {
            int x = i + dirs[i1][0];
            int y = j + dirs[i1][1];
            boolean r = recursion(x, y, board, visited, child, word, builder);
            if (r) {
                builder.deleteCharAt(builder.length() - 1);
                visited.remove(x * board.length + y);
            }
        }
        return true;
    }


}
