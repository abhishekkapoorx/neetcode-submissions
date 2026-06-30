class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n * (n+1) / 2;
        int sumints = 0;
        for (int i: nums) sumints += i;
        return sum - sumints;
    }
}
