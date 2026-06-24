class Solution {
    public int maxSubArray(int[] nums) {
        // if (nums.length == 1) return nums[0];
        // int[] pre = new int[nums.length+1];

        // for (int i = 0; i < nums.length; i++) {
        //     pre[i+1] = pre[i] + nums[i];
        // }

        // int maxSum = Integer.MIN_VALUE;
        // int maxIdx = nums.length;
        // for (int i = nums.length-1; i >= 0; i--) {
        //     if (pre[i+1] > pre[maxIdx]) {
        //         maxIdx = i+1;
        //     }
        //     maxSum = Math.max(maxSum, pre[maxIdx] - pre[i]);
        // }
        // return maxSum;

        int curr = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(nums[i], curr+nums[i]);
            ans = Math.max(curr, ans);
        }
        return ans;
    }
}
