package leetcode;

public class LC0650 {
    private static int[] dp = new int[101];
    private void init() {
        for (int i = 2; i <= 100; i++) {
            for (int j = 1; j < Math.pow(i,0.5)+1; j++) {
                if (i % j == 0) {
                    if (dp[i] == 0) {
                        dp[i] = (i / j) + dp[j];
                    } else {
                        dp[i] = Math.min((i / j) + dp[j], dp[i]);
                    }
                }
            }
        }
    }

    public int minSteps(int n) {
        return dp[n];
    }
}
