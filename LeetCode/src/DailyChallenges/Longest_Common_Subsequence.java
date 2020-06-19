package DailyChallenges;

public class Longest_Common_Subsequence {
    public static void main(String[] args) {

        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }

    public static int longestCommonSubsequence(String text1, String text2) {

        int[][] dp = new int[text1.length()+1][text2.length()+1];

        for(int i=0; i<text1.length(); i++){
            for(int j=0; j<text2.length(); j++){
                if(text1.charAt(i) == text2.charAt(j)) dp[i+1][j+1] = dp[i][j] + 1;
                else dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
            }
        }

        return dp[text1.length()][text2.length()];
    }


}