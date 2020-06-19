package Medium.hashtable;

import java.util.*;

public class Brick_Wall {
    public static void main(String[] args) {


    }

    public static int leastBricks(List<List<Integer>> wall) {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(List<Integer> bricks : wall){
            Iterator<Integer> it = bricks.iterator();
            int edge =it.next();
            while(it.hasNext()){
                map.put(edge, map.getOrDefault(edge, 0) + 1);
                if(map.get(edge) > max){
                    max = map.get(edge);
                }
                edge += it.next();

            }
        }

        return wall.size() - max;

    }
}
