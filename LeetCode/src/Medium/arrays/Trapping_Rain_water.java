package Medium.arrays;

public class Trapping_Rain_water {
    public static void main(String[] args) {

        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(trap(arr));

    }

    public static int trap(int[] height) {
        int maxL = 0;
        int[] maxLArr = new int[height.length];
        for(int i=0; i<height.length; i++){
            maxL = Math.max(maxL, height[i]);
            maxLArr[i] = maxL;
        }

        int maxR = 0;
        int[] maxRArr = new int[height.length];
        for(int i=height.length-1; i>=0; i--){
            maxR = Math.max(maxR, height[i]);
            maxRArr[i] = maxR;
        }

        int count = 0;
        for(int i=0; i<height.length; i++){
            count += Math.min(maxLArr[i], maxRArr[i]) - height[i];
        }

        return count;
    }

}
