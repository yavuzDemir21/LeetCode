package Playground;

import java.util.*;


public class Subseq {

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        String initial = sc.next();
        String goal = sc.next();

        System.out.println(minimumConcat(initial, goal));
    }

    public static int minimumConcat(String initial, String goal) {
        char[] arr1 = initial.toCharArray();
        char[] arr2 = goal.toCharArray();

        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        for(int i=0; i<arr1.length; i++){
            if(!map.containsKey(arr1[i])){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(arr1[i], list);
            }else{
                map.get(arr1[i]).add(i);
            }
        }

        for(char c : arr2){
            if(!map.containsKey(c)) return -1;
        }

        int start = 0;
        int count = 1;
        for(int i=0; i<arr2.length; i++){
            Iterator<Integer> it = map.get(arr2[i]).iterator();
            int nextOccurrence = it.next();
            while(nextOccurrence < start){
                if(!it.hasNext()){
                    count++;
                    nextOccurrence = map.get(arr2[i]).get(0);
                    break;
                }
                nextOccurrence = it.next();
            }
            start = nextOccurrence;
        }

        return count;

    }
}
