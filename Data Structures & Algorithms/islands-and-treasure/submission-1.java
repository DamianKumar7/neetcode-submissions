class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[]dx = new int[]{0,1,0,-1};
        int[]dy = new int[]{1,0,-1,0};
        int[][]visited = new int[m][n];
        Queue<int[]>queue = new LinkedList<>();
        for(int i =0; i < m;i++){
            for(int j = 0; j<n;j++){
                if(grid[i][j] == 0){
                    visited[i][j] =1;
                    queue.add(new int[]{i,j});
                }
            }
        }

        while(!queue.isEmpty()){
            int[]ele = queue.poll();
            for( int i =0; i< 4;i++){
                int x = dx[i];
                int y = dy[i];
                int nx = x+ele[0];
                int ny = y+ele[1];
                if(nx>=0 && nx <m && ny>=0 && ny <n && visited[nx][ny] == 0 && grid[nx][ny] == Integer.MAX_VALUE){
                    queue.add(new int[]{nx,ny});
                    grid[nx][ny]= grid[ele[0]][ele[1]]+1;
                    visited[nx][ny] =1;
                }

            }
        }
    }
}
