package Medium.hashtable;

import java.util.HashMap;

public class Contiguous_Array {
    public static void main(String[] args) {
        int[] arr = {0,1,0,1,1,1,0,0,1,1,0,1,1,1,1,1,1,0,1,1,
                0,1,1,0,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,0,0,0,0,
                1,0,0,0,1,1,1,0,1,0,0,1,1,1,1,1,0,0,1,1,1,1,0,
                0,1,0,1,1,0,0,0,0,0,0,1,0,1,0,1,1,0,0,1,1,0,1,
                1,1,1,0,1,1,0,0,0,1,1};
        System.out.println(findMaxLength(arr));
    }
    public static int findMaxLength(int[] nums) {

        int sum = 0;
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0,0);

        for(int i=0; i< nums.length; i++){
            sum += nums[i]==0 ? -1 : 1;
            if(map.containsKey(sum)){
                if(result < i - map.get(sum)+1){
                    result = i-map.get(sum)+1;
                }
            }else{
                map.put(sum, i+1);
            }
        }

        return result;
    }
}
