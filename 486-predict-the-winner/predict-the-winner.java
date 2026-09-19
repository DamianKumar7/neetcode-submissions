class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        Integer[][] memo = new Integer[n][n];
        return solve(nums, 0, n - 1, memo) >= 0;
    }

    public int solve(int[] nums, int i, int j, Integer[][] memo) {
        if (i == j) return nums[i];
        if (memo[i][j] != null) return memo[i][j];

        int takeLeft = nums[i] - solve(nums, i + 1, j, memo);
        int takeRight = nums[j] - solve(nums, i, j - 1, memo);
        int result = Math.max(takeLeft, takeRight);

        memo[i][j] = result;
        return result;
    }
}