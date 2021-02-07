public class ToCamelCase {
    public static void main(String[] args) {
        String test = "i_had_a_good_interview_with_crossover_today";
        System.out.println(toCamelCase(test));
    }

//crossover_interview
    private static String toCamelCase(String s){

        StringBuilder sb = new StringBuilder();

        boolean seen = false;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(c == '_'){
                seen = true;
            }else{
                if(seen){
                    c = (char)(c + ('A'-'a'));
                    seen = false;
                }
                sb.append(c);
            }

        }


        return sb.toString();
    }
}
