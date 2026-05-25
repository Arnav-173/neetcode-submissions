class LRUCache {

    public class Node {
        public int key;
        public int value;
        public Node next = null;
        public Node prev = null;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int maxCapacity;
    Node head;
    Node tail;

    Map<Integer, Node> cache;

    public LRUCache(int capacity) {
        cache = new HashMap<>(capacity);
        maxCapacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node n = cache.get(key);
        if (n == null) {
            return -1;
        }
        adjustCache(n);
        return n.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node n = cache.get(key);
            n.value = value;
            adjustCache(n);
            return;
        }
        if (cache.size() < maxCapacity) {
            cache.put(key, addNode(key, value));
        } else {
            evictCache();
            cache.put(key, addNode(key, value));
        }
    }

    public Node addNode(int key, int value) {
        Node n = new Node(key, value);
        Node toMove = head.next;
        head.next = n;
        n.prev = head;
        n.next = toMove;
        toMove.prev = n;
        return n;
    }

    public void evictCache() {
        Node toRemove = tail.prev;
        tail.prev = toRemove.prev;
        toRemove.prev.next = tail;
        cache.remove(toRemove.key);
    }

    public void adjustCache(Node n) {
        Node toMove = head.next;
        if (toMove == n) {
            return;
        }
        n.prev.next = n.next;
        n.next.prev = n.prev;
        n.next = toMove;
        toMove.prev = n;
        head.next = n;
        n.prev = head;
    }
}
