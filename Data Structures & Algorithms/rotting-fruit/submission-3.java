class Solution {
    public int orangesRotting(int[][] grid) {
        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {1, 0, -1, 0};
        int minutes = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] {i, j});
                    visited[i][j] = 1;
                }
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotAny = false;
            for (int i = 0; i < size; i++) {
                int[] ele = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int x = dx[d];
                    int y = dy[d];
                    int nx = ele[0] + x;
                    int ny = ele[1] + y;

                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && visited[nx][ny] == 0
                        && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        visited[nx][ny] = 1;
                        rotAny = true;
                        queue.add(new int[] {nx, ny});
                    }
                }
            }
            if(rotAny == true){
                minutes++;
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return minutes;
    }
}
