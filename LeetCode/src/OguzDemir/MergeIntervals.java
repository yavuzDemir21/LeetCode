package OguzDemir;


/*

interval 1 => {[1,2], [3,10]}
interval 2 => {[4,6], [9,12], [15,18]}

merged => {[1,2], [3,12], [15,18]}

 */

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
    static int p1 = 0;
    static int p2 = 0;

    public static void main(String[] args) {
        ArrayList<int[]> interval1 = new ArrayList<>();
        interval1.add(new int[]{1, 2});
        interval1.add(new int[]{3, 10});

        ArrayList<int[]> interval2 = new ArrayList<>();
        interval2.add(new int[]{4, 6});
        interval2.add(new int[]{11, 12});
        interval2.add(new int[]{15, 18});
        interval2.add(new int[]{25, 28});


        ArrayList<int[]> merged = mergeIntervals(interval1, interval2);

        merged.forEach(x -> System.out.println(Arrays.toString(x)));


    }

    private static ArrayList<int[]> mergeIntervals(ArrayList<int[]> interval1, ArrayList<int[]> interval2) {

        if (interval1.size() == 0) return interval2;
        if (interval2.size() == 0) return interval1;

        ArrayList<int[]> result = new ArrayList<>();

        int[] prev = findSmaller(interval1, interval2);

        int[] cur;

        while (p1 < interval1.size() || p2 < interval2.size()) {

            cur = findSmaller(interval1, interval2);

            if (cur[0] > prev[1]) {
                result.add(prev);
                prev = cur;
            } else {
                prev[1] = Math.max(cur[1], prev[1]);
            }

        }
        result.add(prev);

        return result;

    }

    public static int[] findSmaller(ArrayList<int[]> interval1, ArrayList<int[]> interval2) {

        if (p1 == interval1.size()) {
            return interval2.get(p2++);
        } else if (p2 == interval2.size()) {
            return interval1.get(p1++);
        }

        int[] int1 = interval1.get(p1);
        int[] int2 = interval2.get(p2);


        if (int1[0] < int2[0]) {
            p1++;
            return int1;
        } else if (int1[0] > int2[0]) {
            p2++;
            return int2;
        } else {
            if (int1[1] < int2[1]) {
                p1++;
                return int1;
            } else if (int1[1] > int2[1]) {
                p2++;
                return int2;
            } else {
                p1++;
                p2++;
                return int1;
            }
        }
    }
}
