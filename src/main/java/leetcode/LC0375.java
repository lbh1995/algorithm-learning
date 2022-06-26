package leetcode;

public class LC0375 {
    static int[][] all = new int[201][201];
    static {
        process(200);
    }

    public int getMoneyAmount(int n) {
        return all[1][n];
    }

    private static int process(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i > 0; i--) {
            for (int j = i + 1; j <= n; j++) {
                int min = Integer.MAX_VALUE;
                int epoch = 0;
                for (int mid = i; mid <= j; mid++) {
                    int ll = i;
                    int lr = mid - 1;
                    int rl = mid + 1;
                    int rr = j;
                    int ldp = 0;
                    int rdp = 0;
                    if (lr >= ll) {
                        ldp = dp[ll][lr];
                    }
                    if (rr >= rl) {
                        rdp = dp[rl][rr];
                    }
                    epoch = mid + Math.max(ldp, rdp);
                    min = Math.min(epoch, min);
                }
                dp[i][j] = min;
            }
        }
        all = dp;
        return dp[1][n];
    }

    public static void main(String[] args) {
        LC0375 lc0375 = new LC0375();
        lc0375.getMoneyAmount(5);
    }
}
