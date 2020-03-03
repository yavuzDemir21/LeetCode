package Medium.arrays;


import java.util.Arrays;


public class Three_Sum_Closest {
    public static void main(String[] args) {
        int[] input = {-1, 2, 1, -4};
        int target = 1;

        System.out.println(threeSumClosest(input, target));
    }

    private static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int closest = target > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE + 1;

        for (int i = 0; i < nums.length - 2; i++) {

            if (i == 0 || nums[i] != nums[i - 1]) {
                int low = i + 1, high = nums.length - 1;
                while (high > low) {
                    closest = Math.abs(target - closest) > Math.abs(target - (nums[i] + nums[high] + nums[low])) ? nums[i] + nums[high] + nums[low] : closest;
                    if (nums[high] + nums[low] + nums[i] == target) {
                        return target;
                    } else if (nums[high] + nums[low] + nums[i] > target) {
                        do high--; while (high > low && nums[high] == nums[high + 1]);
                    } else {
                        do low++; while (high > low && nums[low] == nums[low - 1]);
                    }
                }
            }

        }

        return closest;
    }
}
