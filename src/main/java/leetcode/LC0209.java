package leetcode;

/**
 * @author liubinghui
 * @date 2022/4/10 10:50 上午
 */
public class LC0209 {
    public int minSubArrayLen(int target, int[] nums) {
        int min = 0;
        if (nums[0] >= target) {
            return 1;
        }
        for(int i = 1; i<nums.length; i++) {
            nums[i] += nums[i-1];
            if (nums[i] >= target) {
                if (min == 0) {
                    min = i + 1;
                } else {
                    min = Math.min(i + 1, min);
                }
                bisection(min, nums, target, 0, i);
            }
        }
        return min;
    }

    private void bisection(int min, int[] nums, int target, int left, int right) {
        int bound = right;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[bound] - nums[mid] >= target) {
                min = Math.min(bound - mid + 1, min);
                left = right-left==1 ? right : mid;
            } else {
                right = right-left==1 ? left : mid;
            }
        }
    }

    public int minSubArrayLen1(int target, int[] nums) {
        int min = 0;
        int sum = 0;
        int left = 0;
        int right = 0;
        for (; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                if (min == 0) {
                    min = right - left + 1;
                } else {
                    min = Math.min(right - left + 1, min);
                }
                sum -= nums[left];
                left ++;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        LC0209 lc0209 = new LC0209();
        System.out.println(lc0209.minSubArrayLen(57,new int[]{1,4,4,3,6,2,7,14,15,1,15,1,7,3,4,3,12,8,6,3,8,7,3,5,6,6,2,3,4,18,2,15,9,4,2,4,6,9,6,6}));
    }
}
