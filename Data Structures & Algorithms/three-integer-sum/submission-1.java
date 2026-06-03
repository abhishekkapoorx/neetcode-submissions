class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length-2; i++) {
            if (nums[i] > 0) break;
            int j = i + 1; 
            int k = nums.length-1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    j++;
                    k--;
                    break;
                } else if (nums[i] < -(nums[j] + nums[k])) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return ans;

    }
}
