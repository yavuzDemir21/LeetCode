package Medium.two_pointers;

public class Sort_Colors {
    public static void main(String[] args) {

        int[] arr = {1,2,0};
        sortColors(arr);

    }
    public static void sortColors(int[] nums) {

        int j = nums.length, k=0;

        for(int i=0; i<j; i++){

            if(nums[i] == 2){
                j--;
                while(j>i && nums[j] == 2){
                    j--;
                }
                nums[i] = nums[j];
                nums[j] = 2;
                if(nums[i] == 0){
                    i--;
                }
            }else if(nums[i] == 0){
                while(k<=i && nums[k] == 0){
                    k++;
                }
                if(k < i){
                    nums[i] = nums[k];
                    nums[k] = 0;
                    k++;
                }
            }
        }


        for(int elem : nums){
            System.out.print(elem + " ");
        }

    }
}
