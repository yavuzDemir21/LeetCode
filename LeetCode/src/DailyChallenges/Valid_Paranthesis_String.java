package DailyChallenges;

public class Valid_Paranthesis_String {
    public static void main(String[] args) {

    }

    public static boolean checkValidString(String s) {

        int countParanthesis =0;
        int countStar = 0;

        char[] arr = s.toCharArray();

        for(char c : arr){

            if(c=='*'){
                countStar++;
            }else if(c== '('){
                countParanthesis++;
            }else{
                countParanthesis--;
            }

            if(countParanthesis < 0){
                if(countStar == 0){
                    return false;
                }else{
                    countParanthesis = 0;
                    countStar--;
                }
            }
        }

        countParanthesis =0;
        countStar = 0;

        for(int i=arr.length-1; i>=0; i--){

            char c = arr[i];

            if(c=='*'){
                countStar++;
            }else if(c== ')'){
                countParanthesis++;
            }else{
                countParanthesis--;
            }

            if(countParanthesis < 0){
                if(countStar == 0){
                    return false;
                }else{
                    countParanthesis = 0;
                    countStar--;
                }
            }
        }

        return true;
    }
}
