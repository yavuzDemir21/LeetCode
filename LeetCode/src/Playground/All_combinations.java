package Playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class All_combinations {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        List<List<Integer>> list = combinations(arr);
        list.forEach(x -> System.out.println(Arrays.toString(x.toArray())));

    }

    public static List<List<Integer>> combinations(int[] arr){
        List<List<Integer>> result = new ArrayList<>();
        backtrack(arr, result, new ArrayList());
        return result;
    }

    private static void backtrack(int[] arr, List<List<Integer>> res, ArrayList list){
        if(arr.length == list.size()){
            res.add(list);
        }
        for(int i=0; i<arr.length; i++){
            if(list.contains(arr[i])) continue;
            list.add(arr[i]);
            backtrack(arr, res, new ArrayList(list));
            list.remove(list.size()-1);
        }
    }

}
