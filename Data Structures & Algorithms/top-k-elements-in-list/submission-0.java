class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i: nums) mp.put(i, mp.getOrDefault(i, 0) + 1);

        List<Map.Entry<Integer, Integer>> map_list = new ArrayList<>(mp.entrySet());
        map_list.sort((a, b) -> b.getValue() - a.getValue());

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = map_list.get(i).getKey();
        }

        return ans;
    }
}
