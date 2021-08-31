package probs;

import java.util.*;

/**
 *
 * Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node,
 v is the target node, and w is the time it takes for a signal to travel from source to target.

 Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal?
 If it is impossible, return -1.

 Example 1:

 2
 1          3
 4

 Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
 Output: 2
 *
 *
 *
 */
public class DijkstraAlgo {

    public static Map<Integer, Integer> dist;

    public static void main(String args[]){
        int[][] times = new int[][]{{2,1,1},{2,3,1},{3,4,1}};
        int N=4, K=2;

        int result = networkDelayTime(times, N, K);
        System.out.println("Total Time its take to travel : " + result);

    }


    public static int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap();
        for (int[] edge: times) {
            if (!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<int[]>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        dist = new HashMap();
        for (int node = 1; node <= N; ++node)
            dist.put(node, Integer.MAX_VALUE);

        dist.put(K, 0);
        boolean[] seen = new boolean[N+1];

        while (true) {
            int candNode = -1;
            int candDist = Integer.MAX_VALUE;
            for (int i = 1; i <= N; ++i) {
                if (!seen[i] && dist.get(i) < candDist) {
                    candDist = dist.get(i);
                    candNode = i;
                }
            }

            if (candNode < 0) break;
            seen[candNode] = true;
            if (graph.containsKey(candNode))
                for (int[] info: graph.get(candNode))
                    dist.put(info[0],
                            Math.min(dist.get(info[0]), dist.get(candNode) + info[1]));
        }

        int ans = 0;
        for (int cand: dist.values()) {
            if (cand == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, cand);
        }
        return ans;
    }
}