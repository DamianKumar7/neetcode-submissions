class Solution {
    public int numIslands(char[][] grid) {
        int[] x = new int[] {0, 1, -1, 0};
        int[] y = new int[] {1, 0, 0, -1};
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        int ans = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' &&  visited[i][j] == 0) {
                    visited[i][j] = 1;
                    queue.add(new int[] {i, j});
                    while (!queue.isEmpty()) {
                        int[] xy = queue.poll();
                        for (int z = 0; z < 4; z++) {
                            if (xy[0] + x[z]>=0 && xy[0] + x[z] <m && xy[1] + y[z]>=0  && xy[1] + y[z]<n && grid[xy[0] + x[z]][xy[1] + y[z]] == '1' && visited[xy[0] + x[z]][xy[1] + y[z]] == 0) {
                                visited[xy[0] + x[z]][xy[1] + y[z]] = 1;
                                queue.add(new int[]{xy[0] + x[z],xy[1] + y[z]});
                            }
                        }
                    }
                    ans++;
                }
            }
        }
        return ans;
    }
}
