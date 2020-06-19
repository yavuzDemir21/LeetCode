package Medium.hashtable;

import java.util.HashMap;
import java.util.HashSet;

public class Max_Points {
    public static void main(String[] args) {

        // Think about negative variations

        int[][] arr = {{0,0},{1,1}, {0,0}};
        System.out.print(maxPoints(arr));

    }
    public static int maxPoints(int[][] points) {

        if(points.length == 0){
            return 0;
        }
        HashMap<Integer, HashMap<Integer, Integer>> frequency = new HashMap<>();

        int max = 1;


        for(int i=0; i<points.length; i++){
            if(frequency.containsKey(points[i][0])){
               frequency.get(points[i][0]).put(points[i][1], frequency.get(points[i][0]).getOrDefault(points[i][1], 0) + 1);
               if(max < frequency.get(points[i][0]).get(points[i][1])){
                   max = frequency.get(points[i][0]).get(points[i][1]);
               }
            }else{
                HashMap<Integer, Integer> temp = new HashMap<>();
                temp.put(points[i][1], 1);
                frequency.put(points[i][0], temp);
            }
        }

        HashMap<Double, Integer> map = new HashMap<>();
        for(int i =0; i<points.length; i++){
            HashSet<Double> set = new HashSet<>();
            for(int j=0; j<i; j++){
                if(points[i][0] == points[j][0] && points[i][1] == points[j][1]) continue;
                double m = points[i][1] - points[j][1] == 0 ? 0 : (1.0*(points[i][1] - points[j][1]))/(points[i][0]- points[j][0]);
                m = m == -1.0/0 ? 1.0/0 : m;
                System.out.println(m);
                if(!set.contains(m)){
                    set.add(m);
                    int f = 1;
                    if(frequency.containsKey(points[j][0])){
                        f = frequency.get(points[j][0]).getOrDefault(points[j][1], 1);
                    }
                    map.put(m, map.getOrDefault(m, f) + 1);
                    if(map.get(m) > max){
                        max = map.get(m);
                    }
                }
            }
        }

        return max;

    }
}
