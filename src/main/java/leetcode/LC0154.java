package leetcode;

public class LC0154 {
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;
        while (left <= right) {
            mid = (left + right) / 2;
//            if (nums[mid] == nums[left] && nums[mid] == nums[right]) {
//                left++;
//                right--;
//                continue;
//            }
//            int leftNum = Integer.MAX_VALUE;
//            int rightNum = Integer.MAX_VALUE;
//            if (mid - 1 >= 0) {
//                leftNum = nums[mid - 1];
//            }
//            if (mid + 1 <= right) {
//                rightNum = nums[mid + 1];
//            }
//            if (nums[mid] < leftNum && nums[mid] < rightNum) {
//                return nums[mid];
//            }
            // 这个条件必须在前面，不然会跟第二/三个条件重叠，case [1,2,2] [1,1,3]
//            if (nums[mid] >= nums[left] && nums[mid] <= nums[right]){
//                right = mid - 1;
//            } else if (nums[mid] >= nums[left] && nums[mid] >= nums[right]) {
//                left = mid + 1;
//            } else if (nums[mid] <= nums[left] && nums[mid] <= nums[right]) {
//                // case [2,0,1,1,1] [3,1,1]
//                if (nums[mid] == nums[left]) {
//                    left = mid + 1;
//                } else {
//                    right = mid - 1;
//                }
//            }
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid;
            } else {
                right -= 1;
            }
        }
        return nums[mid];
    }

    public static int findMinSimple(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right -= 1;
            }
        }
        return nums[mid];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{2,0,1,1,1}));
    }
}
