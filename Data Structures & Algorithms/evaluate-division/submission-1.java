class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();

        // Step 1: Build weighted graph
        Map<String, Map<String, Double>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];

            adj.putIfAbsent(a, new HashMap<>());
            adj.putIfAbsent(b, new HashMap<>());

            adj.get(a).put(b, val);
            adj.get(b).put(a, 1.0 / val);
        }

        // Step 2: Answer each query with BFS
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dst = queries.get(i).get(1);
            results[i] = bfs(adj, src, dst);
        }

        return results;
    }

    private double bfs(Map<String, Map<String, Double>> adj, String src, String dst) {
        // variable not in graph at all
        if (!adj.containsKey(src) || !adj.containsKey(dst)) return -1.0;
        // same variable: a/a = 1.0
        if (src.equals(dst)) return 1.0;

        // queue holds [currentNode, cumulativeProduct]
        Queue<Object[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(new Object[]{src, 1.0});
        visited.add(src);

        while (!queue.isEmpty()) {
            Object[] curr = queue.poll();
            String node = (String) curr[0];
            double product = (double) curr[1];

            for (Map.Entry<String, Double> entry : adj.get(node).entrySet()) {
                String neighbour = entry.getKey();
                double weight = entry.getValue();

                if (neighbour.equals(dst)) return product * weight; // found it

                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(new Object[]{neighbour, product * weight});
                }
            }
        }

        return -1.0; // no path found between src and dst
    }
}