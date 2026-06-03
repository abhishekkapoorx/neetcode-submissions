class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int i = 0, j = n-1;
        int maxProfit = 0;

        while (i < j) {
            maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            if (prices[i] > prices[j]) i++;
            else if (prices[i] < prices[j]) j--;
            else {
                i++;
                j--;
            }
        }
        return maxProfit;
    }
}
