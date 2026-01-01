class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class SumTree {

    // -------- TRANSFORM TO SUM TREE --------
    public static int transform(Node root) {
        if (root == null) {
            return 0;
        }

        // Step 1: Go left
        int leftSum = transform(root.left);

        // Step 2: Go right
        int rightSum = transform(root.right);

        // Step 3: Store old value
        int oldValue = root.data;

        // Step 4: Update node value
        root.data = leftSum + rightSum;

        // Step 5: Return total sum for parent
        return root.data + oldValue;
    }

    // -------- PREORDER TRAVERSAL --------
    public static void preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // -------- MAIN --------
    public static void main(String[] args) {

        /*
                1
              /   \
             2     3
            / \   / \
           4   5 6   7
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Convert to sum tree
        transform(root);

        // Print preorder of sum tree
        preorder(root);
    }
}
