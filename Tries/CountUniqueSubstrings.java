public class CountUniqueSubstrings {

    // ---------- Trie Node ----------
    static class Node {
        Node[] children = new Node[26];
    }

    // ---------- Trie Root ----------
    static Node root = new Node();

    // ---------- Insert a string into Trie ----------
    public static void insert(String s) {
        Node curr = root;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
    }

    // ---------- Count nodes in Trie ----------
    // Each node (except root) = one unique substring
    public static int countNodes(Node node) {
        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                count += countNodes(node.children[i]);
            }
        }
        return count + 1; // count current node
    }

    // ---------- Main ----------
    public static void main(String[] args) {

        String str = "ababa";

        // Insert all suffixes
        for (int i = 0; i < str.length(); i++) {
            insert(str.substring(i));
        }

        // Total nodes minus root
        int uniqueSubstrings = countNodes(root) - 1;

        System.out.println("Unique substrings count: " + uniqueSubstrings);
    }
}
