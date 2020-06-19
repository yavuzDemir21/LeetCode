package DailyChallenges;

public class String_Shift {
    public static void main(String[] args) {

        String s = "abc";
        int[][] shift = {{0,1},{1,2}};

        System.out.println(stringShift(s, shift));


    }

    public static String stringShift(String s, int[][] shift) {

        int sum = 0;

        int len = s.length();

        for(int i=0; i<shift.length; i++){
            sum += shift[i][0] == 1 ? shift[i][1] : len-shift[i][1];
        }

        sum %= len;

        return s.substring(len-sum) + s.substring(0, len-sum);

    }
}
