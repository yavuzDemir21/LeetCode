package Easy;

import java.util.Arrays;
import java.util.HashMap;

public class Two_Sum {
	public static void main(String[] args) {
		
		int[] nums = {7, 11, 15, 2}; 
		
		System.out.println(Arrays.toString(TwoSum(nums, 9)));
		
	}
	
	public static int[] TwoSum(int[] nums, int target){
		
		int[] sol =  new int[2]; 
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i=0; i<nums.length; i++){
			int comply = target - nums[i];
			if(map.containsKey(comply)){
				sol[0] = map.get(comply);
				sol[1] = i;
				return sol;
			}else{
				map.put(nums[i], i);
			}
			
		}
		return sol;
	}

}
