package DailyChallenges;

public class Single_Number {
    public static void main(String[] args) {

        int[] number = {2,1,2};

        System.out.println(singleNumber(number));
    }

    public static int singleNumber(int[] nums) {

        int result = 0;

        for(int i : nums){
            result ^= i;
        }

        return result;
    }
}
