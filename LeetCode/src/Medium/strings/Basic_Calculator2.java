package Medium.strings;

public class Basic_Calculator2 {
    public static void main(String[] args) {

        System.out.println(calculate(" 5+5*5+5/5*5+5 "));
    }

    public static int calculate(String s) {

        char[] arr = s.toCharArray();
        int result = 0;
        int num = 0;
        int prev = 0;
        char op = '+';

        for(char c : arr){
            if(c == ' ') continue;

            if(Character.isDigit(c)){
                num = num*10 + c - '0';
            }else{
                if(c == '+' || c == '-'){
                    if(op == '+'){
                        result += num;
                    }else if(op == '-'){
                        result -= num;
                    }else if(op == '*'){
                        result += prev * num;
                    }else if(op == '/'){
                        result += prev / num;
                    }
                }else {
                    if(op == '*'){
                        prev = prev * num;
                    }else if(op == '/'){
                        prev = prev / num;
                    }else if(op == '-'){
                        prev = -num;
                    }else{
                        prev = num;
                    }


                }
                num = 0;
                op = c;
            }
        }

        if(op == '+'){
            result += num;
        }else if(op == '-'){
            result -= num;
        }else if(op == '*'){
            result += prev * num;
        }else if(op == '/') {
            result += prev / num;
        }

        return result;
    }
}
