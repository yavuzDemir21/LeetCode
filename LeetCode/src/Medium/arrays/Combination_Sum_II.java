package Medium.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_II {
    public static void main(String[] args) {

        int[] arr = {2, 2, 3, 5, 2, 3};

        List<List<Integer>> list = combinationSum2(arr, 8);

        list.forEach(x -> System.out.println(Arrays.toString(x.toArray())));
    }


    public static List<List<Integer>> combinationSum2(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        backtrack(arr, result, new ArrayList(),0, target);
        return result;
    }

    private static void backtrack(int[] arr, List<List<Integer>> res, ArrayList list, int start, int target) {
        for (int i = start; i < arr.length; i++) {
            list.add(arr[i]);
            if (target-arr[i]>0) {
                backtrack(arr, res, new ArrayList(list), i+1, target-arr[i]);
            }else if(target-arr[i] == 0){
                res.add(new ArrayList(list));
            }
            while(i<arr.length-1 && arr[i] == arr[i+1]) i++;
            list.remove(list.size() - 1);
        }
    }
}
