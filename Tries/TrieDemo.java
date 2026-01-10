public class TrieDemo {

    // ---------- Node definition ----------
    static class Node {
        Node[] children = new Node[26]; // a–z
        boolean eow; // end of word
    }

    // ---------- Root of Trie ----------
    static Node root = new Node();

    // ---------- Insert a word ----------
    public static void insert(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    // ---------- Search a word ----------
    public static boolean search(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow;
    }

    // ---------- Main ----------
    public static void main(String[] args) {

        String[] words = {
            "the", "a", "there", "their", "any", "thee"
        };

        // Insert words
        for (String word : words) {
            insert(word);
        }

        // Search tests
        System.out.println(search("the"));    // true
        System.out.println(search("there"));  // true
        System.out.println(search("their"));  // true
        System.out.println(search("any"));    // true
        System.out.println(search("an"));     // false
        System.out.println(search("th"));     // false
    }
}
