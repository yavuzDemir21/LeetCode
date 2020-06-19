package Hard;

import Structures.TrieNode;

import java.util.ArrayList;

import java.util.List;


public class Word_Search_2 {
    public static void main(String[] args) {
        char[][] board = {{'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}};

        String[] words = {"oath","pea","eat","rain"};
        exist(board, words).forEach(System.out::println);
    }

    private static List<String> exist(char[][] board, String[] words){
        TrieNode root = trieGraph(words);
        List<String> result = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                search(board, i, j, root, result);

            }
        }

        return result;


    }

    private static void search(char[][] board, int row, int col, TrieNode trieNode, List<String> res){

        if(trieNode.word != null) {
            res.add(trieNode.word);
            trieNode.word = null;
        }

        if(row<0 || row >= board.length || col < 0 || col >= board[0].length) return;
        char c = board[row][col];
        if(c == '#') return;

        TrieNode next = trieNode.next[c-'a'];

        if(next == null) return;

        board[row][col] = '#';

        search(board, row+1, col, next, res);
        search(board, row-1, col, next, res);
        search(board, row, col+1, next, res);
        search(board, row, col-1, next, res);

        board[row][col] = c;


    }


    private static TrieNode trieGraph(String[] words){
        TrieNode root = new TrieNode();
        for(String word : words){
            TrieNode w = root;
            for(char c : word.toCharArray()){
                int index = c - 'a';
                if(w.next[index] == null) w.next[index] = new TrieNode();
                w = w.next[index];
            }
            w.word = word;
        }
        return root;
    }


}
