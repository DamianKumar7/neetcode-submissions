class Solution {

    public int coinChange(int[] coins, int amount) {
        int result = solve(coins, coins.length - 1, amount);

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    int solve(int[] coins, int idx, int amount) {

        if (idx == 0) {
            if (amount % coins[0] == 0) {
                return amount / coins[0];
            }

            return Integer.MAX_VALUE;
        }

        int notTake = solve(coins, idx - 1, amount);

        int take = Integer.MAX_VALUE;

        if (amount >= coins[idx]) {
            int result = solve(coins, idx, amount - coins[idx]);

            if (result != Integer.MAX_VALUE) {
                take = 1 + result;
            }
        }

        return Math.min(take, notTake);
    }
}