class Solution {
    public void solve(char[][] board) {
        Queue<int[]>queue = new LinkedList<>();
        int m = board.length;
        int n = board[0].length;
        int[][]visited = new int[m][n];

        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0}; 

        for(int i =0; i <m; i++){
            for(int j =0; j<n ; j++){
                if(board[i][j] == 'O' && (i == m-1 || j == n-1 || i ==0 || j == 0) && visited[i][j] == 0){
                    queue.add(new int[]{i,j});
                    visited[i][j] = 1;
                }
            }
        }

        while(!queue.isEmpty()){
            int[]ele= queue.poll();
            for(int i =0; i <4; i++){
                int nx = ele[0]+dx[i];
                int ny = ele[1]+dy[i];

                if(nx>=0 && nx <m && ny>=0 && ny <n && board[nx][ny] == 'O' && visited[nx][ny] == 0){
                    queue.add(new int[]{nx,ny});
                    visited[nx][ny] = 1;
                }
            }

        }

        for(int i =0; i < m; i++){
            for(int j = 0; j<n; j++){
                if(board[i][j] == 'O' && visited[i][j] == 0){
                    board[i][j] = 'X';
                }
            }
        }
        
    }
}
