package leetcode;

public class LC0044 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        s = " " + s;
        p = " " + p;
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (pp[j] == '*') {
                    dp[i][j] = dp[i][j - 1] || (i > 0 && dp[i - 1][j]);
                } else {
                    dp[i][j] = i > 0 && dp[i - 1][j - 1] && (pp[j] == ss[i] || pp[j] == '?');
                }
            }
        }
        return dp[m][n];
    }
}
