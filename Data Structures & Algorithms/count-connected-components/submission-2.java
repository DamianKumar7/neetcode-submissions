class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] visited = new int[n];
        int count = 0;

        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] i : edges) {
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }

        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                // start bfs
                count++;
                queue.add(i);
                visited[i] = 1;
                while (!queue.isEmpty()) {
                    int ele = queue.poll();
                    List<Integer> neighbours = adj.get(ele);
                    for (int j : neighbours) {
                        if (visited[j] != 1) {
                            visited[j] = 1;
                            queue.add(j);
                        }
                    }
                }
            }
        }
        return count;
    }
}
