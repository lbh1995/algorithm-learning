package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LCP0007 {
    public int numWays(int n, int[][] relation, int k) {
        int[][] dp = new int[k + 1][n];
        int[][] map = new int[n][n];
        for (int[] r : relation) {
            map[r[0]][r[1]] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[1][i] = map[0][i] == 1 ? 1 : 0;
        }
        for (int step = 1; step < k; step++) {
            for (int i = 0; i < n; i++) {
                if (dp[step][i] != 0) {
                    for (int j = 0; j < n; j++) {
                        if (map[i][j] == 1) {
                            dp[step + 1][j] = dp[step][i] + 1 +dp[step + 1][j];
                        }
                    }
                }
            }
        }
        return dp[k][n - 1];
    }

    public static void main(String[] args) {
        int[][] r = new int[][]{{0, 2}, {2, 1}};
        LCP0007 lcp0007 = new LCP0007();
        lcp0007.numWays(3, r, 2);
    }
}
