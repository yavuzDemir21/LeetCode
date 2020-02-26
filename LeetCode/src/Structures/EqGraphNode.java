package Structures;

import java.util.ArrayList;
import java.util.List;

public class EqGraphNode {
    public char val;
    public List<EqGraphNode> connects;
    public int set;
    public EqGraphNode(char val){
        this.val = val;
        connects = new ArrayList<>();
        set = -1;
    }
}
