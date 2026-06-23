class Solution {
    private int findLen(int[] nums, int i, int parent, int[] dp) {
        if (i == nums.length) return 0;

        if (dp[i] != -1) return dp[i];
        System.out.printf("i: %d, parent: %d\n", i, parent);
        int max = 0;
        for (int j = i; j < nums.length; j++) {
            if (parent == -9999 || nums[j] > parent){
                dp[j] = Math.max(max, 1 + findLen(nums, j+1, nums[j], dp));
                max = dp[j];
            }
        }
        System.out.printf("i: %d, parent: %d, max: %d\n", i, parent, max);
        return dp[i] = max;
    }
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);

        return findLen(nums, 0, -9999, dp);
    }
}
