class Solution {
    private static int findPivot(int[] nums){
        int n = nums.length;
        if (n == 1 || nums[0] < nums[n-1]) return nums[n-1];

        int i = 0;
        int j = n - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] > nums[0]) {
                i = mid;
            }
            else {
                j = mid-1;
            }
        }
        return i;
    }
    private static int binarySearch(int[] nums, int i, int j, int target){
        int ans = -1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                ans = mid;
                return ans;
            }
            else if (nums[mid] < target){
                i = mid + 1;
            }
            else {
                j = mid;
            }
        }
        return ans;
    }
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        int leftS = binarySearch(nums, 0, pivot, target);
        int rightS = binarySearch(nums, pivot+1, nums.length-1, target);
        return leftS != -1 ? leftS : rightS;
    }
}
