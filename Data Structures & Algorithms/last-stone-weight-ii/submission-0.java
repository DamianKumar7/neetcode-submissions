class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum =0;
        int n = stones.length;
        for(int stone: stones){
            sum += stone;
        }

        int total =sum;
        sum = sum/2;

        
        int[][]dp = new int[n+1][sum+1];
        for(int i =0; i <=n; i++){
            for(int j =0; j<=sum; j++){
                if(i ==0 && j ==0)dp[i][j]=0;
                if(i == 0 && j!= 0)dp[i][j] = 0;
                if(j == 0 && i!= 0)dp[i][j] = 0;
            }
        }

        for(int i =1; i<=n; i++){
            for(int j =1; j<=sum; j++){
                if(j>=stones[i-1]){
                    dp[i][j] = Math.max(dp[i-1][j], stones[i-1]+dp[i-1][j-stones[i-1]]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return total - 2*dp[n][sum];
    }
}