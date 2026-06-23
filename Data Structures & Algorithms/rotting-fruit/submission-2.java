class Solution {
    public int orangesRotting(int[][] grid) {
        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {1, 0, -1, 0};
        int minutes = 0;
        int[][] visited = new int[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2 && visited[i][j] == 0) {
                    queue.add(new int[] {i, j});
                    visited[i][j] = 1;
                }
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotAny = false;
            for (int s = 0; s < size; s++) {
                int[] ele = queue.poll();
                int x = ele[0];
                int y = ele[1];
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length
                        && grid[nx][ny] == 1 && visited[nx][ny] == 0) {
                        visited[nx][ny] = 1;
                        grid[nx][ny] = 2;
                        rotAny = true;
                        queue.add(new int[] {nx, ny});
                    }
                }
            }

            if (rotAny)
                minutes++;
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
