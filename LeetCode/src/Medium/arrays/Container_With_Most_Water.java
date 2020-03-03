package Medium.arrays;

public class Container_With_Most_Water {

    public static void main(String[] args) {

        int[] input = {1,8,6,2,5,4,8,3,7};

        System.out.println(maxArea(input));


    }

    public static int maxArea(int[] height){

        int i=0, j = height.length-1, maxArea = 0;

        while(j > i){
            int area = Math.abs(i-j) * Math.min(height[i], height[j]);
            int maxL = height[i];
            int maxR = height[j];

            maxArea = Math.max(maxArea, area);

            if(height[j] > height[i]){
                while(i<j && height[i] <= maxL){
                    i++;
                }

            }
            else{
                while(i<j && height[j] <= maxR){
                    j--;
                }

            }

        }

        return maxArea;
    }


}
