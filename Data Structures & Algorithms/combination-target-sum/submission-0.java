class Solution {

    private void findTarget(int[] nums, int i, int sum, int target,
                            List<Integer> ls, List<List<Integer>> res) {

        if (sum == target) {
            res.add(new ArrayList<>(ls));
            return;
        }

        if (i >= nums.length || sum > target) {
            return;
        }

        // take
        ls.add(nums[i]);
        findTarget(nums, i, sum + nums[i], target, ls, res);

        // backtrack
        ls.remove(ls.size() - 1);

        // not take (move to next index)
        findTarget(nums, i + 1, sum, target, ls, res);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        findTarget(nums, 0, 0, target, new ArrayList<>(), res);
        return res;
    }
}