package leetcode;

public class LC0552 {
    int[][][] mem;
    int mod = (int) (1e9 + 7);

    public int checkRecord(int n) {
        mem = new int[n + 1][2][3];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    mem[i][j][k] = -1;
                }
            }
        }
        return dfs(1, 0, 0, 0);
    }

    private int dfs(int n, int step, int aCnt, int lCnt) {
        if (aCnt > 1) {
            return 0;
        }
        if (lCnt > 2) {
            return 0;
        }
        if (step >= n) {
            return 1;
        }
        if (mem[step][aCnt][lCnt] != -1) {
            return mem[step][aCnt][lCnt];
        }
        int ans = 0;
        ans = (dfs(n, step + 1, aCnt, 0) % mod);
        ans = (ans + (dfs(n, step + 1, aCnt + 1, 0) % mod)) % mod;
        ans = (ans + (dfs(n, step + 1, aCnt, lCnt + 1) % mod)) % mod;
        mem[step][aCnt][lCnt] = ans;
        return ans;
    }
}
