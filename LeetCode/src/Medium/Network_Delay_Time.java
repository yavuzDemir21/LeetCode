package Medium;

import Structures.GraphNode;
import javafx.util.Pair;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Network_Delay_Time {
    public static void main(String[] args) {
        int[][] times = {{2, 1, 1}, {2, 3, 100}, {3, 4, 1}, {1, 4, 1}};

        System.out.println(networkDelayTime(times, 4, 2));
    }

    public static int networkDelayTime(int[][] times, int N, int K) {

        GraphNode start = constructGraph(times, N, K);
        Comparator<GraphNode> cp = Comparator.comparing(GraphNode::getCost);
        Queue<GraphNode> queue = new PriorityQueue<>(cp);
        queue.add(start);
        int visited = 0;
        int result = 0;
        while (!queue.isEmpty()) {
            GraphNode cur = queue.remove();
            if (!cur.visited) {
                cur.visited = true;
                visited++;
                result = Math.max(cur.getCost(), result);
                if (visited == N) {
                    return result;
                }
                for (Pair<GraphNode, Integer> edge : cur.neighbors) {
                    GraphNode nb = edge.getKey();
                    int w = edge.getValue();
                    if (nb.reachCost > w + cur.getCost()) {
                        nb.reachCost = w + cur.getCost();
                        queue.add(nb);
                    }
                }
            }
        }

        return -1;
    }

    private static GraphNode constructGraph(int[][] times, int N, int K) {

        GraphNode[] nodes = new GraphNode[N + 1];

        for (int i = 1; i <= N; i++) {
            nodes[i] = new GraphNode(i);
        }

        for (int i = 0; i < times.length; i++) {
            int u = times[i][0], v = times[i][1], w = times[i][2];
            nodes[u].neighbors.add(new Pair<>(nodes[v], w));
        }
        nodes[K].reachCost = 0;
        return nodes[K];
    }

}
