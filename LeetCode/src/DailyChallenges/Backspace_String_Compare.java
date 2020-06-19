package DailyChallenges;

public class Backspace_String_Compare {
    public static void main(String[] args) {

        System.out.print(backspaceCompare2("ba","ac"));
    }

    public static boolean backspaceCompare(String S, String T) {

        char[] w1 = S.toCharArray();
        char[] w2 = T.toCharArray();

        int i = w1.length - 1, j = w2.length - 1;

        while (i >= 0 || j >= 0) {

            int count = 0;
            if (i >=0 && w1[i] == '#') {
                i--;
                count++;

                while (i>=0 && (count>0 || w1[i] == '#')){

                    if(w1[i] == '#'){
                        count++;
                    }else{
                        count--;
                    }
                    i--;
                }

            }

            count = 0;
            if (j>=0 && w2[j] == '#') {
                j--;
                count++;

                while (j>=0 && (count>0 || w2[j] == '#')){

                    if(w2[j] == '#'){
                        count++;
                    }else{
                        count--;
                    }
                    j--;
                }
            }

            if(i>=0 && j>=0 && w1[i] != w2[j]){
                return false;
            }



            if(i<0 && j<0){
                return true;
            }else{
                if(i<0 || j<0){
                    return false;
                }
            }

            i--;
            j--;

        }

        return true;

    }

    public static boolean backspaceCompare2(String S, String T) {
        int result = 0;
        int charMultiplier = 1;
        int numOfBackSpace = 0;
        for(int i = S.length()-1; i >=0; i--){
            char c = S.charAt(i);
            if(c == '#'){
                numOfBackSpace++;
            }
            else {
                if(numOfBackSpace == 0){
                    result += charMultiplier * c;
                    charMultiplier++;
                }
                else{
                    numOfBackSpace--;
                }
            }
        }
        System.out.println(result);
        charMultiplier = 1;
        numOfBackSpace = 0;
        for(int i = T.length()-1; i >=0; i--){
            char c = T.charAt(i);
            if(c == '#'){
                numOfBackSpace++;
            }
            else {
                if(numOfBackSpace == 0){
                    result -= charMultiplier * c;
                    charMultiplier++;
                }
                else{
                    numOfBackSpace--;
                }
            }
        }
        System.out.println(result);
        return result == 0;
    }
}
