import java.util.ArrayList;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class LCA_Path_Method {

    // Function to find LCA
    public static Node lca(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        // Find paths from root to n1 and n2
        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i = 0;

        // Find last common node in both paths
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }

        // Last common node
        return path1.get(i - 1);
    }

    // Helper function to store path from root to node
    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if (root == null) {
            return false;
        }

        path.add(root);

        if (root.data == n) {
            return true;
        }

        if (getPath(root.left, n, path)) {
            return true;
        }

        if (getPath(root.right, n, path)) {
            return true;
        }

        // Backtracking
        path.remove(path.size() - 1);
        return false;
    }

    // MAIN METHOD
    public static void main(String[] args) {

        /*
                1
               / \
              2   3
             / \ / \
            4  5 6  7
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int n1 = 4;
        int n2 = 6;

        Node lca = lca(root, n1, n2);

        System.out.println("LCA of " + n1 + " and " + n2 + " is: " + lca.data);
    }
}
