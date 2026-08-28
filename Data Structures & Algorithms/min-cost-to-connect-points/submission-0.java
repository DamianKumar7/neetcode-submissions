class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<List<int[]>> adjList = new ArrayList<>();
        List<int[]> mst = new ArrayList<>();
        int sum = 0;

        int n = points.length;

        // Create list for every point
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Every point can connect to every other point
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int distance =
                    Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);

                adjList.get(i).add(new int[] {j, distance});
                adjList.get(j).add(new int[] {i, distance});
            }
        }

        // Your Prim's/Kruskal's logic here
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)-> a[0]-b[0]); // array will have weight, node, parent
        int[] visited = new int[adjList.size()];
        queue.add(new int[] {0, 0, -1});

        while (!queue.isEmpty()) {
            int[] ele = queue.poll();
            
            if(visited[ele[1]] == 1){
                continue;
            }

            if (ele[2] != -1) {
                mst.add(new int[] {ele[1], ele[2]});
                sum+= ele[0];
            }
            visited[ele[1]] = 1;
            List<int[]> neighbours = adjList.get(ele[1]);
            for (int[] neighbour : neighbours) {
                if (visited[neighbour[0]] == 0) {
                    queue.add(new int[] {neighbour[1], neighbour[0], ele[1]});
                }
            }
        }

        return sum;
    }
}
