/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        Map<Integer, Node> nodeMap = new HashMap<>();
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        Queue<Node> bfsQueue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        bfsQueue.add(node);
        visited.add(node);
        while (!bfsQueue.isEmpty()) {
            Node n = bfsQueue.remove();
            Node x = new Node(n.val);
            nodeMap.put(x.val, x);
            adjMap.put(x.val, new ArrayList<>());
            for (Node m: n.neighbors) {
                if (!visited.contains(m)) {
                    visited.add(m);
                    bfsQueue.add(m);
                }
                adjMap.get(x.val).add(m.val);
            }
        }
        for (Map.Entry<Integer, List<Integer>> entry: adjMap.entrySet()) {
            List<Integer> neighbours = entry.getValue();
            for (Integer n : neighbours) {
                nodeMap.get(entry.getKey()).neighbors.add(nodeMap.get(n));
            }
        }
        return nodeMap.get(1);
    }
}