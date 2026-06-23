class Solution {
    private int dfs(int[] nums, int i, int[] dp) {
        if (dp[i] != -1)
            return dp[i];

        int ans = 1;

        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                ans = Math.max(ans, 1 + dfs(nums, j, dp));
            }
        }

        return dp[i] = ans;
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        int ans = 1;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(nums, i, dp));
        }

        return ans;
    }
}