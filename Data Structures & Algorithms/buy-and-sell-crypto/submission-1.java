class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minDay = prices[0];
        for (int i = 1; i < prices.length; i++) {
            minDay = Math.min(prices[i], minDay);
            maxProfit = Math.max(maxProfit, prices[i]-minDay);
        }
        return maxProfit;
    }
}
