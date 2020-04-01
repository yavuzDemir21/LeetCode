package Medium.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Group_Anagrams {
    public static void main(String[] args) {


        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> list = groupAnagrams(strs);

        list.forEach(x -> System.out.println(Arrays.toString(x.toArray())));


    }

    public static List<List<String>> groupAnagrams(String[] strs) {


        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for(String s : strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String newString = new String(arr);
            if(map.containsKey(newString)){
                map.get(newString).add(s);
            }else{
                ArrayList<String> temp = new ArrayList<>();
                temp.add(s);
                map.put(newString, temp);
            }
        }

        return new ArrayList<>(map.values());

    }
}
