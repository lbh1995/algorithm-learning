package leetcode;

public class LC0045 {
    public int jump1(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                int nxt = i + j;
                int stp = dp[i] + 1;
                if (nxt < nums.length) {
                    if (dp[nxt] == 0) {
                        dp[nxt] = stp;
                    } else {
                        dp[nxt] = Math.min(dp[nxt], stp);
                    }
                }
            }
        }
        return dp[nums.length - 1];
    }

    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + nums[i]; j > i ; j--) {
                int stp = dp[i] + 1;
                if (j < nums.length) {
                    if (dp[j] == 0) {
                        dp[j] = stp;
                    } else {
                        break;
                    }
                }
            }
        }
        return dp[nums.length - 1];
    }
}
