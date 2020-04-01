package Medium.arrays;

import java.util.Arrays;

public class Task_Scheduler {
    public static void main(String[] args) {

    }

    public int leastInterval(char[] tasks, int n) {

        int[] arr = new int[26];

        for (char c : tasks) {
            arr[c - 'A'] += 1;
        }



        return 0;
    }
}