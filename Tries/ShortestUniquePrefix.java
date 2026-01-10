public class ShortestUniquePrefix {

    static class Node {
        Node[] children = new Node[26];
        int freq = 0;
    }

    static Node root = new Node();

    // Insert word into Trie
    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
            curr.freq++; // count how many words pass through
        }
    }

    // Find shortest unique prefix
    public static String getPrefix(String word) {
        Node curr = root;
        StringBuilder prefix = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            curr = curr.children[idx];
            prefix.append(word.charAt(i));

            if (curr.freq == 1) {
                break;
            }
        }
        return prefix.toString();
    }

    public static void main(String[] args) {

        String[] words = {"zebra", "dog", "duck", "dove"};

        // Build Trie
        for (String word : words) {
            insert(word);
        }

        // Print shortest unique prefixes
        for (String word : words) {
            System.out.println(getPrefix(word));
        }
    }
}
