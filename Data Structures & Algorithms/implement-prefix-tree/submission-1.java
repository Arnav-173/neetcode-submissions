class PrefixTree {

    class TrieNode {
        public boolean isWord = false;
        public Map<Character, TrieNode> charMap = new HashMap<>();
    }

    public TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            TrieNode next = node.charMap.get(c);
            if (next == null) {
                node.charMap.put(c, new TrieNode());
                node = node.charMap.get(c);
            } else {
                node = next;
            }
            if (i == word.length() - 1) {
                node.isWord = true;
            }
        }
    }

    public boolean search(String word) {
        TrieNode node = root;
        boolean wordExists = false;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            TrieNode next = node.charMap.get(c);
            if (next == null) {
                return false;
            }
            node = next;
            if (i == word.length() - 1 && node.isWord) {
                wordExists = true;
            }
        }
        return wordExists;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        boolean startsWith = false;
        for (int i = 0; i < prefix.length(); i++) {
            Character c = prefix.charAt(i);
            TrieNode next = node.charMap.get(c);
            if (next == null) {
                return false;
            }
            node = next;
            if (i == prefix.length() - 1) {
                startsWith = true;
            }
        }
        return startsWith;
    }
}
