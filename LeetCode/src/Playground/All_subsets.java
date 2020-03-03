package Playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class All_subsets {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,4};

        List<List<Integer>> list = allSubsets(arr);
        list.forEach(x -> System.out.println(Arrays.toString(x.toArray())));
    }


    public static List<List<Integer>> allSubsets(int[] arr){
        List<List<Integer>> result = new ArrayList<>();
        //backtrack(arr, new ArrayList<Integer>(), result, 0);
        Arrays.sort(arr);
        backtrack_noDuplicates(arr, new ArrayList<Integer>(), result, 0);

        return result;
    }

    private static void backtrack(int[] arr, ArrayList list, List<List<Integer>> res, int start){
        res.add(new ArrayList<>(list));
        for(int i=start; i<arr.length; i++){
            list.add(arr[i]);
            backtrack(arr, list, res, i+1);
            list.remove(list.size()-1);
        }

    }

    private static void backtrack_noDuplicates(int[] arr, ArrayList<Integer> list, List<List<Integer>> res, int start){
        res.add(new ArrayList<>(list));
        int removed = arr[0]-1;
        for(int i=start; i<arr.length; i++){
            if(i !=0 && arr[i] == removed) continue;
            list.add(arr[i]);
            backtrack_noDuplicates(arr, list, res, i+1);
            removed = list.remove(list.size()-1);
        }

    }

}



