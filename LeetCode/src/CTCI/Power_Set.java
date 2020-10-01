package CTCI;

import java.util.ArrayList;
import java.util.Arrays;

public class Power_Set {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3};

        allSubsets(arr).forEach(x -> System.out.println(Arrays.toString(x.toArray())));
    }

    public static ArrayList<ArrayList<Integer>> allSubsets(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<Integer>(), arr, 0);
        return result;
    }

    public static void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> tempList, int[] arr, int st) {

        result.add(new ArrayList<>(tempList));

        for (int i = st; i < arr.length; i++) {
            tempList.add(arr[i]);
            helper(result, tempList, arr, i + 1);
            tempList.remove(tempList.size() - 1);
        }
        

    }


}
