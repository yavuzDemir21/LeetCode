package Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Substring_with_Concatenation_of_All_Words {
    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};

        System.out.println(findSubstring(s, words));

    }

    public static List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        if(s.length() == 0 || words.length == 0){
            return result;
        }
        int substringLength = words[0].length() * words.length;

        HashMap<String, Integer> map = new HashMap<>();




        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) +1);
        }

        for(int i=0; i<s.length()-substringLength+1; i++){
            boolean found = true;
            HashMap<String, Integer> tempMap = new HashMap<>();
            String temp = s.substring(i, substringLength+i);
            List<String> tokens = new ArrayList<>();

            for (int start = 0; start < temp.length(); start += words[0].length()) {
                tokens.add(temp.substring(start, Math.min(temp.length(), start + words[0].length())));
            }

            for(String sub : tokens){
                tempMap.put(sub, tempMap.getOrDefault(sub, 0) + 1);
                if(map.get(sub) == null || tempMap.get(sub) > map.get(sub)){
                    found = false;
                    break;
                }
            }
            if(found) result.add(i);
        }
        return result;
    }

}
