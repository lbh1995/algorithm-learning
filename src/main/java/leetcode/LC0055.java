package leetcode;

public class LC0055 {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length <= 1) {
            return true;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && dp[i] == 0) {
                return false;
            }
            int stp = nums[i] + i;
            stp = Math.min(nums.length - 1, stp);
            for (int j = stp; j > i; j--) {
                if (dp[stp] == 0) {
                    dp[stp] = dp[i] + 1;
                } else {
                    break;
                }
            }
        }
        return dp[nums.length - 1] != 0;
    }
}
