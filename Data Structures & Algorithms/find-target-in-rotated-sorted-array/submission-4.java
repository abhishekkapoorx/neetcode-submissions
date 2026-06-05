class Solution {
    private static int findPivot(int[] nums) {
        int n = nums.length;
        if (n == 1 || nums[0] < nums[n - 1]) return n - 1;

        int i = 0;
        int j = n - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] > nums[n - 1]) {  // Changed from nums[0]
                i = mid + 1;  // Changed from mid
            } else {
                j = mid;
            }
        }
        return i - 1;  // Return the last element of left portion
    }

    private static int binarySearch(int[] nums, int i, int j, int target) {
        while (i <= j) {  // Changed from i < j to i <= j
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;  // Changed from mid
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int pivot = findPivot(nums);
        
        // Check if target is in the left sorted portion
        if (target >= nums[0] && target <= nums[pivot]) {
            return binarySearch(nums, 0, pivot, target);
        }
        // Otherwise, search in the right sorted portion
        return binarySearch(nums, pivot + 1, nums.length - 1, target);
    }
}