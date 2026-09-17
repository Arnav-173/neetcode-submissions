class Solution {

    class Node {
        int val;
        String colour;
        Node parent;
        List<Node> adjList = new ArrayList<>();

        public Node(int val, Node parent) {
            this.val = val;
            this.parent = parent;
            this.colour = "White";
        }

        @Override
        public int hashCode() {
            return Objects.hash(val);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || this.getClass() != o.getClass()) return false;
            Node n = (Node) o;
            return (n.val == this.val && n.parent == this.parent);
        }
    }

    public int countComponents(int n, int[][] edges) {
        Map<Integer, Node> nodeMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Node n1 = new Node(i, null);
            nodeMap.put(n1.val, n1);
        }
        for (int i = 0; i < edges.length; i++) {
            Node parent = nodeMap.get(edges[i][0]);
            Node child = nodeMap.get(edges[i][1]);
            child.parent = parent;
            parent.adjList.add(child);
            child.adjList.add(parent);
        }
        int count = 0;
        for (Map.Entry<Integer, Node> entry : nodeMap.entrySet()) {
            if (!entry.getValue().colour.equals("Black")) {
                Set<Node> visited = new HashSet<>();
                dfs(entry.getValue(), visited, null);
                count++;
            }
        }
        return count;
    }

    private void dfs(Node n, Set<Node> visited, Node vistingFrom) {
        if (visited.contains(n)) {
            return;
        }
        n.colour = "Gray";
        visited.add(n);
        for (Node neighbour: n.adjList) {
            if (neighbour == vistingFrom) continue;
            dfs(neighbour, visited, n);
        }
        n.colour = "Black";
        return;
    }
}
