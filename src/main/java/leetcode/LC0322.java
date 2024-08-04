package leetcode;

public class LC0322 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = -1;
        }
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j < coins[i]) {
                    continue;
                }
                if (dp[j - coins[i]] != -1) {
                    int cur = dp[j] == -1 ? Integer.MAX_VALUE : dp[j];
                    dp[j] = Math.min(cur, dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount];
    }
}
