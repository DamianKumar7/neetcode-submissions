class Solution {
    public int minDistance(String word1, String word2) {

        int[][] dp = new int[word1.length()][word2.length()];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(word1, word2, word1.length() - 1, word2.length() - 1, dp);
    }

    public int solve(String s1, String s2, int i, int j, int[][] dp) {

        if (i < 0) {
            return j + 1;
        }

        if (j < 0) {
            return i + 1;
        }

        // Already calculated
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {

            dp[i][j] = solve(s1, s2, i - 1, j - 1, dp);

        } else {

            dp[i][j] = 1 + Math.min(
                solve(s1, s2, i, j - 1, dp),       // insert
                Math.min(
                    solve(s1, s2, i - 1, j, dp),   // delete
                    solve(s1, s2, i - 1, j - 1, dp) // replace
                )
            );
        }

        return dp[i][j];
    }
}