class Solution {

    private int solve(int[] coins, int i, int amount, int[][] dp) {

        if (amount == 0) return 0;

        if (amount < 0 || i == coins.length)
            return (int)1e8;

        if (dp[i][amount] != -1)
            return dp[i][amount];

        int take = 1 + solve(coins, i, amount - coins[i], dp);
        int notTake = solve(coins, i + 1, amount, dp);

        return dp[i][amount] = Math.min(take, notTake);
    }

    public int coinChange(int[] coins, int amount) {

        int[][] dp = new int[coins.length][amount + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        int ans = solve(coins, 0, amount, dp);

        return ans >= 1e8 ? -1 : ans;
    }
}