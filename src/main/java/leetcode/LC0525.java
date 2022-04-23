package leetcode;

import java.util.*;

/**
 * @author liubinghui
 * @date 2022/4/16 8:07 下午
 */
public class LC0525 {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int max = 0;
        map.put(0,-1);
        for (int i = 0; i < nums.length; i++) {
            count = nums[i] == 1 ? count+1 : count-1;
            if (!map.containsKey(count)) {
                map.put(count, i);
            } else {
                int cur = i - map.get(count);
                max = Math.max(cur, max);
            }
        }
        return max;
    }
}
