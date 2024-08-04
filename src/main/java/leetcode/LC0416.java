package leetcode;

public class LC0416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        int n = nums.length;
        int[][] dp = new int[n][target + 1];
        if (nums[0] < target) {
            dp[0][nums[0]] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                if (j == nums[0]) {
                    dp[i][j] = 0;
                    continue;
                }
                int last = j > nums[i] ? j - nums[i] : 0;
                if (dp[i - 1][last] == 1 || dp[i - 1][j] == 1) {
                    dp[i][j] = 1;
                }
            }
        }
        return dp[n - 1][target] == 1;
    }
}
