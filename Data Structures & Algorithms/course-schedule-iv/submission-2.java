class Solution {
    public List<Boolean> checkIfPrerequisite(
        int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int a = prerequisite[0];
            int b = prerequisite[1];

            adj.get(a).add(b);
        }

        List<Boolean> ans = new ArrayList<>();

        for (int[] query : queries) {
            int src = query[0];
            int dst = query[1];

            int[] visited = new int[numCourses];
            Queue<Integer> queue = new LinkedList<>();

            queue.add(src);
            boolean found = false;

            while (!queue.isEmpty() && !found) {
                int node = queue.poll();
                List<Integer> neighbours = adj.get(node);
                for (int neighbour : neighbours) {
                    if (visited[neighbour] == 1)
                        continue;
                    if (neighbour == dst) {
                        ans.add(true);
                        found = true;
                        break;
                    } else {
                        queue.add(neighbour);
                        visited[neighbour] = 1;
                    }
                }
            }
            if (!found)
                ans.add(false);
        }

        return ans;
    }
}