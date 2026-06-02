class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] preMul = new int[n];
        int[] sufMul = new int[n];

        Arrays.fill(preMul, 1);
        Arrays.fill(sufMul, 1);

        int[] ans = new int[n];

        for (int i = 1; i < n; i++) {
            int backIdx = n - i - 1;
            preMul[i] = preMul[i-1] * nums[i-1];
            sufMul[backIdx] = sufMul[backIdx+1] * nums[backIdx+1];
        }

        for (int i = 0; i < n; i++) {
            ans[i] = preMul[i] * sufMul[i];
        }
        return ans;
    }
}  
