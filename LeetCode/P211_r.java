import java.util.HashMap;
import java.util.Map;

public class P211_r {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean word = false;

        public TrieNode() {
        }
    }

    TrieNode trie;

    /** Initialize your data structure here. */
    public P211_r() {
        trie = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = trie;
        for (char ch : word.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new TrieNode());
            }
            node = node.children.get(ch);
        }
        node.word = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot
     * character '.' to represent any one letter.
     */
    public boolean searchInNode(String word, TrieNode node) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.children.containsKey(ch)) {
                if (ch == '.') {
                    for (char x : node.children.keySet()) {
                        TrieNode child = node.children.get(x);
                        if (searchInNode(word.substring(i + 1), child))
                            return true;
                    }
                }
                return false;
            } else {
                node = node.children.get(ch);
            }
        }
        return node.word;
    }

    public boolean search(String word) {
        return searchInNode(word, trie);
    }
}
