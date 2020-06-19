package Medium.DP;

import java.util.HashSet;
import java.util.List;

public class Word_Break {
    public static void main(String[] args) {

    }

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        wordDict.forEach(x->{
            set.add(x);
        });


        boolean[] dp = new boolean[s.length()+1];

        dp[0] = true;

        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }


        return dp[s.length()];
    }
}
