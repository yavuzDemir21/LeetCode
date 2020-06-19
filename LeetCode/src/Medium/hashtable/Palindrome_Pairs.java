package Medium.hashtable;

import java.util.HashMap;
import java.util.List;

public class Palindrome_Pairs {
    public static void main(String[] args) {

    }
    public List<List<Integer>> palindromePairs(String[] words) {

        HashMap<String, String> map = new HashMap<>();
        for (String word : words){

            for(int i=1; i<word.length(); i++){
                map.put(word.substring(0,i), word.substring(i));
            }

        }

        return null;
    }
}
