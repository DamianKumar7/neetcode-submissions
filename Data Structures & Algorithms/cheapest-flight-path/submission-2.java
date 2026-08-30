class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[]dist = new int[n];
        List<List<int[]>> adj = new ArrayList<>();
        for(int i =0; i <n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int i =0; i <n; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        for(int[]flight: flights){
            int from = flight[0];
            int to = flight[1];
            int cost = flight[2];

            adj.get(from).add(new int[]{to,cost});
        }

        dist[src] = 0;
        Queue<int[]>queue = new LinkedList<>();
        queue.add(new int[]{0,0,src});
        while(!queue.isEmpty()){
            int[]flight = queue.poll();
            int stops = flight[0];
            int cost = flight[1];
            int node = flight[2];
            List<int[]> neighbours = adj.get(node);
            for(int[] neighbour: neighbours){
                int neighbourNode = neighbour[0];
                int neighbourCost = neighbour[1];
                int newCost = cost+neighbourCost;
                int totalStops = stops+1;
                if(totalStops > k+1)continue;
                if(dist[neighbourNode]> newCost){
                    queue.add(new int[]{totalStops,newCost,neighbourNode});
                    dist[neighbourNode] = newCost;
                }
            }
        }

        if(dist[dst] == Integer.MAX_VALUE)return -1;
        return dist[dst];
    }
}
