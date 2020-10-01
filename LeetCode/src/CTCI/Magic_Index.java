package CTCI;

public class Magic_Index {
    public static void main(String[] args) {

        int[] A = {-1000, -8, -20, -22, -23, -25, -210 ,-216, -217, 9};

        System.out.println(findMagicIndex(A));


    }

    public static int findMagicIndex(int[] A){

        return searchMagicIndex(A, 0, A.length-1);

    }

    //With no duplicates
    public static int searchMagicIndex(int[] A, int start, int end){

        if(start > end) return -1;

        int mid = start + (end-start)/2;

        if(A[mid] == mid){
            return mid;
        }else if(A[mid] < mid){
            return searchMagicIndex(A, mid+1, end);
        }else {
            return searchMagicIndex(A, start, mid-1);
        }
    }


    public static int searchMagicIndexWithDups(int[] A, int start, int end){
        if(start > end) return -1;

        int mid = start + (end-start)/2;
        int midVal = A[mid];

        if(mid == midVal) return mid;


        int leftHigh = Math.min(midVal, mid-1);
        int leftMagic = searchMagicIndexWithDups(A, start, leftHigh);
        if(leftMagic != -1) return leftMagic;


        int rightLow = Math.max(midVal, mid+1);
        return searchMagicIndexWithDups(A, rightLow, end);
    }


}
