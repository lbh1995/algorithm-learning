package leetcode;

public class LC0153 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int leftNum = Integer.MAX_VALUE;
            int rightNum = Integer.MAX_VALUE;
            if (mid - 1 >= 0) {
                leftNum = nums[mid - 1];
            }
            if (mid + 1 <= right) {
                rightNum = nums[mid + 1];
            }
            if (nums[mid] < leftNum && nums[mid] < rightNum) {
                return nums[mid];
            }
            if (nums[mid] >= nums[left] && nums[mid] >= nums[right]) {
                left = mid + 1;
            } else if (nums[mid] >= nums[left] && nums[mid] <= nums[right]) {
                right = mid - 1;
            } else if (nums[mid] <= nums[left] && nums[mid] <= nums[right]) {
                right = mid - 1;
            }
        }
        return 0;
    }
}
