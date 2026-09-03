class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[]dp = new int[n];
        for(int i =0; i <n; i++){
            dp[i] = 1;
        }
        for(int j = n -1; j>=0; j--){
            for(int i =j+1; i<n; i++){
                if(nums[j]<nums[i]){
                    dp[j] = Math.max(dp[j], 1+dp[i]);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i =0; i <n; i++){
            if(dp[i]>max)max = dp[i];
        }

        return max;
    }
}
