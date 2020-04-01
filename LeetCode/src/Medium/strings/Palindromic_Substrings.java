package Medium.strings;

public class Palindromic_Substrings {
    public static void main(String[] args) {

        System.out.println(countSubstrings("abbba"));
    }
    public static int countSubstrings(String s) {
        if (s.length() == 0){
            return 0;
        }else if (s.length() == 1){
            return 1;
        }

        char[] arr = s.toCharArray();
        int result = s.length();

        for(int i=0; i<arr.length; i++){
            int k= i-1, l=i+1;

            while(k>=0 && l<arr.length && arr[k] == arr[l]){
                result++;
                k--;
                l++;
            }

        }
        for(int i=0; i<arr.length; i++){
            int k= i, l=i+1;

            while(k>=0 && l<arr.length && arr[k] == arr[l]){
                result++;
                k--;
                l++;
            }

        }

        return result;
    }
}
