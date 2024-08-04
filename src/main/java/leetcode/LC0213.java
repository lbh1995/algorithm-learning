package leetcode;

public class LC0213 {
    public int rob(int[] nums) {
        int[][] dp1 = new int[nums.length][2];
        dp1[0][0] = nums[0];
        for (int i = 1;i<nums.length;i++) {
            if (i == 1) {
                dp1[i][0] = nums[0];
                dp1[i][1] = nums[0];
            } else {
                dp1[i][0] = dp1[i-1][1] + nums[i];
                dp1[i][1] = Math.max(dp1[i-1][0], dp1[i-1][1]);
            }
        }
        int max1 = nums.length>1? Math.max(dp1[nums.length-2][0], dp1[nums.length-2][1]) : nums[0];
        int[][] dp2 = new int[nums.length][2];
        for (int i = 1;i<nums.length;i++) {
            dp2[i][0] = dp2[i-1][1] + nums[i];
            dp2[i][1] = Math.max(dp2[i-1][0], dp2[i-1][1]);
        }
        int max2 = Math.max(dp2[nums.length-1][0], dp2[nums.length-1][1]);
        return Math.max(max1, max2);
    }
}
