package Medium.two_pointers;

public class Find_Duplicate_Number {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,2};

        System.out.println(findDuplicate(arr));
    }

    public static int findDuplicate(int[] nums) {

        if(nums.length>1){

            int slow = nums[0];
            int fast = nums[nums[0]];

            while(slow != fast){
                slow = nums[slow];
                fast = nums[nums[fast]];
            }

            fast=0;
            while(slow != fast){
                slow = nums[slow];
                fast = nums[fast];
            }
            return slow;

        }
        return -1;

    }

}
