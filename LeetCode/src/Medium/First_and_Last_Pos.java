package Medium;

import java.util.Arrays;

public class First_and_Last_Pos {

    public static void main(String[] args) {
        int[] arr = {5,7,7,8,9,10};
        System.out.println(Arrays.toString(searchRange(arr, 8)));
    }

    private static int[] searchRange(int[] nums, int target) {
        int[] res = {-1, 1};

        int left = 0, right=nums.length-1, mid;

        while(left < right){
            mid = left + (right-left)/2;

            if(nums[mid] < target){
                left = mid+1;
            }else if(nums[mid] > target){
                right = mid-1;
            }else{
                int midL = mid-1;
                while(left < midL){
                    if(nums[(left+midL)/2] != target){
                       left = (left+midL)/2 + 1;
                    }else{
                        midL = (left+midL)/2 - 1;
                    }
                }
                int midR = mid+1;
                while(midR < right){
                    if(nums[(midR+right)/2] != target){
                        right = (right+midR)/2 - 1;
                    }else{
                        midR = (right+midR)/2 + 1;
                    }
                }
                res[0] = midL;
                res[1] = midR;
                break;
            }
        }
        return res;

    }
}
