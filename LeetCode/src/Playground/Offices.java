package Playground;
import java.util.*;
import java.lang.*;

class Point{
    int x;
    int y;
    Point(int i, int j){
        x = i;
        y = j;
    }
}


class Solution
{
    public static int numOffices(String[][] grid) {
        int result = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(visited[i][j]) continue;

                visited[i][j] = true;

                if(grid[i][j].equals("1")){
                    result++;

                    LinkedList<Point> list = new LinkedList<>();
                    list.add(new Point(i, j));

                    while (!list.isEmpty()){
                        Point p = list.pop();

                        if(p.x>0 && !visited[p.x-1][p.y]){
                            if(grid[p.x-1][p.y].equals("1"))
                                list.add(new Point(p.x-1, p.y));
                            
                            visited[p.x-1][p.y] = true;
                        }

                        if(p.x<grid.length-1 && !visited[p.x+1][p.y] && grid[p.x+1][p.y].equals("1")){
                            list.add(new Point(p.x+1, p.y));
                            visited[p.x+1][p.y] = true;
                        }

                        if(p.y>0 && !visited[p.x][p.y-1] && grid[p.x][p.y-1].equals("1")){
                            list.add(new Point(p.x, p.y-1));
                            visited[p.x][p.y-1] = true;
                        }

                        if(p.y < grid[0].length-1 && !visited[p.x][p.y+1] && grid[p.x][p.y+1].equals("1")){
                            list.add(new Point(p.x, p.y+1));
                            visited[p.x][p.y+1] = true;
                        }

                    }


                }

            }
        }

        return result;
    }
}

public class Offices {

    public static String[][] getMatrix() {
        Scanner sc = new Scanner(System.in);
        int rowsLen = sc.nextInt();
        int colsLen = sc.nextInt();
        String matrix[][] = new String[rowsLen][colsLen];
        int i;
        for(i=0;i<rowsLen;i++){
            String line = sc.next();
            for(int j=0;j<line.length();j++) {
                matrix[i][j] = String.valueOf(line.charAt(j));
            }
        }
        return matrix;
    }

    public static void main(String args[])
    {
        int result = Solution.numOffices(getMatrix());
        System.out.println(result);
    }
}
