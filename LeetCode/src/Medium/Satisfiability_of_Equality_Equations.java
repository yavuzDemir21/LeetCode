package Medium;
/*
import Structures.EqGraphNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
*/
public class Satisfiability_of_Equality_Equations {
    public static void main(String[] args) {
        String[] eqs = {"a==b", "b==c", "c!=a"};
        System.out.println(equationsPossible(eqs));
    }

    /*
        public static boolean equationsPossible(String[] equations) {

            return constructGraph(equations);
        }

        private static boolean constructGraph(String[] equations) {

            HashMap<Character, EqGraphNode> map = new HashMap<>();
            HashMap<Integer, ArrayList<EqGraphNode>> setMap = new HashMap<>();

            int setCounter = 0;

            for (String eq : equations) {

                char v1 = eq.charAt(0), v2 = eq.charAt(3), op = eq.charAt(1);
                if (v1 == v2 && op == '!') {
                    return false;
                }

                if (!map.containsKey(v1)) {
                    map.put(v1, new EqGraphNode(v1));
                }
                if (!map.containsKey(v2)) {
                    map.put(v2, new EqGraphNode(v2));
                }

                EqGraphNode node1 = map.get(v1);
                EqGraphNode node2 = map.get(v2);

                if (op == '=') {
                    if (node1.set == -1 && node2.set == -1) {
                        node1.set = setCounter;
                        node2.set = setCounter;
                        ArrayList<EqGraphNode> arr = new ArrayList<>();
                        arr.add(node1);
                        arr.add(node2);
                        setMap.put(setCounter, arr);
                        setCounter++;
                    } else if (node1.set != -1 && node2.set != -1) {
                        if (node1.set != node2.set) {
                            //todo
                            return false;
                        }else {

                        }
                    } else {
                        if (node1.set != -1) {
                            node2.set = node1.set;
                        } else {
                            node1.set = node2.set;
                        }
                    }
                } else {

                }


            }
            return false;
        }

    */
    static int[] uf = new int[26];

    public static boolean equationsPossible(String[] equations) {
        for (int i = 0; i < 26; ++i) uf[i] = i;

        for (String e : equations) {
            if (e.charAt(1) == '!' && e.charAt(0) == e.charAt(3)) {
                return false;
            }
            if (e.charAt(1) == '=')
                uf[find(e.charAt(0) - 'a')] = find(e.charAt(3) - 'a');
        }

        for (String e : equations)
            if (e.charAt(1) == '!' && find(e.charAt(0) - 'a') == find(e.charAt(3) - 'a'))
                return false;
        return true;
    }

    public static int find(int x) {
        if (x != uf[x]) uf[x] = find(uf[x]);
        return uf[x];
    }
}
