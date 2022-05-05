package leetcode;

public class LC0034 {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{searchLeft(nums, target), searchRight(nums, target)};
    }

    public int searchRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                if ((mid < right && nums[mid] < nums[mid + 1]) || mid == right - 1) {
                    return mid;
                }
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int searchLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                if ((mid > 1 && nums[mid] > nums[mid - 1]) || mid == 0) {
                    return mid;
                }
            }
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
