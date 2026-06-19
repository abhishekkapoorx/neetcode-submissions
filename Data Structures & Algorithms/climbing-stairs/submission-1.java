class Solution {
    private int findWays(int n, int[] dp) {
        if (n <= 2) return dp[n] = n;

        if (dp[n] != -1) return dp[n];
        dp[n] = findWays(n-1, dp) + findWays(n-2, dp);
        return dp[n];
    }
    public int climbStairs(int n) {
        if (n == 0 || n == 1) return n;

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return findWays(n, dp);
    }
}
