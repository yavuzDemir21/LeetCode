package DailyChallenges;

import java.util.LinkedList;
import java.util.Queue;

class Coor{
    int x;
    int y;
    public Coor(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Number_of_Islands {
    public static void main(String[] args) {

    }

    public int numIslands(char[][] grid) {

        int count = 0;
        if(grid.length == 0) return count;

        boolean[][] visited = new boolean[grid.length][grid[0].length];



        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){

                if(!visited[i][j] && grid[i][j] == '1'){
                    count++;

                    visited[i][j] = true;
                    Queue<Coor> queue = new LinkedList<>();
                    queue.add(new Coor(i, j));

                    while(!queue.isEmpty()){

                        Coor coor = queue.remove();

                        if(coor.x>0 && !visited[coor.x-1][coor.y] && grid[coor.x-1][coor.y] == '1'){
                            visited[coor.x-1][coor.y] = true;
                            queue.add(new Coor(coor.x-1, coor.y));
                        }

                        if(coor.x<grid.length-1 && !visited[coor.x+1][coor.y] && grid[coor.x+1][coor.y] == '1'){
                            visited[coor.x+1][coor.y] = true;
                            queue.add(new Coor(coor.x+1, coor.y));
                        }

                        if(coor.y>0 && !visited[coor.x][coor.y-1] && grid[coor.x][coor.y-1] == '1'){
                            visited[coor.x][coor.y-1] = true;
                            queue.add(new Coor(coor.x, coor.y-1));
                        }

                        if(coor.y<grid[0].length-1 && !visited[coor.x][coor.y+1] && grid[coor.x][coor.y+1] == '1'){
                            visited[coor.x][coor.y+1] = true;
                            queue.add(new Coor(coor.x, coor.y+1));
                        }

                    }




                }

            }
        }

        return count;

    }

}
