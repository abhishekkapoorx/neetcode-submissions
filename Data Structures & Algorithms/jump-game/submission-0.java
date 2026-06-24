class Solution {
    private boolean canReach(int[] nums, int i, int[] dp) {
        if (i == nums.length - 1) return true;
        else if (i >= nums.length) return false;

        if (dp[i] != -1) return dp[i] == 1;
        for (int j = 1; j <= nums[i]; j++) {
            boolean reached = canReach(nums, i+j, dp);
            if (reached) {
                dp[i] = 1;
                return true;
            }
        }
        dp[i] = 0;
        return false;
    }
    public boolean canJump(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);

        return canReach(nums, 0, dp);

    }
}
