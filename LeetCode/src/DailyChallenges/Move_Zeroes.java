package DailyChallenges;

public class Move_Zeroes {
    public static void main(String[] args) {

        int[] arr = {0,0,1};
        moveZeroes(arr);

        for(int i : arr){
            System.out.print(i + " ");
        }

    }

    public static void moveZeroes(int[] nums) {

        int loc = -1;

        for(int i=0; i<nums.length; i++){

            if(nums[i] == 0){
                if(loc == -1){
                    loc = i;
                }
            }else{
                if(loc != -1){
                    nums[loc] = nums[i];
                    nums[i] = 0;
                    loc++;
                }


            }
        }

    }
}
