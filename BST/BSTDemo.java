public class BSTDemo {

    // Node structure
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // INSERT into BST (recursive)
    public static Node insert(Node root, int value) {

        // Base case: empty place found
        if (root == null) {
            return new Node(value);
        }

        // Go left
        if (value < root.data) {
            root.left = insert(root.left, value);
        }
        // Go right
        else {
            root.right = insert(root.right, value);
        }

        // Return unchanged root
        return root;
    }

    // INORDER traversal
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // MAIN
    public static void main(String[] args) {

        int[] values = {5, 1, 3, 4, 2, 7};

        Node root = null;

        // Building BST
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        // Print inorder traversal
        System.out.print("Inorder Traversal: ");
        inorder(root);
    }
}
