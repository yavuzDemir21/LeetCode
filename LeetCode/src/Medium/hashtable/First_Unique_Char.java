package Medium.hashtable;

import java.util.HashMap;

public class First_Unique_Char {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("aabcdd"));
    }
    public static int firstUniqChar(String s) {

        char[] arr = s.toCharArray();
        int first = arr.length;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i], i);
            }else{
                map.put(arr[i], -1);
            }
        }

        for (int k : map.values()) {
            if (k != -1) {
                if (k < first) {
                    first = k;
                }
            }
        }


        return first == arr.length ? -1 : first;
    }
}
