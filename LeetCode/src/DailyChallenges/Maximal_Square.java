package DailyChallenges;

public class Maximal_Square {
    public static void main(String[] args) {

        char[][] arr = {{'0', '0', '0', '1'}, {'1', '1', '0', '1'}, {'1', '1', '1', '1'}, {'0', '1', '1', '1'}, {'0', '1', '1', '1'}};

//        0 0 0 1
//        1 1 0 1
//        1 1 1 1
//        0 1 1 1
//        0 1 1 1

        System.out.println(maximalSquare(arr));

    }

    public static int maximalSquare(char[][] matrix) {


        if (matrix == null || matrix.length == 0) return 0;

        int max = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (i > 0 && j > 0 && matrix[i][j] == '1') {


                    int lim = matrix[i - 1][j - 1] - '0';


                    for (int c = i - 1; c > i - 1 - lim; c--) {
                        if (matrix[c][j] == '0') {
                            lim = i - c - 1;
                            break;
                        }
                    }


                    for (int r = j - 1; r > j - 1 - lim; r--) {
                        if (matrix[i][r] == '0') {
                            lim = Math.min(lim, j - r - 1);
                            break;
                        }
                    }

                    matrix[i][j] = (char)('1' + lim);
                    max = Math.max(max, matrix[i][j] - '0');


                } else {
                    if (max == 0 && matrix[i][j] == '1') max = 1;
                }

            }
        }

        return max * max;
    }

    public static int maximalSquare2(char[][] matrix) {

        return 0;

    }
}