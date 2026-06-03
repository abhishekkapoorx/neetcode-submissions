class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // sort the array
        Arrays.sort(nums);

        // create the presence array
        HashMap<Integer, List<Integer>> hmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hmap.putIfAbsent(nums[i], new ArrayList<>());
            hmap.get(nums[i]).add(i);
        }

        // now traverse with 
        // i from start
    }
}
