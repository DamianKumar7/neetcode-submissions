class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false; 
        return solve(s1, s2, s3, s1.length(), s2.length(), s3.length());
    }

    public boolean solve(String s1, String s2, String s3, int m, int n, int z) {
        if (m == 0 && n == 0 && z == 0) return true;
        if (z == 0) return false; 
        if (m == 0) return s2.substring(0, n).equals(s3.substring(0, z)); 
        if (n == 0) return s1.substring(0, m).equals(s3.substring(0, z)); 

        if (s1.charAt(m - 1) == s3.charAt(z - 1) && s2.charAt(n - 1) == s3.charAt(z - 1)) {
            return solve(s1, s2, s3, m - 1, n, z - 1) || solve(s1, s2, s3, m, n - 1, z - 1);
        } else if (s2.charAt(n - 1) == s3.charAt(z - 1)) {
            return solve(s1, s2, s3, m, n - 1, z - 1);
        } else if (s1.charAt(m - 1) == s3.charAt(z - 1)) {
            return solve(s1, s2, s3, m - 1, n, z - 1);
        } else {
            return false;
        }
    }
}