package DailyChallenges;

import java.util.HashSet;

public class Happy_Number {
    public static void main(String[] args) {

        System.out.println(isHappy(101));

    }
    public static boolean isHappy(int n) {

        HashSet<Integer> set = new HashSet<>();
        set.add(n);

        int sum = n;
        while(sum != 1){
            sum = digitSquareSum(sum);
            if (set.contains(sum)) return false;
            set.add(sum);
        }

        return true;

    }

    private static int digitSquareSum(int n){
        int sum=0;
        while(n>0){
            sum += (n%10)*(n%10);
            n /= 10;
        }
        return sum;
    }
}
