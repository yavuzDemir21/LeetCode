package Hard;

import java.util.HashMap;

public class Minimum_Window_Substring {
    public static void main(String[] args) {
        String S = "bba", T = "ba";


        System.out.println(minWindow(S, T));

    }

    private static String minWindow(String s, String t) {

        if (s == null || s.length() < t.length() || s.length() == 0) {
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        char[] arr = s.toCharArray();

        int left = 0;
        int minLeft = 0;
        int minLen = arr.length + 1;
        int count = 0;
        for (int right = 0; right < arr.length; right++) {
            if (map.containsKey(arr[right])) {
                map.put(arr[right], map.get(arr[right]) - 1);
                if (map.get(arr[right]) >= 0) {
                    count++;
                }
                while (count == t.length()) {
                    if (right - left + 1 < minLen) {
                        minLeft = left;
                        minLen = right - left + 1;
                    }
                    if (map.containsKey(arr[left])) {
                        map.put(arr[left], map.get(arr[left]) + 1);
                        if (map.get(arr[left]) > 0) {
                            count--;
                        }
                    }
                    left++;
                }
            }
        }
        if (minLen > s.length()) {
            return "";
        }

        return s.substring(minLeft, minLeft + minLen);
    }

    private static String bestSolution(String s, String t) {
        int[] map = new int[128];

        for (char c : t.toCharArray())
            map[c]++;

        int count = t.length(), begin = 0, end = 0, d = Integer.MAX_VALUE, head = 0;

        while (end < s.length()) {
            if (map[s.charAt(end)]-- > 0) {
                count--;
            }
            end++;
            while (count == 0) {
                if (end - begin < d) {
                    d = end - begin;
                    head = begin;
                }
                if (map[s.charAt(begin++)]++ == 0)
                    count++;

            }
        }

        return d == Integer.MAX_VALUE ? "" : s.substring(head, head + d);
    }

}
