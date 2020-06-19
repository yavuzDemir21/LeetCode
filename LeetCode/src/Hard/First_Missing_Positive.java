package Hard;

public class First_Missing_Positive {

    public static void main(String[] args) {

    }

    public static int firstMissingPositive(int[] nums) {

        int res = nums.length;

        for(int i=0; i<nums.length; i++){
            if(nums[i] < 1 || nums[i]>nums.length-1){
                res--;
            }
        }


        return -1;

    }

}
