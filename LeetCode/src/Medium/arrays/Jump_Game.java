package Medium.arrays;

public class Jump_Game {
    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));
    }

    private static boolean canJump(int[] nums) {

        if(nums.length == 0 || nums.length == 1) return true;
        if(nums[0] == 0 ) return false;

        int max =0;
        for(int i=0; i<nums.length; i++){
            if(max >= nums.length-1){
                return true;
            }
            if(max >= i){
                max = Math.max(max, i+nums[i]);
            }else{
                return false;
            }
        }
        return false;
    }
}
