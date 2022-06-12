package leetcode;

public class LC0122 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        // 0->持有股票，1->不持有股票
        int[][] dp = new int[2][prices.length];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[0][i] = Math.max(dp[1][i - 1] - prices[i], dp[0][i - 1]);
            dp[1][i] = Math.max(dp[0][i - 1] + prices[i], dp[1][i - 1]);
        }
        return Math.max(dp[0][prices.length - 1], dp[1][prices.length - 1]);
    }

    public static void main(String[] args) {
        LC0122 lc122 = new LC0122();
        lc122.maxProfit(new int[]{1,2,3,4,5});
    }
}
