package tests;

import Medium.arrays.Word_Search;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Word_SearchTest {

    char[][] board = {{'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}};

    int row = 0;
    int col = 0;

    char[] arr = {'A', 'B', 'C'};

    int index = 0;

    String word = "ABC";


    @Test
    void existingWordSearch() {



        assertEquals(true, Word_Search.search2(board,row,col,arr,index));



    }

    @Test
    void nonExistingWordSearch() {


        char[] arr = {'N', 'A', 'N'};

        assertEquals(false, Word_Search.search2(board,row,col,arr,index));

    }

    @Test
    void existingWord() {


        assertEquals(true, Word_Search.exist(board, word));


    }

    @Test
    void nonExistingWord() {

        String word = "NON";

        assertEquals(false, Word_Search.exist(board, word));


    }
}