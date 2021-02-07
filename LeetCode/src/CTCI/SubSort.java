package CTCI;

public class SubSort {

    public static void main(String[] args) {

    }
/*
    private static void subSort(int[] arr){

        int i;

        for(i=1; i<arr.length; i++){
            if(arr[i] < arr[i-1]){
                break;
            }
        }

        for(int j=i+1; j<arr.length; j++){
            if(arr[j] < arr[i]){
                i = findNewBoundary(arr, i, j);
                if(i == 0) break;
            }
        }

        int k;

        for(k=arr.length-2; k>=0; k--){
            if(arr[k+1] < arr[k]){
                break;
            }
        }

        for(int l=k-1; l>=0; l--){
            if(arr[l] > arr[k]){
                k = findNewBoundary(arr, k, l);
                if(k == arr.length-1) break;
            }
        }

        System.out.print(i + " " + k);

    }

 */
}
