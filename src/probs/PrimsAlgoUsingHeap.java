package probs;

/**
 * Created by home on 1/20/2021.
 */

// Java program for Prim's MST for
// adjacency list representation of graph
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.Comparator;

public class PrimsAlgoUsingHeap {

        class Edge {
            int dest;
            int weight;
            Edge(int a, int b) {
                dest = a;
                weight = b;
            }
        }
        static class Graph {
            int V;
            LinkedList<Edge>[] adj;
            Graph(int e) {
                V = e;
                adj = new LinkedList[V];
                for (int o = 0; o < V; o++)
                    adj[o] = new LinkedList<>();
            }
        }

        class Node {
            int vertex;
            int key;
        }

    // Comparator class created for PriorityQueue
    // returns 1 if node0.key > node1.key
    // returns 0 if node0.key < node1.key and
    // returns -1 otherwise
        class comparator implements Comparator<Node> {

            @Override
            public int compare(Node node0, Node node1) {
                return node0.key - node1.key;
            }
        }

        void addEdge(Graph graph, int src, int dest, int weight) {

            Edge node0 = new Edge(dest, weight);
            Edge node = new Edge(src, weight);
            graph.adj[src].addLast(node0);
            graph.adj[dest].addLast(node);
        }

        // method used to find the mst
        void prims_mst(Graph graph) {

            // Whether a vertex is in PriorityQueue or not
            Boolean[] mstset = new Boolean[graph.V];
            Node[] e = new Node[graph.V];

            // Stores the parents of a vertex
            int[] parent = new int[graph.V];

//            for (int o = 0; o < graph.V; o++)
//                e[o] = new Node();

            for (int o = 0; o < graph.V; o++) {
                mstset[o] = false;
                e[o] = new Node();
                e[o].key = Integer.MAX_VALUE;
                e[o].vertex = o;
                parent[o] = -1;
            }

            // Include the source vertex in mstset
            mstset[0] = true;
            e[0].key = 0;

            // Use TreeSet instead of PriorityQueue as the remove function of the PQ is O(n) in java.
            TreeSet<Node> queue = new TreeSet<Node>(new comparator());

            for (int o = 0; o < graph.V; o++)
                queue.add(e[o]);

            while (!queue.isEmpty()) {
                Node node0 = queue.pollFirst();
                mstset[node0.vertex] = true;
                for (Edge nr : graph.adj[node0.vertex]) {
                    if (mstset[nr.dest] == false) {
                        if (e[nr.dest].key > nr.weight) {
                            queue.remove(e[nr.dest]);
                            e[nr.dest].key = nr.weight;
                            queue.add(e[nr.dest]);
                            parent[nr.dest] = node0.vertex;
                        }
                    }
                }
            }

            // Prints the vertex pair of mst
            for (int o = 1; o < graph.V; o++)
                System.out.println(parent[o] + " "
                        + "-"
                        + " " + o);
        }

        public static void main(String[] args)
        {
            int V = 9;

            Graph graph = new Graph(V);

            PrimsAlgoUsingHeap e = new PrimsAlgoUsingHeap();

            e.addEdge(graph, 0, 1, 4);
            e.addEdge(graph, 0, 7, 8);
            e.addEdge(graph, 1, 2, 8);
            e.addEdge(graph, 1, 7, 11);
            e.addEdge(graph, 2, 3, 7);
            e.addEdge(graph, 2, 8, 2);
            e.addEdge(graph, 2, 5, 4);
            e.addEdge(graph, 3, 4, 9);
            e.addEdge(graph, 3, 5, 14);
            e.addEdge(graph, 4, 5, 10);
            e.addEdge(graph, 5, 6, 2);
            e.addEdge(graph, 6, 7, 1);
            e.addEdge(graph, 6, 8, 6);
            e.addEdge(graph, 7, 8, 7);

            // Method invoked
            e.prims_mst(graph);

        }
    }
