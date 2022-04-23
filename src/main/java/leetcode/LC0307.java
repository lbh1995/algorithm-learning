package leetcode;

/**
 * @author liubinghui
 * @date 2022/4/4 7:28 下午
 */
public class LC0307 {
    static class NumArray {
        int[] nums;
        int[] bit;
        int len = 0;

        public NumArray(int[] nums) {
            len = nums.length + 1;
            bit = new int[len];
            this.nums = nums;
            System.arraycopy(nums,0,bit,1,nums.length);
            for (int i = 1; i < len; i++) {
                int j = i + lowerBit(i);
                if (j < len) {
                    bit[j] = bit[j] + bit[i];
                }
            }
        }

        public void update(int index, int val) {
            int old = nums[index];
            nums[index] = val;
            index++;
            int delta = val - old;
            for (int i = index; i < len; i += lowerBit(i)) {
                bit[i] += delta;
            }
        }

        public int sumRange(int left, int right) {
            return query(right+1) - query(left);
        }

        private int lowerBit(int x) {
            return x & (-x);
        }

        private int query(int idx) {
            int sum = 0;
            for (int i = idx; i > 0; i -= lowerBit(i)) {
                sum += bit[i];
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1,3,5});
        numArray.sumRange(0,2);
        numArray.update(1,2);
        numArray.sumRange(0,2);
    }
}
