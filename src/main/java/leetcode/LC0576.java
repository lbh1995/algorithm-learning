package leetcode;

public class LC0576 {
    public int findPaths1(int m, int n, int maxMove, int startRow, int startColumn) {
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

    public int findPaths2(int m, int n, int maxMove, int startRow, int startColumn) {
        if (maxMove == 0) {
            return 0;
        }
        int MOD = 1000000007;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][][] mem = new int[m][n][maxMove];
        for (int k = 0; k < maxMove; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0) {
                        mem[i][j][k]++;
                    }
                    if (j == 0) {
                        mem[i][j][k]++;
                    }
                    if (i == m - 1) {
                        mem[i][j][k]++;
                    }
                    if (j == n - 1) {
                        mem[i][j][k]++;
                    }
                }
            }
        }
        for (int k = 0; k < maxMove - 1; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] dir : directions) {
                        int nextI = i + dir[0];
                        int nextJ = j + dir[1];
                        if (nextJ >= 0 && nextJ < n && nextI >= 0 && nextI < m) {
                            mem[nextI][nextJ][k + 1] = (mem[nextI][nextJ][k + 1] + mem[i][j][k]) % MOD;
                        }
                    }
                }
            }
        }
        return mem[startRow][startColumn][maxMove - 1];
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if (maxMove == 0) {
            return 0;
        }
        int mod = 1000000007;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][][] dp = new int[m][n][maxMove + 1];
        for (int k = 1; k <= maxMove; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0) {
                        dp[i][j][k]++;
                    }
                    if (j == 0) {
                        dp[i][j][k]++;
                    }
                    if (i == m - 1) {
                        dp[i][j][k]++;
                    }
                    if (j == n - 1) {
                        dp[i][j][k]++;
                    }
                }
            }
        }
        for (int k = 2; k <= maxMove; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] dir : directions) {
                        int lastI = i - dir[0];
                        int lastJ = j - dir[1];
                        if (lastI >= 0 && lastI < m && lastJ >= 0 && lastJ < n) {
                            dp[i][j][k] = (dp[lastI][lastJ][k-1] + dp[i][j][k]) % mod;
                        }
                    }
                }
            }
        }
        return dp[startRow][startColumn][maxMove];
    }

    public static void main(String[] args) {
        LC0576 lc0576 = new LC0576();
        lc0576.findPaths(4, 4, 3, 1, 1);
    }
}
