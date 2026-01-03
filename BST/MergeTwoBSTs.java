import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class MergeTwoBSTs {

    /* ---------- STEP 1: Inorder Traversal ---------- */
    static void inorder(Node root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }

    /* ---------- STEP 2: Merge Two Sorted Arrays ---------- */
    static List<Integer> merge(List<Integer> a, List<Integer> b) {
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;

        while (i < a.size() && j < b.size()) {
            if (a.get(i) <= b.get(j)) {
                res.add(a.get(i++));
            } else {
                res.add(b.get(j++));
            }
        }

        while (i < a.size()) res.add(a.get(i++));
        while (j < b.size()) res.add(b.get(j++));

        return res;
    }

    /* ---------- STEP 3: Build Balanced BST from Sorted Array ---------- */
    static Node buildBalancedBST(List<Integer> arr, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        Node root = new Node(arr.get(mid));

        root.left = buildBalancedBST(arr, start, mid - 1);
        root.right = buildBalancedBST(arr, mid + 1, end);

        return root;
    }

    /* ---------- Traversals for Verification ---------- */
    static void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    static void inorderPrint(Node root) {
        if (root == null) return;
        inorderPrint(root.left);
        System.out.print(root.data + " ");
        inorderPrint(root.right);
    }

    /* ---------- MAIN ---------- */
    public static void main(String[] args) {

        /*
            BST1:
                2
               / \
              1   4

            BST2:
                9
               / \
              3  12
        */

        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        // Step 1: Inorder traversal
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        inorder(root1, list1);
        inorder(root2, list2);

        System.out.println("Inorder BST1: " + list1);
        System.out.println("Inorder BST2: " + list2);

        // Step 2: Merge sorted lists
        List<Integer> merged = merge(list1, list2);
        System.out.println("Merged Sorted Array: " + merged);

        // Step 3: Build balanced BST
        Node balancedRoot = buildBalancedBST(merged, 0, merged.size() - 1);

        // Verification
        System.out.print("Inorder of Balanced BST: ");
        inorderPrint(balancedRoot);

        System.out.print("\nPreorder of Balanced BST: ");
        preorder(balancedRoot);
    }
}
