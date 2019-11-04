package Medium;

import java.util.Arrays;

public class Next_Permutation {
    public static void main(String[] args) {

        int[] nums = {1,3,2};
        nextPermutationBetter(nums);
        System.out.println(Arrays.toString(nums));
    }
    private static void nextPermutation(int[] nums) {

        for(int i=nums.length-2; i>=0; i--){
            for(int j=nums.length-1; j>i; j--){
                if(nums[j] > nums[i]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;

                    for(int k=0; k<(nums.length-i)/2; k++){
                        temp = nums[k+i+1];
                        nums[k+i+1] = nums[nums.length -k -1];
                        nums[nums.length -k -1] = temp;
                    }
                    return;
                }
            }
        }


        for(int i=0; i<nums.length/2; i++){
            int temp = nums[i];
            nums[i] = nums[nums.length -i -1];
            nums[nums.length -i -1] = temp;
        }
    }

    private static void nextPermutationBetter(int[] nums){
        int max = Integer.MIN_VALUE;
        int i = nums.length-1;
        while(i >= 0 && nums[i] >= max){
            max = nums[i];
            i--;
        }
        if(i < 0){
            for(i=0; i<nums.length/2; i++){
                int temp = nums[i];
                nums[i] = nums[nums.length -i -1];
                nums[nums.length -i -1] = temp;
            }
        }else{
            int j = i+1;
            while(j < nums.length && nums[i] < nums[j]){
                j++;
            }
            j--;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            for(int k=0; k<(nums.length-i)/2; k++){
                temp = nums[k+i+1];
                nums[k+i+1] = nums[nums.length -k -1];
                nums[nums.length -k -1] = temp;
            }

        }
    }

}
