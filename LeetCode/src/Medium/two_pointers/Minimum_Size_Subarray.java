package Medium.two_pointers;

public class Minimum_Size_Subarray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(minSubArrayLen(6, arr));

    }

    public static int minSubArrayLen(int s, int[] nums) {

        if (s == 0) {
            return 0;
        }
        int sum = 0;
        int start = -1;

        for (int end = 0; end < nums.length; end++) {
            if (nums[end] >= s) {
                return 1;
            }
            sum += nums[end];

            while (sum >= s) {
                start++;
                sum -= nums[start];
            }

            if (start != -1) {
                start++;
                sum -= nums[start];
            }

        }

        if (sum < s && start == -1)
            return 0;

        return nums.length - start + 1;
    }
}
