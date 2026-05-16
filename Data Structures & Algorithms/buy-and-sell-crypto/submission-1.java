class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int i = 0;
        int j = i + 1;
        while (j < prices.length) {
            if (prices[i] < prices[j]) {
                if (prices[j] - prices[i] > profit) {
                    profit = prices[j] - prices[i];
                }
                j++;
            } else {
                i = j;
                j = i + 1;
            }
        }
        return profit;
    }
}
