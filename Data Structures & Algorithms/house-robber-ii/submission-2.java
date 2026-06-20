class Solution {
    private int makeProfit(int[] nums, int i, int[] dp) {
        if (i >= nums.length) return 0;

        if (dp[i] != -1) return dp[i];

        return dp[i] = Math.max(nums[i] + makeProfit(nums, i+2, dp), makeProfit(nums, i+1, dp));

    }
    public int rob(int[] nums) {
        if (nums.length <= 1) return 0;
        int[] nums1 = new int[nums.length-1];
        int[] nums2 = new int[nums.length-1];
        for (int i = 0; i < nums.length-1; i++) {
            nums1[i] = nums[i];
            nums2[i] = nums[i+1];
        }
        int[] dp1 = new int[nums1.length];
        int[] dp2 = new int[nums2.length];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        return Math.max(makeProfit(nums1, 0, dp1), makeProfit(nums2, 0, dp2)) ;
    }
}
