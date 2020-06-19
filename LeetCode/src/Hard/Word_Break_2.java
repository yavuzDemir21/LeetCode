package Hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Word_Break_2 {
    public static void main(String[] args) {

    }
    public boolean wordBreak2(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        wordDict.forEach(x->{
            set.add(x);
        });


        ArrayList<String>[] dp = new ArrayList[s.length()+1];

        dp[0] = new ArrayList<>();

        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(dp[j] != null && set.contains(s.substring(j, i))){
                    dp[i] = new ArrayList<>();

                }
            }
        }


        return true;
    }
}
