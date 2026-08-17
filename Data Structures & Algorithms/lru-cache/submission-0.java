class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    int size;

    Map<Integer, Node> map;

    Node head; // most recently used
    Node tail; // least recently used

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        remove(node);
        addToHead(node);

        return node.value;
    }

    public void put(int key, int value) {

        // Key already exists
        if (map.containsKey(key)) {

            Node node = map.get(key);

            node.value = value;

            remove(node);
            addToHead(node);

            return;
        }

        // New node
        Node node = new Node(key, value);

        map.put(key, node);
        addToHead(node);
        size++;

        // Capacity exceeded
        if (size > capacity) {

            Node removed = tail;

            remove(removed);
            map.remove(removed.key);

            size--;
        }
    }

    private void addToHead(Node node) {

        node.prev = null;
        node.next = head;

        if (head != null) {
            head.prev = node;
        }

        head = node;

        // First element
        if (tail == null) {
            tail = node;
        }
    }

    private void remove(Node node) {

        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            // node is head
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            // node is tail
            tail = node.prev;
        }
    }
}