class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[]x = new int[]{0,1,0,-1};
        int[]y = new int[]{1,0,-1,0};
        int[][]visited = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int maxArea  = Integer.MIN_VALUE;
        for(int i =0; i < m; i++){
            for(int j = 0; j <n; j++){
                if(grid[i][j] == 1 && visited[i][j] == 0){
                    queue.add(new int[]{i,j});
                    visited[i][j] = 1;
                    int area = 1;
                    while(!queue.isEmpty()){
                        int[]coord = queue.poll(); 
                        for(int z =0; z<4; z++ ){
                            int nx = coord[0]+x[z];
                            int ny = coord[1]+y[z];
                            if(nx>=0 && nx<m && ny>=0 && ny<n && visited[nx][ny] == 0 && grid[nx][ny] == 1){
                                area++;
                                queue.add(new int[]{nx,ny});
                                visited[nx][ny] = 1;
                            }
                        }
                    }
                    if(area> maxArea){
                        maxArea = area;
                    }
                }
            }
        }

        return Math.max(maxArea,0);
        
    }
}
