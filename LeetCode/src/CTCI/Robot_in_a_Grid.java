package CTCI;

public class Robot_in_a_Grid {
    public static void main(String[] args) {

        boolean[][] grid = {{true, true, false}, {true, false, true}, {true, false, true}};



        System.out.println(findPath(grid));

    }
    public static boolean findPath(boolean[][] grid){



        return helper(grid, 0 ,0 ,"");

    }

    public static boolean helper(boolean[][] grid, int i, int j, String path){
        if(i == grid.length-1 && j==grid[0].length-1) return true;

        boolean p1 = false, p2 = false;

        if(i< grid.length-1 && grid[i+1][j]){
            grid[i+1][j] = false;
            p1 =  helper(grid, i+1, j, path+"D");
        }

        if(j < grid[0].length-1 && grid[i][j+1]){
            grid[i][j+1] = false;
            p2 =  helper(grid, i, j+1, path+"R");
        }

        return p1 || p2;

    }
}
