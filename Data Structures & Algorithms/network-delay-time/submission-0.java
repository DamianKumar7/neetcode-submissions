class Solution {
    public int networkDelayTime(int[][] edges, int n, int k) {
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adjList.get(u).add(new int[] {v, w});
        }

        int[] dist = new int[n + 1];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[k] = 0;
        queue.add(new int[] {0, k});
        while (!queue.isEmpty()) {
            int[] ele = queue.poll();
            int node = ele[1];
            int distance = ele[0];

            List<int[]> connections = adjList.get(node);
            for (int[] edge : connections) {
                int target = edge[0];
                int weight = edge[1];

                int newDistance = distance + weight;

                if (newDistance < dist[target]) {
                    dist[target] = newDistance;
                    queue.add(new int[] {newDistance, target});
                }
            }
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            answer = Math.max(answer, dist[i]);
        }

        return answer;
    }
}
