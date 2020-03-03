package Playground;

public class Arrays_2D {
    public static void main(String[] args) {

        char[][] board ={{'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};

        board[0][3] ^= 256;

        System.out.println(board[0][3]);

        board[0][3] ^= 256;

        System.out.println(board[0][3]);


    }
}
