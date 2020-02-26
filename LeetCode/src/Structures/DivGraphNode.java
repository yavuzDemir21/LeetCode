package Structures;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class DivGraphNode {
    String val;
    List<Pair<DivGraphNode, Double>> neighbors;
    public DivGraphNode(String val){
        this.val = val;
        neighbors = new ArrayList<>();
    }

    public void addElement(DivGraphNode node, double val){
        neighbors.add(new Pair<>(node, val));
    }
}
