package leetcode;

public class LC0978 {
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }
        int[] dp = new int[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] > 0) {
                dp[i - 1] = 1;
            } else if (arr[i] - arr[i - 1] < 0) {
                dp[i - 1] = -1;
            } else {
                dp[i - 1] = 0;
            }
        }
        int max = 0;
        int cur = dp[0] == 0 ? 0 : 1;
        for (int i = 1; i < dp.length; i++) {
            int trend = dp[i] * dp[i - 1];
            if (trend == -1) {
                cur++;
                max = Math.max(cur, max);
            } else if (trend == 1) {
                cur = 1;
            } else if (dp[i] != 0){
                cur = 1;
            } else {
                cur = 0;
            }
        }
        return max + 1;
    }
}
