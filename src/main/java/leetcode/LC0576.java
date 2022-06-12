package leetcode;

public class LC0576 {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        final int MOD = 1000000007;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int count = 0;
        int[][] dp = new int[m][n];
        dp[startRow][startColumn] = 1;
        int[][] newDp;
        for (int i = 0; i < maxMove; i++) {
            newDp = new int[m][n];
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    int cur = dp[j][k];
                    if (cur <= 0) {
                        continue;
                    }
                    for (int[] dir : directions) {
                        int nextJ = j + dir[0];
                        int nextK = k + dir[1];
                        if (nextJ >= 0 && nextJ < m && nextK >= 0 && nextK < n) {
                            newDp[nextJ][nextK] = (newDp[nextJ][nextK] + cur) % MOD;
                        } else {
                            count = (count + cur) % MOD;
                        }
                    }
                }
            }
            dp = newDp;
        }
        return count;
    }

    public static void main(String[] args) {
        LC0576 lc0576 = new LC0576();
        lc0576.findPaths(4, 4, 3, 1, 1);
    }
}
