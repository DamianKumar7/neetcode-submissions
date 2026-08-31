class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int distance =
                    Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);

                adj.get(i).add(new int[] {j, distance});
                adj.get(j).add(new int[] {i, distance});
            }
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[] visited = new int[adj.size()];
        int sum =0;
        queue.add(new int[] {0, 0, -1});
        while (!queue.isEmpty()) {
            int[]ele = queue.poll();
            int weight = ele[0];
            int node = ele[1];
            int parent = ele[2];
            if(visited[node] == 1)continue;
            visited[node] = 1;
            if(parent!= -1){
                sum+= weight;
            }
            List<int[]> neighbours = adj.get(node);
            for(int[]neighbour: neighbours){
                int neighbourNode = neighbour[0];
                int neighbourWeight = neighbour[1];
                if(visited[neighbourNode] == 1)continue;
                queue.add(new int[]{neighbourWeight,neighbourNode,node});
            }
        }

        return sum;
    }
}
