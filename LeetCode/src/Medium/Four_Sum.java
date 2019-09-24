package Medium;

import javafx.util.Pair;

import java.util.*;



public class Four_Sum {
    public static void main(String[] args) {

        int[] input = {1, 0, -1, 0, -2, 2};
        int target = 0;


        System.out.println(fourSum(input, target));


    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        HashMap<Pair<Integer, Integer>, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (!map.containsKey(new Pair(nums[i], nums[j])) && !map.containsKey(new Pair(nums[j], nums[i])))
                    map.put(new Pair(nums[i], nums[j]), nums[i] + nums[j]);
            }
        }

        HashSet<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> resultSet = new HashSet<>();

        for (Map.Entry<Pair<Integer, Integer>, Integer> entry1 : map.entrySet()) {

            for (Map.Entry<Pair<Integer, Integer>, Integer> entry2 : map.entrySet()) {
                if (entry1.getKey() != entry2.getKey() && entry1.getValue() + entry2.getValue() == target) {
                    if (!resultSet.contains(new Pair<>(entry1.getKey(), entry2.getKey()))
                            && !resultSet.contains(new Pair<>(entry2.getKey(), entry1.getKey())))
                    {
                        resultSet.add(new Pair<>(entry1.getKey(), entry2.getKey()));
                    }
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        for (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> p : resultSet) {

            ArrayList<Integer> elems = new ArrayList<>();
            elems.add(p.getKey().getKey());
            elems.add(p.getKey().getValue());
            elems.add(p.getValue().getKey());
            elems.add(p.getValue().getValue());

            result.add(elems);

        }


        return result;
    }

}
