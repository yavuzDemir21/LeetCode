package Medium.arrays;

public class Spiral_Matrix_2 {
    public static void main(String[] args) {
        int n = 1;
        int[][] arr = generateMatrix(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];

        int loop = 0;

        while (loop < n/2) {
            int count = 1;
            int i = loop, j = loop;
            while (i < n - loop) {
                arr[j][i] = loop == 0 ? count : count + arr[loop][loop-1];
                arr[n - 1 - loop][i] = loop == 0 ? 3 * (n - 2 * loop) - count - 1 : 3 * (n - 2 * loop) - count - 1 + arr[loop][loop-1];
                i++;
                count++;
            }
            i--;
            j++;
            while (j < n - 1 - loop) {
                arr[j][i] = loop == 0 ? count : count + arr[loop][loop-1];
                arr[j][loop] = loop == 0 ? 5 * (n - 2 * loop) - 3 - count : 5 * (n - 2 * loop) - 3 - count + + arr[loop][loop-1];
                j++;
                count++;
            }
            loop++;
        }

        if (n % 2 == 1) {
            arr[n/2][n/2] = n * n;
        }

        return arr;

    }
}
