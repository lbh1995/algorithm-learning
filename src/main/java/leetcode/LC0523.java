package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC0523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                nums[i] += nums[i - 1];
            }
            int key = nums[i] % k;
            if (key == 0 && i > 0) {
                return true;
            }
            if (map.containsKey(key)) {
                int lastPos = map.get(key);
                if (lastPos + 2 <= i) {
                    return true;
                }
            } else {
                map.put(key, i);
            }
        }
        return false;
    }
}
