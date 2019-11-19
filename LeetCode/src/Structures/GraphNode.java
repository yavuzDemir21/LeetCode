package Structures;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    public int val;
    public int reachCost;
    public boolean visited;
    public List<Pair<GraphNode, Integer>> neighbors;
    public GraphNode(int v){
        this.val = v;
        reachCost = Integer.MAX_VALUE;
        visited =false;
        neighbors = new ArrayList<>();
    }

    public int getCost(){
        return reachCost;
    }

}
