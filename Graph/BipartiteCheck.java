import java.util.*;

public class BipartiteCheck {

    // Edge class
    static class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // Create graph (example: bipartite)
    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Bipartite example:
        // 0 -- 1
        // |    |
        // 2 -- 3

        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 0));

        graph[0].add(new Edge(0, 2));
        graph[2].add(new Edge(2, 0));

        graph[1].add(new Edge(1, 3));
        graph[3].add(new Edge(3, 1));

        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 2));
    }

    // Bipartite check using BFS
    public static boolean isBipartite(ArrayList<Edge>[] graph) {

        int[] col = new int[graph.length];

        // initialize colors with -1
        for (int i = 0; i < col.length; i++) {
            col[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();

        // for disconnected components
        for (int i = 0; i < graph.length; i++) {

            if (col[i] == -1) {

                q.add(i);
                col[i] = 0; // first color

                while (!q.isEmpty()) {
                    int curr = q.remove();

                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);

                        if (col[e.dest] == -1) {
                            int nextCol = (col[curr] == 0) ? 1 : 0;
                            col[e.dest] = nextCol;
                            q.add(e.dest);

                        } else if (col[e.dest] == col[curr]) {
                            return false; // NOT bipartite
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        System.out.println(isBipartite(graph));
    }
}
