package Medium.arrays;


public class Word_Search {

    public static void main(String[] args) {

        char[][] board = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};

        System.out.println(exist(board, "ABCEe"));


    }

    private static boolean exist(char[][] board, String word) {

        char[] arr = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(search2(board,i,j,arr,0)){
                    return true;
                }
            }
        }

        return false;
    }


    private static boolean search2(char[][] board, int row, int col, char[] arr, int index){

        if(arr.length==index) return true;

        if(row<0 || row >= board.length || col < 0 || col >= board[0].length) return false;
        if(arr[index] != board[row][col]) return false;

        board[row][col] ^= 256;

        boolean res = search2(board, row+1, col, arr, index+1)
                || search2(board, row-1, col, arr, index+1)
                || search2(board, row, col+1, arr, index+1)
                || search2(board, row, col-1, arr, index+1);

        board[row][col] ^= 256;

        return res;
    }

    private static boolean search(char[][] board, int row, int col, char[] arr, int index) {
        if (arr.length == index) return true;

        boolean up = false, down = false, left = false, right = false;

        if (row - 1 >= 0 && board[row - 1][col] == arr[index]) {
            board[row - 1][col] ^= 256;
            up = search(board, row - 1, col, arr, index + 1);
            board[row - 1][col] ^= 256;
        }

        if (col - 1 >= 0 && board[row][col - 1] == arr[index]) {
            board[row][col - 1] ^= 256;
            left = search(board, row, col - 1, arr, index + 1);
            board[row][col - 1] ^= 256;
        }

        if (row + 1 < board.length && board[row + 1][col] == arr[index]) {
            board[row + 1][col] ^= 256;
            down = search(board, row + 1, col, arr, index + 1);
            board[row + 1][col] ^= 256;
        }

        if (col + 1 < board[0].length && board[row][col + 1] == arr[index]) {
            board[row][col + 1] ^= 256;
            right = search(board, row, col + 1, arr, index + 1);
            board[row][col + 1] ^= 256;
        }

        return up || right || left || down;

    }
}
