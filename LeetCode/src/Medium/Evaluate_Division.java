package Medium;

import Structures.DivGraphNode;

import java.util.HashMap;
import java.util.List;

public class Evaluate_Division {
    public static void main(String[] args) {

    }

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        double[] result = new double[queries.size()];
        int i = 0;
        HashMap<String, DivGraphNode> map = constructGraph(equations, values);
        for (List<String> query : queries){

            String root = query.get(0);
            String target = query.get(1);

        }
        return result;

    }

    private static HashMap<String, DivGraphNode> constructGraph(List<List<String>> equations, double[] values){

        HashMap<String, DivGraphNode> map = new HashMap<>();

        int i = 0;
        for(List<String> eq : equations){
            if(!map.containsKey(eq.get(0))){
                map.put(eq.get(0), new DivGraphNode(eq.get(0)));
            }
            if(!map.containsKey(eq.get(1))){
                map.put(eq.get(1), new DivGraphNode(eq.get(1)));
            }

            map.get(eq.get(0)).addElement(map.get(eq.get(1)), values[i]);
            map.get(eq.get(1)).addElement(map.get(eq.get(0)), 1.0/values[i]);
            i++;
        }

        return map;
    }

    private static double bfs(DivGraphNode root, String target){


        return 0.0;


    }


}
