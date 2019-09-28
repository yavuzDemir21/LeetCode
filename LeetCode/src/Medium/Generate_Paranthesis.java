package Medium;

import java.util.*;

public class Generate_Paranthesis {
    public static void main(String[] args) {

        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();

        if(n == 0){
            return result;
        }
        StringBuilder buf = new StringBuilder();

        helper(result, 0, 0 , buf, n);
        return result;
    }

    private static void helper(List<String> list, int open, int close, StringBuilder cur, int n) {
        if (cur.length() == n * 2) {
            list.add(cur.toString());
        }else {
            if (open < n) {
                StringBuilder left = new StringBuilder(cur);
                helper(list,open+1, close, left.append('('), n);
            }

            if(close < open){
                StringBuilder right = new StringBuilder(cur);
                helper(list,open, close+1, right.append(')'), n);
            }
        }

    }

}
