class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        // Interval DP: fill dp[i][j] bottom-up
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }

        List<List<String>> ans = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), ans, dp);
        return ans;
    }

    private void backtrack(String s, int start, List<String> current, List<List<String>> ans, boolean[][] dp) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(current));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (dp[start][end]) { // O(1) lookup instead of re-scanning the substring
                current.add(s.substring(start, end + 1));
                backtrack(s, end + 1, current, ans, dp);
                current.remove(current.size() - 1);
            }
        }
    }
}