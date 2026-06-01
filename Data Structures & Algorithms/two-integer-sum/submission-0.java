class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            int t2 = mp.getOrDefault(target - nums[i], - 1);
            if (t2 != -1) return new int[] {t2, i};
            mp.put(nums[i], i);
        }
        return new int[0];
    }
}
