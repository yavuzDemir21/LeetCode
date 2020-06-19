package Medium.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Top_K_Frequent {
    public static void main(String[] args) {

        int[] arr = {1,1,1,2,2,3};

        List<Integer> list = topKFrequent(arr, 2);

        list.forEach(System.out::println);

    }
    public static List<Integer> topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i :  nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }

        List<Integer>[] buckets = new ArrayList[nums.length+1];

        for(int key : map.keySet()){
            int val = map.get(key);

            if(buckets[val] == null){
                buckets[val] = new ArrayList<>();
            }
            buckets[val].add(key);

        }

        List<Integer> result = new ArrayList<>();

        for(int i = nums.length; i>=0 && result.size() < k; i--){
            if(buckets[i] != null)
                result.addAll(buckets[i]);
        }

        return result;


    }
}
