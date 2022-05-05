package leetcode;

public class LC0033 {
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] == nums[left] && nums[mid] == nums[right]) {
                left++;
                right--;
                continue;
            }
            // 看哪边是有序的
            // 这边为什么可以是等号呢，因为相等也是有序的，前面已经排除了所有的异常情况
            if (nums[mid] >= nums[left]) {
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
//            if (target >= nums[left]) {
//                if (nums[mid] >= nums[left]) {
//                    if (target >= nums[mid]) {
//                        left = mid + 1;
//                    } else {
//                        right = mid - 1;
//                    }
//                } else {
//                    right = mid - 1;
//                }
//            } else {
//                if (nums[mid] >= nums[left]) {
//                    left = mid + 1;
//                } else {
//                    if (target >= nums[mid]) {
//                        left = mid + 1;
//                    } else {
//                        right = mid - 1;
//                    }
//                }
//            }
        }
        return -1;
    }
}
