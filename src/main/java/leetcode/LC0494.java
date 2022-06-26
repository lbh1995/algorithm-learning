package leetcode;

import java.util.Arrays;

public class LC0494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
            sum += nums[i];
        }
        target = Math.abs(target);
        if (sum < target || (sum - target) % 2 != 0) {
            return 0;
        }
        int tar = (sum - target) / 2;
        int[][] dp = new int[nums.length+1][tar+1];
        // tar为0说明只有一种情况，就是全都选中
        dp[0][0] = 1;
        for (int i=1;i<=nums.length;i++) {
            for (int j=0;j<=tar;j++) {
                // 多可选数据至少需要包含少可选数据的情况
                dp[i][j] += dp[i-1][j];
                if (j>=nums[i-1]) {
                    dp[i][j] += dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[nums.length][tar];
    }
}
