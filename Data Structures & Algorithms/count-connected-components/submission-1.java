class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] visited = new int[n];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] i : edges) {
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                count++;
                queue.add(i);
                visited[i] = 1;
                while (!queue.isEmpty()) {
                    int Node = queue.poll();
                    for (int key : adj.get(Node)) {
                        if (visited[key] == 0) {
                            visited[key] = 1;
                            queue.add(key);
                        }
                    }
                }
            }
        }
        return count;
    }
}
