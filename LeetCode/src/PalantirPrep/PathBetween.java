package PalantirPrep;

import Structures.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class PathBetween {

    static int n1, n2, found1 = -1, found2 = -1;
    public static void main(String[] args) {

    }

    public static ArrayList<TreeNode> findPath(TreeNode root, int node1, int node2){
        ArrayList<TreeNode> path = new ArrayList<>();
        n1 = node1;
        n2 = node2;
        HashSet<Integer> set = new HashSet<>();
        dfs(root, set);

        return path;
    }

    public static void dfs(TreeNode node, HashSet<Integer> set){
        if(node == null) return;

        set.add(node.val);


    }

}
