package leetcode;

public class LC0121 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int max = prices[prices.length - 1];
        int profit = 0;
        for (int i = prices.length - 2; i >= 0; i--) {
            if (prices[i] > max) {
                max = prices[i];
            } else {
                profit = Math.max(max - prices[i], profit);
            }
        }
        return profit;
    }
}
