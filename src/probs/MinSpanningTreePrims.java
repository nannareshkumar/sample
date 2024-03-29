package probs;// A Java program for Prim's Minimum Spanning Tree (probs.MST) algorithm.
// The program is for adjacency matrix representation of the graph

import java.lang.*;

class MinSpanningTreePrims {
    // Number of vertices in the graph
    private static final int V = 5;

    int minKey(int key[], Boolean mstSet[]) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (mstSet[v] == false && key[v] < min) {
                min = key[v];
                min_index = v;
            }

        return min_index;
    }

    void printMST(int parent[], int graph[][]) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }

    void primMST(int graph[][]) {
        int parent[] = new int[V];
        int key[] = new int[V];
        Boolean mstSet[] = new Boolean[V];
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
        key[0] = 0; // Make key 0 so that this vertex is
        parent[0] = -1; // First node is always root of probs.MST
        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;
            for (int v = 0; v < V; v++)
                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }

        // print the constructed probs.MST
        printMST(parent, graph);
    }

    public static void main(String[] args)
    {
		/* Let us create the following graph
	        2     3
		(0)- ->(1)--(2)
		|    / \    |
	   6|  8/   \5  |7
		|/ 	     \  |
		(3)-------(4)
			9		 */
        MinSpanningTreePrims t = new MinSpanningTreePrims();
        int graph[][] = new int[][]
              { { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };

        // Print the solution
        t.primMST(graph);
    }
}
// This code is contributed by Aakash Hasija
