package Medium.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum {
    public static void main(String[] args) {

        int[] arr = {2, 3, 5};

        List<List<Integer>> list = combinationSum(arr, 8);

        list.forEach(x -> System.out.println(Arrays.toString(x.toArray())));
    }


    public static List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(arr, result, new ArrayList(),0, target);
        return result;
    }

    private static void backtrack(int[] arr, List<List<Integer>> res, ArrayList list, int start, int target) {
        for (int i = start; i < arr.length; i++) {
            list.add(arr[i]);
            if (target-arr[i]>0) {
                backtrack(arr, res, new ArrayList(list), i, target-arr[i]);
            }else if(target-arr[i] == 0){
                res.add(new ArrayList(list));
            }
            list.remove(list.size() - 1);
        }
    }
}
