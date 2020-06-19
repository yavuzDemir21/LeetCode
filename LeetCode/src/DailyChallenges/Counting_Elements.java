package DailyChallenges;

import java.util.HashSet;

public class Counting_Elements {
    public static void main(String[] args) {
        int[] arr = {1,3,2,3,5,0};
        System.out.println(countElements(arr));

    }
    public static int countElements(int[] arr) {

        if(arr.length <= 1){
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();
        for(int elem : arr){
            set.add(elem);
        }

        int result = 0;
        for(int elem : arr){
            if(set.contains(elem+1)){
                result++;
            }
        }
        return result;
    }
}
