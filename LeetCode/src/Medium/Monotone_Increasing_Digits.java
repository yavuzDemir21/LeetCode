package Medium;

public class Monotone_Increasing_Digits {
    public static void main(String[] args) {

        System.out.println(monotoneIncreasingDigits(253));

    }
    private static int monotoneIncreasingDigits(int N) {

        int result = 0;
        int prv = 9, cur;
        int base = 1;
        while(N > 0){
            cur = N%10;
            N /= 10;
            if(cur <= prv){
                result += cur * base;
                prv =cur;
            }else{
                result = cur * base - 1;
                prv =cur-1;
            }
            base *= 10;

        }

        return result;

    }
}
