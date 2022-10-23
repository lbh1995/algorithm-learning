package leetcode;

public class LC0010 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        s = " " + s;
        p = " " + p;
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j + 1 <= n && pp[j] == '*') {
                    continue;
                } else if (i - 1 >= 0 && pp[j] != '*') {
                    dp[i][j] = dp[i - 1][j - 1] && (ss[i] == pp[j] || pp[j] == '.');
                } else if (pp[j] == '*') {
                    dp[i][j] = (j - 2 >= 0 && dp[i][j - 2]) || (i-1>=0 && dp[i-1][j] && (ss[i] == pp[j-1] || pp[j-1] =='.'));
                }
            }
        }
        return dp[m][n];
    }
}
