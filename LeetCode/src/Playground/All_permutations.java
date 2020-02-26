package Playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class All_permutations {
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,4};

        List<List<Integer>> list = permutations(arr);
        list.forEach(x -> System.out.println(Arrays.toString(x.toArray())));
    }

    public static List<List<Integer>> permutations(int[] arr){
        List<List<Integer>> result = new ArrayList<>();

        //no dups
        //backtrack(arr, new ArrayList(), result, hashSet);
        //no dups

        //With dups
        HashSet<Integer> hashSet = new HashSet<>();
        backtrack_withDup(arr, new ArrayList(), result, hashSet);
        //with dups

        return result;
    }

    private static void backtrack(int[] arr, ArrayList list, List res){
        if(list.size() == arr.length){
            res.add(new ArrayList(list));
        }
        for(int i = 0; i < arr.length; i++){
            if(list.contains(arr[i])) continue; // element already exists, skip
            list.add(arr[i]);
            backtrack(arr, list, res);
            list.remove(list.size() - 1);

        }
    }

    private static void backtrack_withDup(int[] arr, ArrayList list, List res, HashSet hashSet){
        if(list.size() == arr.length){
            res.add(new ArrayList(list));
        }
        for(int i = 0; i < arr.length; i++){
            if(list.contains(arr[i])) continue; // element already exists, skip
            list.add(arr[i]);

            backtrack_withDup(arr, list, res, hashSet);
            list.remove(list.size() - 1);

        }
    }

}
