package Medium;

public class Unique_Paths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(6,4));

    }
    private static int uniquePaths(int m, int n) {

        int x = m+n-2;
        int y = Math.min(m, n)-1;
        double result = 1;
        double div = 1;
        while(y>0){
            result *= x;
            div *= y;
            x--;
            y--;
        }
        return (int) (result/div);
    }

}
