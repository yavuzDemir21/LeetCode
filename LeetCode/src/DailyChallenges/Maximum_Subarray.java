package DailyChallenges;

public class Maximum_Subarray {
    public static void main(String[] args) {

        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(maxSubArray(arr));
    }
    public static int maxSubArray(int[] nums) {

        int result = nums[0];
        int max = nums[0];
        for(int i=1; i<nums.length; i++){
            max = Math.max(nums[i], nums[i] + max);
            result = Math.max(result, max);
        }

        return result;
    }

}
