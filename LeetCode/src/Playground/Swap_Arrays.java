package Playground;

import java.util.Arrays;

public class Swap_Arrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5};

        //swapArrays(arr1, arr2);
        int[] temp = arr1;
        arr1 = arr2;
        arr2 = temp;
        arr1[1] = 10;
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }


    public static void swapArrays(int[] arr1, int[] arr2) {
        int[] temp = arr1;
        arr1 = new int[arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr2[i];
        }
        arr2 = new int[temp.length];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = temp[i];
        }


    }
}
