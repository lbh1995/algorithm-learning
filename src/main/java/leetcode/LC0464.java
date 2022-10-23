package leetcode;

public class LC0464 {
    int[] dp = new int[1 << 20];

    public boolean canIWin(int n, int t) {
        if (n * (n + 1) / 2 < t) {
            return false;
        }
        if (t == 0) {
            return true;
        }
        return dfs(0, 0, n, t) == 1;
    }

    private int dfs(int state, int cur, int n, int t) {
        if (dp[state] != 0) return dp[state];
        for (int i = 0; i < n; i++) {
            if (((state >> i) & 1) == 1) {
                continue;
            }
            if (cur + i + 1 >= t) {
                return dp[state] = 1;
            }
            if (dfs(state|(1<<i), cur + i + 1, n, t) == -1) {
                return dp[state] = 1;
            }
        }
        return dp[state] = -1;
    }

    public static void main(String[] args) {
        LC0464 lc0464 = new LC0464();
        System.out.println(lc0464.canIWin(1, 1));
    }
}
