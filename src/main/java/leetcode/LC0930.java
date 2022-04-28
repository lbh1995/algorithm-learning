package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class LC0930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer[]> map = new HashMap<>();
        int sum = nums[0] == 0 ? 0 : 1;
        int left = 0;
        int right = 0;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == 1) {
                map.put(sum, new Integer[]{left, right});
                sum += nums[i];
                left = i;
                right = i;
            } else {
                right ++;
            }
        }
        map.put(sum, new Integer[]{left, right});
        int count = 0;
        List<Integer> sort = map.keySet().stream().sorted().collect(Collectors.toList());
        for (Integer cur : sort) {
            Integer[] curPos = map.get(cur);
            Integer[] nextPos = map.get(cur + goal);
            if (goal == 0) {
                Integer[] goalPos = map.get(cur);
                if (goalPos != null) {
                    if (cur == 0) {
                        count += (goalPos[1] - goalPos[0] + 1) * (goalPos[1] - goalPos[0] + 2) / 2;
                    } else {
                        count += (goalPos[1] - goalPos[0]) * (goalPos[1] - goalPos[0] + 1) / 2;
                    }
                }
            } else {
                if (cur == goal) {
                    count += curPos[1] - curPos[0] + 1;
                }
                if (nextPos != null) {
                    count += (nextPos[1] - nextPos[0] + 1) * (curPos[1] - curPos[0] + 1);
                }
            }
        }
        return count;
    }
}
