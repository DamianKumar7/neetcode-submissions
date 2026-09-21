class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        List<List<Integer>> ans = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;

        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();
        boolean[][] visitedPacific = new boolean[m][n];
        boolean[][] visitedAtlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    pacificQueue.add(new int[]{i, j});
                    visitedPacific[i][j] = true;
                }
                if (i == m - 1 || j == n - 1) { // separate `if`, not `else if`
                    atlanticQueue.add(new int[]{i, j});
                    visitedAtlantic[i][j] = true;
                }
            }
        }

        bfs(pacificQueue, visitedPacific, heights, dx, dy, m, n);
        bfs(atlanticQueue, visitedAtlantic, heights, dx, dy, m, n);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visitedPacific[i][j] && visitedAtlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    private void bfs(Queue<int[]> queue, boolean[][] visited, int[][] heights, int[] dx, int[] dy, int m, int n) {
        while (!queue.isEmpty()) {
            int[] ele = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = ele[0] + dx[d];
                int ny = ele[1] + dy[d];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n
                        && !visited[nx][ny]
                        && heights[nx][ny] >= heights[ele[0]][ele[1]]) { // reversed comparison, correctly
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}