package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LC0497 {
    class Solution {
        int[][] rects;
        int[] nums;
        int sum = 0;
        Random random = new Random();

        public Solution(int[][] rects) {
            this.rects = rects;
            nums = new int[rects.length];
            for (int i = 0; i < nums.length; i++) {
                sum += (rects[i][3] - rects[i][1] + 1) * (rects[i][2] - rects[i][0] + 1);
                nums[i] = sum;
            }
        }

        public int[] pick() {
            int point = random.nextInt(sum);
            int left = 0;
            int right = nums.length;
            int mid = 0;
            while (left < right) {
                mid = (left + right) / 2;
                if (point > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (point > nums[mid]) {
                left = mid;
                right = mid + 1;
            } else {
                right = mid;
                left = mid - 1;
            }
            int[] rect = this.rects[right - 1];
            int col = rect[2] - rect[0] + 1;
            return new int[]{rect[0] + (point - nums[left]) % col, rect[1] + (point - nums[left]) / col};
        }
    }

    public static void main(String[] args) {
        int targ = 19;
        List<Integer> psum = new ArrayList<>();
        psum.add(4);
        psum.add(10);
        psum.add(19);
        psum.add(25);
        psum.add(29);
        int lo = 0;
        int hi = 5 - 1;
        while (lo != hi) {
            int mid = (lo + hi) / 2;
            if (targ >= psum.get(mid)) lo = mid + 1;
            else hi = mid;
        }
        System.out.println(lo);

//        int[] x = rects[lo];
//        int width = x[2] - x[0] + 1;
//        int height = x[3] - x[1] + 1;
//        int base = psum.get(lo) - width * height;
//        return new int[]{x[0] + (targ - base) % width, x[1] + (targ - base) / width};
    }
}
