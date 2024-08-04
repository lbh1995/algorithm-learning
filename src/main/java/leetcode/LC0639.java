package leetcode;

public class LC0639 {
    public int numDecodings(String s) {
        char[] cs = s.toCharArray();
        int n = s.length();
        int mod = 10 << 9 + 7;
        int f[] = new int[3];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            int p1 = (i - 1) % 3;
            int p2 = (i - 2) % 3;
            int cnt = 0;
            int c = cs[i-1] - '0';
            for (int item = 1; item <= 26; item++) {
                if (item < 10) {
                    if (cs[i-1] == '*' || c == item) {
                        cnt = (cnt + f[p1]) % mod;
                    }
                } else {
                    if (i < 2) {
                        break;
                    }
                    char prev = cs[i - 2];
                    int d = prev - '0';
                    int a = item / 10;
                    int b = item % 10;
                    // 两位都要符合要求
                    if ((prev == '*' || a == d) && ((cs[i-1] == '*' && b != 0) || c == b)) {
                        cnt = (cnt + f[p2]) % mod;
                    }
                }
            }
            f[i % 3] = cnt;
        }
        return f[n%3];
    }

    public int numDecodings1(String s) {
        char[] cs = s.toCharArray();
        int n = s.length();
        int mod = 10 << 9 + 7;
        // dp0代表不跟前一个拼
        // dp1代表要跟前一个拼
        int[][] dp = new int[2][n];
        dp[0][0] = cs[0] == '0' ? 0 : (cs[0] == '*' ? 9 : 1);
        for (int i = 1; i < n; i++) {
            if (cs[i-1] == '0') {
                // 0只能跟前面拼
                dp[0][i] = 0;
                if (cs[i - 1] == '*') {
                    dp[1][i] = i >= 2 ? ((dp[0][i - 2] + dp[1][i - 2]) * 2 % mod) : 2;
                } else if (cs[i - 1] == '1' || cs[i - 1] == '2') {
                    dp[1][i] = dp[0][i - 1] % mod;
                }
            } else if (cs[i] == '*') {
                // 不拼的话，是之前的九倍
                dp[0][i] = ((dp[0][i - 1] + dp[1][i - 1]) % mod) * 9 % mod;
                if (cs[i - 1] == '1') {
                    // 这时候可以跟前面拼
                    dp[1][i] = dp[0][i - 1] * 9 % mod;
                } else if (cs[i - 1] == '2') {
                    // 这时候可以跟前面拼
                    dp[1][i] = dp[0][i - 1] * 6 % mod;
                } else if (cs[i - 1] == '*') {
                    dp[1][i] = i >= 2 ? ((dp[0][i - 2] + dp[1][i - 2]) * 15 % mod) : 15;
                } else {
                    dp[1][i] = 0;
                }
            } else {
                // 其他数字，按拼和不拼分类讨论
                dp[0][i] = (dp[0][i - 1] + dp[1][i - 1]) % mod;
                if (cs[i - 1] == '1' || (cs[i - 1] == '2' && cs[i] < '7')) {
                    // 这时候可以跟前面拼
                    dp[1][i] = dp[0][i - 1];
                } else if (cs[i - 1] == '*') {
                    dp[1][i] = i >= 2 ? ((dp[0][i - 2] + dp[1][i - 2]) * 2 % mod) : 2;
                } else {
                    dp[1][i] = 0;
                }
            }
        }
        return dp[0][n - 1] + dp[1][n - 1];
    }
}
