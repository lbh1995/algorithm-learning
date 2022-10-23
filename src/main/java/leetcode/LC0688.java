package leetcode;

import java.math.BigDecimal;

public class LC0688 {
    public double knightProbability(int n, int k, int row, int column) {
        if (k == 0) {
            return 1;
        }
        int[][] dirs = new int[][]{{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
        int[][][] dp = new int[n][n][k+1];
        dp[row][column][0] = 1;
        for (int s = 0; s < k; s++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dp[i][j][s] == 0) {
                        continue;
                    }
                    for (int[] dir : dirs) {
                        int nr = i + dir[0];
                        int nc = j + dir[1];
                        if (0 <= nr && nr < n && 0 <= nc && nc < n) {
                            dp[nr][nc][s+1] += dp[i][j][s];
                        }
                    }
                }
            }
        }
        double all = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                all += dp[i][j][k];
            }
        }
        return all;
    }

    public static void main(String[] args) {
        LC0688 lc0688 = new LC0688();
        lc0688.knightProbability(25, 99, 0, 0);
    }
}
