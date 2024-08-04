package leetcode;

public class LC0931 {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[2][n];
        dp[0] = matrix[0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int lastRow = (i - 1) % 2;
                int curRow = i % 2;
                int p1 = j > 0 ? dp[lastRow][j - 1] : Integer.MAX_VALUE;
                int p2 = dp[lastRow][j];
                int p3 = j < n - 1 ? dp[lastRow][j + 1] : Integer.MAX_VALUE;
                dp[curRow][j] = Math.min(Math.min(p1, p2), p3) + matrix[i][j];
            }
        }
        int row = (n - 1) % 2;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(dp[row][i], min);
        }
        return min;
    }
}
