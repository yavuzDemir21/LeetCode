package DailyChallenges;

import java.util.Arrays;

public class Product_Array_ExceptSelf {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4};

        System.out.println(Arrays.toString(productExceptSelf(arr)));
    }

    public static int[] productExceptSelf(int[] nums) {

        if(nums.length==1){
            return nums;
        }

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        for(int i=0; i<nums.length; i++) {
            if (i == 0) {
                left[0] = nums[0];
            } else {
                left[i] = left[i - 1] * nums[i];
            }
        }

        for(int i=nums.length-1; i>=0; i--){
            if(i==nums.length-1){
                right[i] = nums[i];
            }else{
                right[i] = right[i+1] * nums[i];
            }
        }

        int[] result = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            if(i==0){
                result[i] = right[i+1];
            }else if(i==nums.length-1){
                result[i] = left[i-1];
            }else{
                result[i] = left[i-1] * right[i+1];
            }
        }

        return result;
    }
}
