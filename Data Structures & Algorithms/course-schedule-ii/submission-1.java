class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        int[] indegree = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] i : prerequisites) {
            adj.get(i[1]).add(i[0]);
        }
        for (List<Integer> neighbours : adj) {
            for (int neighbour : neighbours) {
                indegree[neighbour]++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            ans.add(node);
            List<Integer> neighbours = adj.get(node);
            for (int neighbour : neighbours) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0)
                    queue.add(neighbour);
            }
        }

        if (ans.size() == n)
            return ans.stream().mapToInt(Integer::intValue).toArray();

        return new int[] {};
    }
}
