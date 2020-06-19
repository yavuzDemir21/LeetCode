package Medium.strings;

public class Longest_Palindrome {
    public static void main(String[] args) {

        System.out.println(longestPalindrome("b"));
    }

    public static String longestPalindrome(String s) {


        String result = "";

        for (int i = 0; i < s.length(); i++) {

            int count = 1;
            while (i - count >= 0 && i + count < s.length() && s.charAt(i - count) == s.charAt(i + count)) {
                count++;
            }


            int count2 = 0;
            while (i - count2 >= 0 && i + count2 + 1 < s.length() && s.charAt(i - count2) == s.charAt(i + count2 + 1)) {
                count2++;
            }

            int len = Math.max(2*count-1, 2*count2);

            if(len > result.length()){
                if(2*count-1 < 2 * count2){
                    result = s.substring(i - count2 + 1, i + 1 + count2);
                }else{
                    result = s.substring(i-count+1, i+count);
                }
            }

        }

        return result;


    }
}
