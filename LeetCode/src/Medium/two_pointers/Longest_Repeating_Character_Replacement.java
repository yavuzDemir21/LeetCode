package Medium.two_pointers;

public class Longest_Repeating_Character_Replacement {
    public static void main(String[] args) {

    }

    public int characterReplacement(String s, int k) {

        char[] arr = s.toCharArray();

        int[] count = new int[26];
        int max = 0, start = 0;

        for (int i = 0; i < arr.length; i++) {

            count[arr[i]-'A']++;
            max = Math.max(max, count[arr[i]-'A']);
            if(max+k <= i-start){
                count[arr[start]-'A']--;
                start++;
            }
        }

        return s.length()-start;
    }

}
