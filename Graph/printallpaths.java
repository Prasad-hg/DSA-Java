import java.util.*;

public class printallpaths {

    static class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            src = s;
            dest = d;
        }
    }

    // create directed graph
    static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 3));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    // DFS to print all paths
    public static void printAllPath(
            ArrayList<Edge>[] graph,
            int src,
            int dest,
            boolean[] vis,
            String path) {

        if (src == dest) {
            System.out.println(path + dest);
            return;
        }

        vis[src] = true;

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);

            if (!vis[e.dest]) {
                printAllPath(graph, e.dest, dest, vis, path + src + " ");
            }
        }

        // BACKTRACK
        vis[src] = false;
    }

    public static void main(String[] args) {

        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        int src = 5, dest = 1;

        boolean[] vis = new boolean[V];

        printAllPath(graph, src, dest, vis, "");
    }
}
