package Medium.hashtable;

public class H_Index {
    public static void main(String[] args) {
        int[] arr = {5,5,6,5,5};
        System.out.print(hIndex(arr));
    }

    public static int hIndex(int[] citations) {
        int[] arr = new int[citations.length + 1];

        for (int ct : citations) {
            arr[Math.min(citations.length, ct)] += 1;
        }

        int count = 0;
        for (int i=arr.length-1; i>=0; i--) {
            count += arr[i];
            if(count >= i){
                return i;
            }

        }

        return 0;
    }

}
