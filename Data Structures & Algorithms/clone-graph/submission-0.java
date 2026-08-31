class Solution {

    Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }

        // Already cloned
        if (map.containsKey(node)) {
            return map.get(node);
        }

        // Create clone
        Node clone = new Node(node.val);
        map.put(node, clone);

        // Clone all neighbours
        for (Node neighbour : node.neighbors) {

            Node clonedNeighbour = cloneGraph(neighbour);

            clone.neighbors.add(clonedNeighbour);
        }

        return clone;
    }
}