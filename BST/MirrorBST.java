import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class MirrorBST {

    // Insert into BST
    public static Node insert(Node root, int val) {
        if (root == null) return new Node(val);

        if (val < root.data)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);

        return root;
    }

    // Preorder traversal: Root -> Left -> Right
    public static void preorder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Mirror the tree (your logic)
    public static Node createMirror(Node root) {
        if (root == null) return null;

        Node leftMirror = createMirror(root.left);
        Node rightMirror = createMirror(root.right);

        root.left = rightMirror;
        root.right = leftMirror;

        return root;
    }

    // MAIN METHOD
    public static void main(String[] args) {

        int[] values = {8, 5, 3, 6, 10, 11, 12};
        Node root = null;

        // Build BST
        for (int v : values) {
            root = insert(root, v);
        }

        System.out.println("Preorder BEFORE mirror:");
        preorder(root);

        // Mirror the tree
        createMirror(root);

        System.out.println("\nPreorder AFTER mirror:");
        preorder(root);
    }
}
