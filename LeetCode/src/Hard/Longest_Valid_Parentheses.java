package Hard;

public class Longest_Valid_Parentheses {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")()(((())))("));
    }

    private static int longestValidParentheses(String s) {

        int left = s.indexOf("(");
        int max = 0;
        int count = 0;
        int right;

        if(left == -1) return max;

        char[] arr = s.toCharArray();

        for(right=left; right<arr.length; right++){
            if(arr[right] == '('){
                count++;
            }else {
                count--;
            }

            if(count < 0){
                max = Math.max(max, right-left);
                left = right+1;
                count = 0;
            }


        }

        if (count == 0) max = Math.max(max, right-left);
        int maxRight = s.lastIndexOf(')');
        if(count > 0){
            count = 0;
            for(right = s.lastIndexOf(')'); right >= left; right--){
                if(arr[right] == '('){
                    count--;
                }else {
                    count++;
                }
                if(count < 0){
                    max = Math.max(max, maxRight-right);
                    maxRight = right-1;
                    count = 0;
                }
            }
        }

        if(count == 0) max = Math.max(max, maxRight-right);

        return max;

    }
}
