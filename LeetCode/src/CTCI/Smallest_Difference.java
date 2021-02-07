package CTCI;

import java.util.Arrays;

public class Smallest_Difference {

    public int findSmallestDifference(int[] arr1, int[] arr2){

        int[] shortArr;
        int[] longArr;
        if(arr1.length < arr2.length){
            shortArr = arr1;
            longArr = arr2;
        }else{
            shortArr = arr2;
            longArr = arr1;
        }

        Arrays.sort(shortArr);

        int curMin = Integer.MAX_VALUE;

        for(int num : longArr){
            int curDiff = findDifferenceOfClosestPair(shortArr, num);
            curMin = Math.min(curDiff, curMin);
            if(curMin == 0) return curMin;
        }
        return  curMin;
    }

    private int findDifferenceOfClosestPair(int[] arr, int num) {
        int hi = arr.length-1;
        int lo = 0;
        int mid = lo + (hi-lo)/2;

        while(lo < hi){
            if(arr[mid] == num) return 0;
            else if(arr[mid] < num) lo = mid+1;
            else hi = mid-1;
            mid = lo + (hi-lo)/2;
        }

        if(mid == arr.length-1) return num - arr[mid];
        else if(mid == 0) return arr[mid] - num;
        else{
            if(arr[mid] > num) return Math.min(arr[mid]-num, num-arr[mid-1]);
            else return Math.min(arr[mid+1]-num, num-arr[mid]);
        }

    }
}
