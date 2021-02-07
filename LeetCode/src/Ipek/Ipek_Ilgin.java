package Ipek;

public class Ipek_Ilgin {

    // double > int

    public static void main(String[] args) {
        //System.out.println(exp2(5));
        //System.out.println(exp3(5));
        //System.out.println(exp4(5.9));

        int[] arr = {1,3,5,6,3,7};
        lastIndexOf(arr,3);

    }
/*
    public static int exp1(int a){

        double b = 5.0 + a;

        return b;

    }
*/
    public static double exp2(int a){

        int b = 5 + a;

        return b;

    }

    public static double exp3(int a){ // a = 5

        return a/(2+3.0);

    }

    public static double exp4(double a){

        return Math.min(a,6);

    }

    public static void fib(){
        int limit = 10;

        int fib1 = 1;
        int fib2 = 1;

        for(int i=0; i<limit; i++){

            if(i<2){
                System.out.println(1);
            }else{
                // 2 = 1 + 1
                // 3 = 2 + 1
                // 5 = 3 + 2

                fib1 = fib1 + fib2;
                System.out.println(fib1);
                fib2 = fib1 - fib2;

            }
        }

    }

    public static void q1(){

        for(int i=0; i<10; i++){
            System.out.print(i + " ");
        }

    }

    //0123456789
    //0 1 2 3 4 5 6 7 8 9

    public static void q2(){
        for(int i=0; i<5; i++){
            for(int j=0; j<=i; j++) {
                System.out.print(j);
            }
        }
    }
    //01234
    //001012012301234

    //i = 0 1
    //j = 0 1 0
    //001
    public static void q3(){
        for(int i=0; i<5; i++){
            for(int j=0; j<i; j++) {
                System.out.print(i);
            }
        }
    }
    //1223334444

    public static void q4(){
        /*for(int i=0; i<5; i++){
            System.out.print(i);
        }
        for(int i=5; i>0; i--){
            System.out.print(i);
        }
        */
        System.out.print("\"");
    }

    //0123454321

//   /\   /  \    \"  \'
    //\\
   ///\\\
  ////\\\\

    public static void q5(){

        for(int i=0; i<4; i++){

            for(int j=3; j>i; j--){
                System.out.print(" ");
            }
            // i = 0 -> / -> i+1
            // i = 1 -> //

            for(int j=1; j<=i+1; j++){
                System.out.print("/");
            }

            for(int j=1; j<=i+1; j++){
                System.out.print("\\");
            }

            System.out.println();
        }
    }

    //1
    //1 2
    //3 5 8
    //13 21 34 55

    /*
    len = 5
     _____
    |     |
    |     |
    |     |
    |     |
    |_____|

    len = 2
     __
    |  |
    |__|

    */

    public static void q6(int len){
        System.out.print(" ");
        for(int i=0; i<len; i++){
            System.out.print("_");
        }
        System.out.println();

        for(int i=0; i<len; i++){

            System.out.print("|");

            for(int j=0; j<len; j++){
                if(i == len-1){
                    System.out.print("_");
                }else{
                    System.out.print(" ");
                }
            }

            System.out.print("|");
            System.out.println();
        }

    }




    public static int lastIndexOf(int[] arr, int val){

        int index = -1;

        for(int i=0; i<arr.length; i++){
            if(arr[i] == val){
                index = i;
            }
        }

        return index;
    }





}
