package Medium;

public class Search_In_Rotated_Array {
    public static void main(String[] args) {

        int[] nums = {0,1,1,2,0,0};
        int target = 2;
        System.out.println(search(nums, target));
    }

    private static boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        int minIdx = findMin(nums);
        System.out.println(minIdx);
        if (target == nums[minIdx]) return true;
        int m = nums.length;
        int start = (target <= nums[m - 1]) ? minIdx : 0;
        int end = (target > nums[m - 1]) ? minIdx : m - 1;

        while (start <= end) {
            int mid = (end + start) / 2;
            if (nums[mid] == target) return true;
            else if (target > nums[mid]) start = mid + 1;
            else end = mid - 1;
        }
        return false;
    }

    private static int findMin(int[] arr) {
        int left=0;
        int right=arr.length-1;

        while(left<=right){

            while(arr[left]==arr[right] && left!=right){
                left++;
            }

            if(arr[left]<=arr[right]){
                return left;
            }

            int m=(left+right)/2;
            if(arr[m]>=arr[left]){
                left=m+1;
                if(arr[left] == arr[right]) return left;
            }else{
                right=m;
                if(right == left+1){
                    return right;
                }
            }
        }

        return -1;
    }


}
