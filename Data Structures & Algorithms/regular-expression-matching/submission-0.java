class Solution {

    public boolean isMatch(String s, String p) {
        return solve(s, p, s.length() - 1, p.length() - 1);
    }

    public boolean solve(String s, String p, int i, int j) {

        if (i < 0 && j < 0) {
            return true;
        }

        if (j < 0) {
            return false;
        }

        if (i < 0) {
            if (p.charAt(j) == '*') {
                return solve(s, p, i, j - 2);
            }
            return false;
        }

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            return solve(s, p, i - 1, j - 1);
        }

        if (p.charAt(j) == '*') {

            boolean notChoose = solve(s, p, i, j - 2);

            boolean choose = false;

            if (p.charAt(j - 1) == s.charAt(i)
                    || p.charAt(j - 1) == '.') {

                choose = solve(s, p, i - 1, j);
            }

            return choose || notChoose;
        }

        return false;
    }
}