class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        // Pacific: top row + left column
        for (int i = 0; i < m; i++) {
            pacific[i][0] = true;
            pacificQueue.offer(new int[]{i, 0});
        }

        for (int j = 0; j < n; j++) {
            pacific[0][j] = true;
            pacificQueue.offer(new int[]{0, j});
        }

        // Atlantic: bottom row + right column
        for (int i = 0; i < m; i++) {
            atlantic[i][n - 1] = true;
            atlanticQueue.offer(new int[]{i, n - 1});
        }

        for (int j = 0; j < n; j++) {
            atlantic[m - 1][j] = true;
            atlanticQueue.offer(new int[]{m - 1, j});
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        bfs(heights, pacificQueue, pacific, dx, dy);
        bfs(heights, atlanticQueue, atlantic, dx, dy);

        List<List<Integer>> result = new ArrayList<>();

        // Find cells reachable from both oceans
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void bfs(
            int[][] heights,
            Queue<int[]> queue,
            boolean[][] visited,
            int[] dx,
            int[] dy) {

        int m = heights.length;
        int n = heights[0].length;

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int x = current[0];
            int y = current[1];

            for (int d = 0; d < 4; d++) {

                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }


                if (heights[nx][ny] < heights[x][y]) {
                    continue;
                }

                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
            }
        }
    }
}