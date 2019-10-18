package Hard;

public class Shortest_Palindrome {
    public static void main(String[] args) {

        System.out.println(shortestPalindrome("babce"));

    }
    public static String shortestPalindrome(String s) {

        if(s.length() == 0 || s.length() == 1){
            return s;
        }

        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length-1;
        int counter = right;
        StringBuilder sb = new StringBuilder();

        while(left < right){

            if(arr[left] == arr[right]){
                left++;
                right--;
            }else{
                sb.append(arr[counter]);
                counter--;
                right = counter;
                left = 0;
            }

        }


        return sb.append(s).toString();
    }
}
