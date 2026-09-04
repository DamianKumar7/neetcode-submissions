class Solution {
    public int maxCoins(int[] nums) {
        int[] arr = new int[nums.length + 2];
        arr[0] = 1;
        arr[nums.length + 1] = 1;
        int[][] dp = new int[arr.length][arr.length];
        for(int i= 1; i<arr.length-1; i++){
            arr[i] = nums[i-1];
        }

        return solve(1, arr.length - 2, arr, dp);
    }

    public int solve(int i, int j, int[] arr, int[][] dp) {
        if (i > j)
            return 0;

        if (dp[i][j] != 0)
            return dp[i][j];
        int max = 0;
        for (int idx = i; idx <= j; idx++) {
            max = Math.max(max,
                arr[i - 1] * arr[idx] * arr[j + 1] + solve(i, idx - 1, arr, dp)
                    + solve(idx + 1, j, arr, dp));
        }
        dp[i][j] = max;
        return dp[i][j];
    }
}
