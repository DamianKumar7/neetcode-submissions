class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        Boolean[][] memo = new Boolean[m + 1][n + 1];
        return solve(s, p, m, n, memo);
    }

    public boolean solve(String s, String p, int i, int j, Boolean[][] memo) {
        if (i == 0 && j == 0) return true;
        if (j == 0 && i != 0) return false;
        if (i == 0 && j != 0) {
            for (int k = 0; k < j; k++) {
                if (p.charAt(k) != '*') return false;
            }
            return true;
        }

        if (memo[i][j] != null) return memo[i][j];

        boolean result;
        if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
            result = solve(s, p, i - 1, j - 1, memo);
        } else if (p.charAt(j - 1) == '*') {
            result = solve(s, p, i, j - 1, memo) || solve(s, p, i - 1, j, memo);
        } else {
            result = false;
        }

        memo[i][j] = result;
        return result;
    }
}