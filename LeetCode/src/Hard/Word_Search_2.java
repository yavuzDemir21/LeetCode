package Hard;

import Structures.TrieNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;


public class Word_Search_2 {
    public static void main(String[] args) {
        char[][] board = {{'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}};

        String[] words = {"oath","pea","eat","rain"};
        exist2(board, words).forEach(System.out::println);
    }

    private static List<String> exist2(char[][] board, String[] words){
        TrieNode root = trieGraph(words);
        List<String> result = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                search4(board, i, j, root, result);

            }
        }

        return result;


    }

    private static List<String> exist(char[][] board, String[] words) {

        HashSet<String> wordSet = constructWords(words);
        HashSet<String> possibles = constructSet(words);

        List<String> result = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                search3(board,i,j,wordSet, possibles, new StringBuilder(), result);

            }
        }

        return result;
    }

    private static void search4(char[][] board, int row, int col, TrieNode trieNode, List<String> res){

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

        search4(board, row+1, col, next, res);
        search4(board, row-1, col, next, res);
        search4(board, row, col+1, next, res);
        search4(board, row, col-1, next, res);

        board[row][col] = c;


    }


    private static void search3(char[][] board,
                                   int row,
                                   int col,
                                   HashSet<String> words,
                                   HashSet<String> set,
                                   StringBuilder sb,
                                   List<String> res){

        if(row<0 || row >= board.length || col < 0 || col >= board[0].length) return;

        sb.append(board[row][col]);



        if(!set.contains(sb.toString())){
            sb.deleteCharAt(sb.length()-1);
            return;
        }

        if(words.contains(sb.toString())){
            res.add(sb.toString());
            words.remove(sb.toString());
        }


        board[row][col] ^= 256;

        search3(board, row+1, col, words, set, sb, res);
        search3(board, row-1, col, words, set, sb, res);
        search3(board, row, col+1, words, set, sb, res);
        search3(board, row, col-1, words, set, sb, res);

        board[row][col] ^= 256;

        sb.deleteCharAt(sb.length()-1);


    }

    private static HashSet<String> constructWords(String[] words){
        HashSet<String> set = new HashSet<>();
        Collections.addAll(set, words);
        return set;
    }

    private static HashSet<String> constructSet(String[] words){
        HashSet<String> set = new HashSet<>();
        for(String word : words){
            for(int i=1; i<=word.length(); i++){
                set.add(word.substring(0,i));
            }
        }
        return set;
    }


// All inputs are lowercase a-z

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
