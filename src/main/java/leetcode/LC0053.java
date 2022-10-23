package leetcode;

public class LC0053 {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            if (cur <= 0) {
                if (nums[i] >= 0) {
                    cur = nums[i];
                } else {
                    cur = 0;
                }
            } else {
                cur += nums[i];
                max = Math.max(max, cur);
            }
        }
        return max;
    }
}
