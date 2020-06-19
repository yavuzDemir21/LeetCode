package DailyChallenges;

public class Bitwise_And_Range_Numbers {
    public static void main(String[] args) {

        System.out.println(rangeBitwiseAnd(4, 7));

    }

    public static int rangeBitwiseAnd(int m, int n) {
/*
        if(m >= n-1){
            return m & n;
        }

        int k = 0;
        int temp = m;
        while (temp > 1) {
            temp /= 2;
            k++;
        }

        if (n >= Math.pow(2, k + 1)) {
            return 0;
        }

        String bin = Integer.toBinaryString(~(m^n));

        int shift = bin.length() - bin.indexOf('0');

        return (m >> shift) << shift;
*/

        int shift = 0;

        while(m<n){
            m >>= 1;
            n >>= 1;
            shift++;
        }

        return m << shift;
    }
}
