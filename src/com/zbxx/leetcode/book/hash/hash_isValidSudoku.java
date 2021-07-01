package com.zbxx.leetcode.book.hash;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * leetcode  book hash 有效的数独
 */
public class hash_isValidSudoku {


    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> row = new HashMap<>();
        Map<Integer, Set<Character>> col = new HashMap<>();
        Map<Integer, Set<Character>> ceil = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                Set<Character> colSet = col.getOrDefault(j, new HashSet<>());
                Set<Character> rowSet = row.getOrDefault(i, new HashSet<>());
                int ceilKey = (i / 3) * 3 + (j / 3);
                Set<Character> ceilSet = ceil.getOrDefault(ceilKey, new HashSet<>());
                if (rowSet.contains(board[i][j]) || colSet.contains(board[i][j]) || ceilSet.contains(board[i][j])) {
                    return false;
                }
                colSet.add(board[i][j]);
                rowSet.add(board[i][j]);
                ceilSet.add(board[i][j]);
                row.put(i, rowSet);
                col.put(j, colSet);
                ceil.put(ceilKey, ceilSet);
            }
        }
        return true;
    }


    public static void main(String[] args) {
        char[][] sr = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(new hash_isValidSudoku().isValidSudoku(sr));
    }

}
