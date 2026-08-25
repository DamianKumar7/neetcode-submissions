class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i =0; i < nums.length; i++){
            sum+= nums[i];
        }        
        if(sum%2!= 0){
            return false;
        }
        sum = sum/2;
        int n = nums.length;
        int[][]dp = new int[n+1][sum+1];

        for(int i =0; i < dp.length ; i++){
            for(int j =0; j < dp[0].length; j++){
                if(i ==0 && j == 0){
                    dp[i][j] = 1;
                }
                else if( i ==0 && j != 0){
                    dp[i][j] = 0;
                }
                else if(i!=0 && j == 0){
                    dp[i][j] = 1;
                }
            }
        }


        for(int i =1; i < dp.length; i++){
            for( int j =1; j < dp[0].length; j++){
                if(nums[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-nums[i-1]]);
                }
            }
        }

        if(dp[n][sum] == 1){
            return true;
        }
        return false;
    }
}
