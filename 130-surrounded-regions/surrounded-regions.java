class Solution {
    public void solve(char[][] board) {
        int[][]visited = new int[board.length][board[0].length];
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = new int[]{0,1,0,-1};
        int[] dy = new int[]{1,0,-1,0};
        for(int i =0; i <board.length;i++){
            for(int j =0; j<board[0].length;j++){
                if(i == 0 || i== board.length-1 || j==0 || j==board[0].length-1 ){
                    if(visited[i][j] != 1 && board[i][j] == 'O'){
                        visited[i][j] = 1;
                        queue.add(new int[]{i,j});
                    }
                }
            }
        }

        while(!queue.isEmpty()){
            int[]ele = queue.poll();
            int x = ele[0];
            int y = ele[1];
            for(int d =0; d<4;d++){
                int nx = x+dx[d];
                int ny = y+dy[d];
                if(nx>=0 && nx <board.length && ny>=0 && ny <board[0].length && visited[nx][ny] == 0 && board[nx][ny] == 'O'){
                    visited[nx][ny] = 1;
                    queue.add(new int[]{nx,ny});
                }
            }
        }

        for(int i =0; i<board.length; i++){
            for(int j = 0; j<board[0].length;j++){
                if(visited[i][j] != 1){
                    board[i][j] ='X';
                }
            }
        }
        
    }
}
