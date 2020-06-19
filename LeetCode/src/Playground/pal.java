package Playground;

import java.util.Scanner;
public class pal {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String word = reader.nextLine();
        System.out.println(isPalindrome(word));
    }

    public static boolean isPalindrome(String word) {
        // Please write your code here.
        if(word.length()==1 || word.length()==0) return true;
        word.toLowerCase();
        char[] arr = word.toCharArray();
        int i = 0, j=word.length()-1;

        while(i<j){
            System.out.println(i + " " + j);
            if(arr[i] != arr[j]) return false;
            i++;
            j--;
        }
        return true;

    }
}
