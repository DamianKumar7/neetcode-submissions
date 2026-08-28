class Solution {
    public int findCheapestPrice(
            int n,
            int[][] flights,
            int src,
            int dst,
            int k) {

        Map<Integer, List<int[]>> adjList = new HashMap<>();

        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            adjList
                .computeIfAbsent(from, x -> new ArrayList<>())
                .add(new int[]{to, price});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0});

        int stops = 0;

        while (!queue.isEmpty() && stops <= k) {

            int size = queue.size();

            int[] nextDist = dist.clone();

            for (int i = 0; i < size; i++) {

                int[] current = queue.poll();

                int node = current[0];
                int cost = current[1];

                for (int[] flight :
                        adjList.getOrDefault(node, new ArrayList<>())) {

                    int nextNode = flight[0];
                    int price = flight[1];

                    int newCost = cost + price;

                    if (newCost < nextDist[nextNode]) {

                        nextDist[nextNode] = newCost;

                        queue.offer(
                            new int[]{nextNode, newCost}
                        );
                    }
                }
            }

            dist = nextDist;
            stops++;
        }

        return dist[dst] == Integer.MAX_VALUE
                ? -1
                : dist[dst];
    }
}