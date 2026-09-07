class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[]dp = new boolean[s.length()+1];
        int n = s.length();
        dp[n] = true;
        for(int i =n-1; i >=0; i--){
            for(String w: wordDict){
                if(i+w.length()<=n && s.substring(i,i+w.length()).equals(w)){
                    dp[i] = dp[i+w.length()];
                }
                if(dp[i] == true)break;
            }
        }
        return dp[0];
    }
}
