package Medium.hashtable;

import java.util.HashMap;

public class Fraction_Recurring_Decimal {
    public static void main(String[] args) {

        //Test Cases to think
        //Denominator < 0
        //numerator < 0
        //numerator = -2147483648
        //denominator = -2147483648


        System.out.println(fractionToDecimal(-2147483648,-1));
    }

    public static String fractionToDecimal(int numerator, int denominator) {

        if(denominator == 0) return "";

        long beforePoint = (long)numerator/denominator;
        long reminder = Math.abs(numerator%denominator);

        if(reminder == 0)
            return String.valueOf(beforePoint);

        StringBuilder sb = new StringBuilder();
        if(beforePoint == 0 && numerator>0 && denominator<0){
            sb.append("-");
        }
        sb.append(beforePoint);
        sb.append(".");

        int i = sb.length();
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(reminder, i);

        while(true){
            reminder = reminder*10;
            beforePoint = (int)Math.abs(reminder/denominator);
            reminder = Math.abs(reminder%denominator);

            if(map.containsKey(reminder)){
                sb.insert(map.get(reminder), "(");
                sb.append(beforePoint);
                sb.append(")");
                return sb.toString();
            }

            sb.append(beforePoint);
            if(reminder == 0)
                return sb.toString();


            i++;
            map.put(reminder, i);



        }

    }
}
