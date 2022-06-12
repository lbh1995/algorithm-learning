package leetcode;

import java.util.Arrays;

public class LC0698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        boolean[] used = new boolean[nums.length];
        int target = sum / k;
        Arrays.sort(nums);
        if (nums[nums.length - 1] > target) {
            return false;
        }
        return dfs(nums, k, target, used, 0, 0);
    }

    private boolean dfs(int[] nums, int k, int target, boolean[] used, int startIdx, int sum) {
        // k次搜索全部完成
        if (k == 0) {
            return true;
        }
        // 若果相等，则这次搜索成功，进行下次搜索
        if (sum == target) {
            return dfs(nums, k - 1, target, used, 0, 0);
        }
        // 每一次选择都只要处理未处理过的，排列A
        for (int i = startIdx; i < nums.length; i++) {
            // 经过排序，后面的都不用处理了，直接失败
            if (sum + nums[i] > target) {
                break;
            }
            // 只有没有使用过的才能往下走
            if (!used[i]) {
                used[i] = true;
                // 如果深搜成功，就全部成功
                if (dfs(nums, k, target, used, i + 1, sum + nums[i])) {
                    return true;
                }
                // 回溯
                used[i] = false;
                // 走到这边就是失败了，如果后面有相同case，就直接跳过，因为它们必定失败
                while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return false;
    }
}
