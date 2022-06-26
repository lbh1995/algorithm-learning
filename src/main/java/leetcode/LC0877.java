package leetcode;

public class LC0877 {
    public boolean stoneGame(int[] piles) {
        int[][] dp = new int[piles.length][piles.length];
        for (int i = piles.length - 1; i >= 0; i--) {
            dp[i][i] = piles[i];
            for (int j = i + 1; j < piles.length; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        if (dp[0][piles.length - 1] > 0) {
            return true;
        }
        return false;
    }
}
