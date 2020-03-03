package Medium.arrays;

/*

my first solution


import java.util.*;

class Ptr {
    int p1;
    int p2;
    int p3;

    Ptr(int p1, int p2, int p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    @Override
    public int hashCode() {
        return this.p1+this.p2*10+this.p3*100;
    }

    @Override
    public boolean equals(Object obj) {
        Ptr _obj = (Ptr) obj;
        return this.p1 == _obj.p1 && this.p2 == _obj.p2 && this.p3 == _obj.p3;
    }
}

public class Three_Sum {

    public static Set<Ptr> resultSet = new HashSet<>();

    public static void main(String[] args) {
//
        int[] input = {0,0 ,0};

        threeSum(input);

    }

    private static List<List<Integer>> threeSum(int[] nums) {


        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 3){
            return result;
        }
        Arrays.sort(nums);


        Ptr start = new Ptr(0, nums.length / 2, nums.length - 1);

        myFunc(start, nums);

        Iterator<Ptr> it = resultSet.iterator();
        while(it.hasNext()){
            Ptr temp = it.next();
            ArrayList<Integer> elems = new ArrayList<>();
            elems.add(temp.p1);
            elems.add(temp.p2);
            elems.add(temp.p3);
            result.add(elems);
            System.out.println(elems);
        }

        return result;

    }

    private static void myFunc(Ptr ptr, int[] nums) {
        int sum = nums[ptr.p1] + nums[ptr.p2] + nums[ptr.p3];

        if (sum == 0) {
            resultSet.add(new Ptr(nums[ptr.p1], nums[ptr.p2], nums[ptr.p3]));
            if (ptr.p1 != ptr.p2 - 1 && !resultSet.contains(new Ptr(ptr.p1+1, ptr.p2, ptr.p3))) {
                myFunc(new Ptr(ptr.p1+1, ptr.p2, ptr.p3), nums);
            }
            if (ptr.p2 != ptr.p3 - 1 && !resultSet.contains(new Ptr(ptr.p1, ptr.p2, ptr.p3 - 1))) {
                myFunc(new Ptr(ptr.p1, ptr.p2, ptr.p3 - 1), nums);
            }

        } else if (sum > 0) {

            if (ptr.p1 != ptr.p2 - 1 && !resultSet.contains(new Ptr(ptr.p1, ptr.p2 - 1, ptr.p3))) {
                myFunc(new Ptr(ptr.p1, ptr.p2 - 1, ptr.p3), nums);
            }
            if (ptr.p2 != ptr.p3 - 1 && !resultSet.contains(new Ptr(ptr.p1, ptr.p2, ptr.p3 - 1))) {
                myFunc(new Ptr(ptr.p1, ptr.p2, ptr.p3 - 1), nums);
            }
        } else {

            if (ptr.p2 != ptr.p3 - 1 && !resultSet.contains(new Ptr(ptr.p1, ptr.p2 + 1, ptr.p3))) {
                myFunc(new Ptr(ptr.p1, ptr.p2 + 1, ptr.p3), nums);
            }
            if (ptr.p1 != ptr.p2 - 1 && !resultSet.contains(new Ptr(ptr.p1+1, ptr.p2, ptr.p3))) {
                myFunc(new Ptr(ptr.p1+1, ptr.p2, ptr.p3), nums);
            }
        }

    }

}
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three_Sum {
    public static void main(String[] args) {
        int[] input = {-2, 0, 1, 1, 2};

        System.out.println(threeSum(input));
    }

    private static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();


        for (int i = 0; i < nums.length - 2; i++) {

            if (i == 0 || nums[i] != nums[i - 1]) {
                int sum = 0 - nums[i];
                int low = i + 1, high = nums.length - 1;
                while (high > low) {
                    if (nums[high] + nums[low] == sum) {
                        result.add(Arrays.asList(nums[i], nums[high], nums[low]));
                        do high--; while (high > low && nums[high] == nums[high + 1]);
                        do low++; while (high > low && nums[low] == nums[low - 1]);
                    } else if (nums[high] + nums[low] > sum) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }

        }

        return result;
    }
}

