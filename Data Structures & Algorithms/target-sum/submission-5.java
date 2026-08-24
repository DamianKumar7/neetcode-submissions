class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int m = nums.length+1;
        int sum = 0;
        for(int i : nums){
            sum+= i;
        }
        if (Math.abs(target) > sum || (sum + target) % 2 != 0) {
            return 0;
        }
        target = (sum+target)/2;
        int n = target+1;

        int[][]dp = new int[m][n];
        dp[0][0] = 1;


        for(int i =1; i < m; i++){
            for(int j = 0; j < n; j++){
                if(nums[i-1] <= j){
                    dp[i][j] = dp[i-1][j]+dp[i-1][j-nums[i-1]];
                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m-1][n-1];

    }
}
