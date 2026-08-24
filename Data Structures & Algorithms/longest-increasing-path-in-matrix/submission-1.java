class Solution {

    public int longestIncreasingPath(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, solve(i, j, matrix, dp));
            }
        }

        return ans;
    }

    public int solve(int i, int j, int[][] matrix, int[][] dp) {

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int res = 1;

        for (int d = 0; d < 4; d++) {

            int nx = i + dx[d];
            int ny = j + dy[d];

            if (nx >= 0 && nx < matrix.length &&
                ny >= 0 && ny < matrix[0].length &&
                matrix[nx][ny] < matrix[i][j]) {

                res = Math.max(
                    res,
                    1 + solve(nx, ny, matrix, dp)
                );
            }
        }

        dp[i][j] = res;

        return res;
    }
}