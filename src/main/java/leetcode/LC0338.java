package leetcode;

public class LC0338 {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        if (n >= 1) {
            dp[1] = 1;
        }
        int bound = 1;
        for (int i = 2; i <= n; i++) {
            if (i == 2 * bound) {
                bound = i;
                dp[i] = 1;
            } else {
                dp[i] = dp[i-bound] + 1;
            }
        }
        return dp;
    }
}
