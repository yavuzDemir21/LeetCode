package DailyChallenges;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Actor {
    int x;
    int y;
    int sum;

    public Actor(int x, int y, int sum) {
        this.x = x;
        this.y = y;
        this.sum = sum;
    }

    public int getSum() {
        return sum;
    }
}

public class Minimum_Path_Sum {
    public static void main(String[] args) {
        int[][] arr = {{1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        System.out.println(minPathSum(arr));


    }

    public static int minPathSum(int[][] grid) {

        if (grid.length == 0) {
            return 0;
        }

        Actor actor = new Actor(0, 0, grid[0][0]);
        grid[0][0] = -1;
        Comparator<Actor> cmp = Comparator.comparing(Actor::getSum);
        Queue<Actor> queue = new PriorityQueue<>(cmp);
        queue.add(actor);

        while (!queue.isEmpty()) {
            Actor cur = queue.remove();
            if (cur.x == grid.length - 1 && cur.y == grid[0].length - 1) return cur.sum;


            if (cur.x < grid.length - 1 && grid[cur.x + 1][cur.y] != -1) {
                Actor down = new Actor(cur.x + 1, cur.y, cur.sum + grid[cur.x + 1][cur.y]);
                grid[cur.x + 1][cur.y] = -1;
                queue.add(down);
            }

            if (cur.y < grid[0].length - 1 && grid[cur.x][cur.y + 1] != -1) {
                Actor right = new Actor(cur.x, cur.y + 1, cur.sum + grid[cur.x][cur.y + 1]);
                grid[cur.x][cur.y + 1] = -1;
                queue.add(right);
            }


        }

        return 0;
    }

    public static int minPathSum2(int[][] grid){

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){

                int adder =0;
                if(!(i==0 && j==0)) {
                    if (i == 0) {
                        adder = grid[i][j - 1];
                    } else if (j == 0) {
                        adder = grid[i - 1][j];
                    }else{
                        adder = Math.min(grid[i][j - 1], grid[i - 1][j]);
                    }
                }
                grid[i][j] = grid[i][j] + adder;

            }
        }


        return grid[grid.length-1][grid[0].length-1];
    }

}
