package leetcode;

public class LC0279 {
    static int[] dp = new int[10000 + 1];
    static {
        int l = (int) Math.sqrt(10000);

        for (int i = 1; i <= l; i++) {
            for (int j = 1; j <= 10000; j++) {
                int m = i * i;
                if (j < m) {
                    continue;
                }
                int last = dp[j - m];
                int cur = dp[j] == 0 ? Integer.MAX_VALUE : dp[j];
                dp[j] = Math.min(last + 1, cur);
            }
        }
    }

    public int numSquares(int n) {
        return dp[n+1];
    }
}
