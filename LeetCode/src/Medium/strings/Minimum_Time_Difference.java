package Medium.strings;

import java.util.Arrays;
import java.util.List;

public class Minimum_Time_Difference {
    public static void main(String[] args) {

    }

    public static int findMinDifference(List<String> timePoints) {

        String[] arr = new String[timePoints.size()];
        arr = timePoints.toArray(arr);


        Arrays.sort(arr);
        int min = 24 * 60;

        for (int i = 0; i < arr.length; i++) {


            String s1 = arr[i];
            String s2 = arr[(i + 1) % arr.length];


            int h1 = 10 * (s1.charAt(0) - '0') + s1.charAt(1) - '0';
            int m1 = 10 * (s1.charAt(3) - '0') + s1.charAt(4) - '0';
            int h2 = 10 * (s2.charAt(0) - '0') + s2.charAt(1) - '0';
            int m2 = 10 * (s2.charAt(3) - '0') + s2.charAt(4) - '0';

            int result = 0;

            if (i == arr.length - 1) {
                result += 60 - m1 + 60 * (24 - h1 - 1);
                result += m2 + 60 * h2;
            } else {
                if (m1 > m2) {
                    result += 60 + m2 - m1;
                    h2--;
                } else {
                    result += m2 - m1;
                }

                result += (h2 - h1) * 60;
            }


            min = Math.min(result, min);


        }

        return min;

    }

}
