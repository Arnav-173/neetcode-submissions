class Solution {
    class Node {
        public String word;
        public List<Node> adjList = new ArrayList<>();
        public int distFromBegin = Integer.MAX_VALUE;

        @Override
        public int hashCode() {
            return Objects.hashCode(this.word);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node n = (Node) o;
            return this.word == n.word;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Map<String, Node> nodeMap = new HashMap<>();
        Node startNode = new Node();
        startNode.word = beginWord;
        startNode.distFromBegin = 1;
        nodeMap.put(beginWord, startNode);
        for (String word: wordList) {
            if (word.equals(beginWord)) continue;
            Node n = new Node();
            n.word = word;
            nodeMap.put(word, n);
        }
        for (Map.Entry<String, Node> entry: nodeMap.entrySet()) {
            Node n = entry.getValue();
            for (String word : wordList) {
                if (isValidConversion(n.word, word)) {
                    n.adjList.add(nodeMap.get(word));
                }
            }
        }
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(startNode);
        Set<Node> visited = new HashSet<>();
        while (!nodeQueue.isEmpty()) {
            Node n = nodeQueue.poll();
            if (visited.contains(n)) continue;
            visited.add(n);
            for (Node x : n.adjList) {
                if (!visited.contains(x)) {
                    if (x.distFromBegin > n.distFromBegin + 1) {
                        x.distFromBegin = n.distFromBegin + 1;
                    }
                    nodeQueue.add(x);
                }
            }
        }
        return nodeMap.get(endWord).distFromBegin == Integer.MAX_VALUE ? 0 : nodeMap.get(endWord).distFromBegin;
    }

    private boolean isValidConversion(String previousWord, String word) {
        int misMatchCount = 0;
        if (previousWord.length() != word.length()) {
            return false;
        }
        for (int i = 0; i < word.length(); i++) {
            if (previousWord.charAt(i) != word.charAt(i)) {
                misMatchCount++;
            }
        }
        return misMatchCount == 1;
    }
}
