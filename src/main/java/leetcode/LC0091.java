package leetcode;

public class LC0091 {
    public int numDecodings(String s) {
        char[] cs = s.toCharArray();
        int n = s.length();
        // dp0代表不跟前一个拼
        // dp1代表要跟前一个拼
        int[][] dp = new int[2][n];
        dp[0][0] = cs[0] == '0' ? 0 : 1;
        for (int i = 1; i < n; i++) {
            if (cs[i] == '0') {
                // 0只能跟前面拼
                dp[0][i] = 0;
                dp[1][i] = dp[0][i - 1];
            } else {
                // 其他数字，按拼和不拼分类讨论
                dp[0][i] = dp[0][i - 1] + dp[1][i - 1];
                if (cs[i - 1] == '1' || (cs[i - 1] == '2' && cs[i] < '7')) {
                    // 这时候可以跟前面拼
                    dp[1][i] = dp[0][i - 1];
                } else {
                    dp[1][i] = 0;
                }
            }
        }
        return dp[0][n - 1] + dp[1][n - 1];
    }
}
