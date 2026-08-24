
class Solution {
    public int maxCoins(int[] nums) {

        int[] arr = new int[nums.length + 2];

        arr[0] = 1;
        arr[arr.length - 1] = 1;

        for (int i = 1; i < arr.length - 1; i++) {
            arr[i] = nums[i - 1];
        }

        int[][] dp = new int[arr.length][arr.length];

        return solve(1, arr.length - 2, arr, dp);
    }

    public int solve(int i, int j, int[] arr, int[][] dp) {

        if (i > j) {
            return 0;
        }

        // Already calculated
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int max = 0;

        for (int idx = i; idx <= j; idx++) {

            int cost =
                arr[i - 1] * arr[idx] * arr[j + 1]
                + solve(i, idx - 1, arr, dp)
                + solve(idx + 1, j, arr, dp);

            max = Math.max(max, cost);
        }

        dp[i][j] = max;

        return max;
    }
}