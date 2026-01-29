import java.util.*;

public class DijkstraRun {

    // Edge class
    static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // Pair for PriorityQueue
    static class Pair implements Comparable<Pair> {
        int n;
        int path;

        Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path; // min heap
        }
    }

    // create weighted directed graph
    static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    // Dijkstra Algorithm
    public static void dijkstra(ArrayList<Edge>[] graph, int src) {

        int V = graph.length;

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        boolean[] vis = new boolean[V];

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {

            Pair curr = pq.remove();

            if (vis[curr.n]) continue;

            vis[curr.n] = true;

            for (int i = 0; i < graph[curr.n].size(); i++) {

                Edge e = graph[curr.n].get(i);

                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if (dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        System.out.println("Shortest distance from source " + src + ":");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " -> " + dist[i]);
        }
    }

    public static void main(String[] args) {

        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        dijkstra(graph, 0);
    }
}
