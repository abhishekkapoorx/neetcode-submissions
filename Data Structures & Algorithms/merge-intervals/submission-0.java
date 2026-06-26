class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> res  = new ArrayList<>();
        int[] curr = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] iter = intervals[i];
            if (curr[1] >= iter[0]) {
                curr[0] = Math.min(curr[0], iter[0]);
                curr[1] = Math.max(curr[1], iter[1]);
            } else {
                res.add(curr);
                curr = iter; 
            }
        }
        res.add(curr);

        return res.toArray(new int[0][]);
    }
}
