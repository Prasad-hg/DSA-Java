public class LongestWordWithAllPrefixes {

    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;
    }

    static Node root = new Node();
    static String ans = "";

    // Insert word into Trie
    public static void insert(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    // DFS traversal: only continue if prefix is a word
    public static void dfs(Node node, StringBuilder sb) {

        if (node != root && node.eow == false) {
            return;
        }

        if (sb.length() > ans.length()) {
            ans = sb.toString();
        }

        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                sb.append((char) (i + 'a'));
                dfs(node.children[i], sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {

        String[] words = {
            "a", "banana", "app", "appl", "ap", "apply", "apple"
        };

        for (String word : words) {
            insert(word);
        }

        dfs(root, new StringBuilder());

        System.out.println(ans);
    }
}
