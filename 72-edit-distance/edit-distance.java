class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if(n > m){
            minDistance(word2, word1);
        }
        int[][]dp = new int[m+1][n+1];
        for(int i =0; i <=m; i++){
            for(int j =0; j <=n; j++){
                if( i==0 && j ==0)dp[i][j] = 0;
                else if(i != 0 && j ==0)dp[i][j] = i;
                else if(i == 0 && j != 0)dp[i][j] = j;
            }
        }

        for(int i =1; i <=m; i++){
            for(int j =1; j<=n; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 1+ Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]));
                }
            }
        }

        return dp[m][n];
    }


    public int solve(String s1, String s2, int m, int n){
        if(m == 0 && n != 0)return n;
        if(m != 0 && n == 0)return m;
        if(m ==0 && n == 0)return 0;
        if(s1.charAt(m-1)  == s2.charAt(n-1))return solve(s1, s2, m-1, n-1);
        else{
            return Math.min(1+solve(s1, s2, m-1, n), Math.min(1+solve(s1, s2, m, n-1), 1+solve(s1, s2, m-1, n-1)));
        }
    }
}