class Solution {
    private int getArea(int[] heights, int i, int j) {
        return (j - i) * Math.min(heights[i], heights[j]);
    }
    public int maxArea(int[] heights) {
        int n = heights.length;
        int i = 0, j = n-1;
        int maxWater = 0;
        while (i < j) {
            maxWater = Math.max(getArea(heights, i, j), maxWater);
            if (heights[i] < heights[j]) {
                i++;
            } else if (heights[i] > heights[j]){
                j--;
            } else {
                i++;
                j--;
            }
        }
        return maxWater;
        
    }
}
