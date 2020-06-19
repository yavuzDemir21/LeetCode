package CTCI;

import java.util.ArrayList;
import java.util.Arrays;

public class Triple_Steps {
    public static void main(String[] args) {

//        ArrayList<ArrayList<Integer>> result = tripleSteps(5);
//
//        result.forEach(x -> { System.out.printlintln(Arrays.toString(x.toArray()));});

        System.out.println(tripleStepsCount(57));

    }

    public static ArrayList<ArrayList<Integer>> tripleSteps(int n){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        helper(0, n, result, new ArrayList<>());
        return result;
    }

    public static void helper(int cur, int n, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> path){

        if(cur == n){
            res.add(new ArrayList<>(path));

        }else if(cur < n){
            for(int i=1; i<=3; i++){
                path.add(i);
                helper(cur+i, n, res, path);
                path.remove(path.size()-1);
            }
        }

    }

    public static int tripleStepsCount(int n){
        int[] arr = new int[n+1];
        Arrays.fill(arr, -1);
        return solver(n, arr);
    }

    public static int solver(int n, int[] memo){

        if(n == 0){
            return 1;
        }else if(n < 0){
            return 0;
        } else {
            if(memo[n] > -1){
                return memo[n];
            }else{
                memo[n] = solver(n-1, memo) + solver(n-2,  memo) + solver(n-3,  memo);
                return memo[n];
            }

        }


    }

}
