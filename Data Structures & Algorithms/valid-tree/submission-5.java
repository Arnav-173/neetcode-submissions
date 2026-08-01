class Solution {

    class Node {
        public int val;
        public List<Node> adjList = new ArrayList<>();

        public Node(int val) {
            this.val = val;
        }
        public String colour = "white";

        @Override
        public int hashCode() {
            return Objects.hash(val);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node x = (Node) o;
            return x.val == this.val;
        }
    }

    public boolean validTree(int n, int[][] edges) {
        Map<Integer, Node> nodeMap = new HashMap<>();
        Node startNode = null;
        for (int i = 0; i < edges.length; i++) {
            final int parent = edges[i][0];
            final int child = edges[i][1];
            Node x = nodeMap.get(parent);
            if (x == null) {
                x = new Node(parent);
                nodeMap.put(parent, x);
            }
            Node p = nodeMap.get(child);
            if (p == null) {
                p = new Node(child);
                nodeMap.put(child, p);
            }
            x.adjList.add(p);
            p.adjList.add(x);
            if (i == 0) {
                startNode = x;
            }
        }
        Set<Node> visited = new HashSet<>();
        boolean loopExists = dfs(startNode, null, visited);
        boolean isDisconnected = false;
        for (Map.Entry<Integer, Node> entry : nodeMap.entrySet()) {
            if (!entry.getValue().colour.equals("black")) {
                isDisconnected = true;
                break;
            }
        }
        return !(loopExists || isDisconnected);
    }

    private boolean dfs(Node n, Node prev, Set<Node> visited) {
        if (visited.contains(n)) {
            return true;
        }
        boolean loopExists = false;
        if (n != null) {
            int val = n.val;
            n.colour = "gray";
            visited.add(n);
            for (Node x : n.adjList) {
                if (x == prev) continue;
                loopExists = dfs(x, n, visited);
                if (loopExists) break;
            }
            n.colour = "black";
        }
        return loopExists;
    }
}
