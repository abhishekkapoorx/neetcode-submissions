class Solution {
    private int maxTheft(int[] nums, int[] dp, int i) {
        if (i >= nums.length) return 0;

        if (dp[i] != -1) return dp[i];
        return dp[i] = Math.max(nums[i] + maxTheft(nums, dp, i+2), maxTheft(nums, dp, i+1));
    }
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return maxTheft(nums, dp, 0);
    }
}
