class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adjList = new HashMap<>();
        int n = tickets.size();
        List<String> result = new ArrayList<>();

        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            adjList.computeIfAbsent(from, k -> new PriorityQueue<>()).offer(to);
        }

        dfs("JFK", result, adjList);
        return result;
    }

    public void dfs(
        String startingNode, List<String> result, Map<String, PriorityQueue<String>> adjList) {
        PriorityQueue<String> neighbours =
            adjList.getOrDefault(startingNode, new PriorityQueue<>());
        while (neighbours.size() > 0) {
            String toCity = neighbours.poll();
            dfs(toCity, result, adjList);
        }
        result.addFirst(startingNode);
    }
}
