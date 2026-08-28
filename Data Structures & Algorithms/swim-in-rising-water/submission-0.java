class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int l = 0;
        int r = n * n;
        int res = Integer.MAX_VALUE;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (bfs(mid, 0, 0, grid)) {
                res = Math.min(res, mid);
                r = mid - 1;
            }

            else {
                l = mid + 1;
            }
        }
        return res;
    }

    public boolean bfs(int mid, int i, int j, int[][] grid) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        if (grid[i][j] > mid) {
            return false;
        }

        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[grid.length][grid.length];

        queue.add(new int[] {i, j});
        visited[i][j] = 1;
        while (!queue.isEmpty()) {
            int[] ele = queue.poll();
            if (ele[0] == grid.length - 1 && ele[1] == grid.length - 1) {
                return true;
            }
            for (int d = 0; d < 4; d++) {
                int nx = ele[0] + dx[d];
                int ny = ele[1] + dy[d];
                if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid.length
                    && visited[nx][ny] != 1 && grid[nx][ny] <= mid) {
                    queue.add(new int[] {nx, ny});
                    visited[nx][ny] = 1;
                }
            }
        }
        return false;
    }
}
