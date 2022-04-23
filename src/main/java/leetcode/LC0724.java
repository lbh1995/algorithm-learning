package leetcode;

/**
 * @author liubinghui
 * @date 2022/4/17 10:59 上午
 */
public class LC0724 {
    public int pivotIndex(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        int left = 0;
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                left = 0;
                right = nums[nums.length - 1] - nums[i];
            } else if (i == nums.length -1) {
                left = nums[i-1];
                right = 0;
            } else {
                left = nums[i-1];
                right = nums[nums.length - 1] - nums[i];
            }
            if (left == right) {
                return i;
            }
        }
        return -1;
    }
}
