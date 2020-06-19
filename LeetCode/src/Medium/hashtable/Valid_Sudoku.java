package Medium.hashtable;
import java.util.HashSet;

public class Valid_Sudoku {
    public static void main(String[] args) {

    }
    public static boolean isValidSudoku(char[][] board) {

        HashSet<Integer>[] rows = new HashSet[9];
        HashSet<Integer>[] cols = new HashSet[9];
        HashSet<Integer>[] sqrs = new HashSet[9];

        for(int i=0; i<9; i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            sqrs[i] = new HashSet<>();
        }

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] != '.'){
                    int cell = board[i][j] - '0';

                    if(rows[i].contains(cell)){
                        return false;
                    }else{
                        rows[i].add(cell);
                    }

                    if(cols[j].contains(cell)){
                        return false;
                    }else{
                        cols[j].add(cell);
                    }

                    int sq = 3*(i/3) + j/3;
                    if(sqrs[sq].contains(cell)){
                        return false;
                    }else{
                        sqrs[sq].add(cell);
                    }

                }
            }
        }
        return true;

    }
}
