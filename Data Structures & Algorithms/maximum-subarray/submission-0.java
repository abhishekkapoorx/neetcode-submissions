class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] pre = new int[nums.length+1];

        for (int i = 0; i < nums.length; i++) {
            pre[i+1] = pre[i] + nums[i];
        }

        int maxSum = Integer.MIN_VALUE;
        int maxIdx = nums[nums.length-1];
        for (int i = nums.length-1; i >= 0; i--) {
            if (pre[i+1] > pre[maxIdx+1]) {
                maxIdx = i;
            }
            maxSum = Math.max(maxSum, pre[maxIdx+1] - pre[i+1]);
        }
        return maxSum;
    }
}
