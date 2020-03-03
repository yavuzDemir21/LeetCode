package Medium.arrays;

import java.util.ArrayList;
import java.util.HashMap;

public class Uncrossed_Lines {
    public static void main(String[] args) {


    }

    static Integer[][] dp = null;
    public static int maxUncrossedLines(int[] A, int[] B) {
        /*
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for(int i=0; i<B.length; i++){
            if(!map.containsKey(B[i])){
                map.put(B[i], new ArrayList<>(i));
            }else{
                map.get(B[i]).add(i);
            }
        }
        */
/*
        dp = new Integer[A.length][B.length];

        return search2(A,0,B,0);
*/

        int[][] dp2 = new int[A.length+1][B.length+1];

        for(int i=1; i<=A.length; i++){
            for(int j=1; j<=B.length; j++){
                if(A[i-1] == B[j-1]){
                    dp2[i][j] = 1 + dp2[i-1][j-1];
                }else {
                    dp2[i][j] = Math.max(dp2[i][j-1], dp2[i-1][j]);
                }
            }
        }

        return dp2[A.length][B.length];


    }

    private static int search2(int[] A, int i, int[] B, int j){
        if(i == A.length || j == B.length) return 0;
        int count = 0;
        if(A[i] == B[j]){
            count = 1 + search2(A, i+1, B, j+1);
        }else{
            count += Math.max(search2(A, i+1, B, j), search2(A, i, B, j+1));
        }
        return count;
    }

    private static int search3(int[] A, int i, int[] B, int j){
        if(i == A.length || j == B.length) return 0;
        if(dp[i][j] != null) return dp[i][j];
        if(A[i] == B[j]){
            dp[i][j] = 1 + search3(A, i+1, B, j+1);
        }else{
            dp[i][j] += Math.max(search3(A, i+1, B, j), search2(A, i, B, j+1));
        }
        return dp[i][j];
    }

    private static void search(int[] A, HashMap map, int i, int j){
        if(i>= A.length) return;

        if(!map.containsKey(A[i])){
            search(A, map, i+1, j);
        }else{

        }
    }

}
