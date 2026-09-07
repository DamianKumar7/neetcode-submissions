class Solution {
    public int numDecodings(String s) {
        int[]memo = new int[s.length()];
        Arrays.fill(memo,-1);
        return solve(s,s.length(), memo);
    }
    public int solve(String s, int n, int[]memo){
        if(n == 0)return 1;
        if(n == 1)return (s.charAt(n-1) == '0')?0:1;
        if(memo[n-1]!= -1)return memo[n-1];
        int ways = 0;
        if(s.charAt(n-1) != '0'){
            ways+= solve(s,n-1,memo);
        }
        int twoDigit = Integer.parseInt(s.substring(n-2,n));
        if(twoDigit>=10 && twoDigit<=26)ways+=solve(s,n-2,memo);
        memo[n-1] = ways;
        return memo[n-1];
    }
}
