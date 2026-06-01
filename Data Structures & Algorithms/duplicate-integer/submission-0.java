class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int freq = mp.getOrDefault(nums[i], 0);
            if (freq > 0) return true;
            else mp.put(nums[i], 1);
        } 
        return false;
    }
}