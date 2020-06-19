package Medium.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Letter_Combination_Phone_Number {
    public static void main(String[] args) {

        letterCombinations("23").forEach(System.out::println);

    }

    public static List<String> letterCombinations(String digits) {

        char[] arr = digits.toCharArray();
        List<String> result = new ArrayList<>();

        if(arr.length == 0){
            return result;
        }

        HashMap<Character, char[]> map = new HashMap<>();
        char[] l1 = {'a', 'b', 'c'};
        map.put('2', l1);
        char[] l2 = {'e', 'd', 'f'};
        map.put('3', l2);
        char[] l3 = {'g', 'h', 'i'};
        map.put('4', l3);
        char[] l4 = {'j', 'k', 'l'};
        map.put('5', l4);
        char[] l5 = {'m', 'n', 'o'};
        map.put('6', l5);
        char[] l6 = {'p', 'q', 'r', 's'};
        map.put('7', l6);
        char[] l7 = {'t', 'u', 'v'};
        map.put('8', l7);
        char[] l8 = {'w', 'x', 'y', 'z'};
        map.put('9', l8);


        char[] str = new char[arr.length];

        helper(str, result, 0, arr, map);

        return result;

    }

    public static void helper(char[] str, List<String> res, int idx, char[] digits, HashMap<Character, char[]> map){


        if(idx == digits.length){
            res.add(new String(str));
            return;
        }

        char[] list = map.get(digits[idx]);

        for(char c : list){
            str[idx] = c;
            helper(str, res, idx+1, digits, map);
        }

    }
}
